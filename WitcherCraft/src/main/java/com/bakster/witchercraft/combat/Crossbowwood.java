package com.bakster.witchercraft.combat;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.bakster.witchercraft.WitcherCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class Crossbowwood extends ItemBow {

	public static final String[] bowPullIconNames = new String[] {"woodcrossbow_pulling_0", "woodcrossbow_pulling_1", "woodcrossbow_pulling_2"};
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
   

    public Crossbowwood()
    {
    	super();
    	this.setUnlocalizedName("crossbowWood");
        this.maxStackSize = 1;
        this.setMaxDamage(200);
        this.setCreativeTab(WitcherCraft.tabWitcherCombat);
        

    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int time)
    {
    	int maxItemUse = getMaxItemUseDuration(stack) - time;
        ArrowLooseEvent event = new ArrowLooseEvent(player, stack, maxItemUse);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()) return;
        maxItemUse = event.charge;
        
        boolean infiniteAmmo = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;
       
        if (infiniteAmmo || player.inventory.hasItem(Items.arrow)) {
            float scaledItemUse = (float) maxItemUse / 20.0F;
            scaledItemUse = (scaledItemUse * scaledItemUse + scaledItemUse * 2) / 3;
            if ((double) scaledItemUse < 0.1) return;
            if (scaledItemUse > 1) scaledItemUse = 1;
            
            
            EntityArrow entityarrow = new EntityArrow(world, player, scaledItemUse * 3.0F);
            
           // if (scaledItemUse == 1.0F) entityarrow.setIsCritical(true);
            
            int powerLevel = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);
            
            if (powerLevel > 0) entityarrow.setDamage(entityarrow.getDamage() + (double) powerLevel * 0.5 + 0.5);
            
            int punchLevel = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);
            
            if (punchLevel > 0) entityarrow.setKnockbackStrength(punchLevel);
            
            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0) entityarrow.setFire(100);
            stack.damageItem(1, player);
            
            world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + scaledItemUse * 0.5F);
            if (infiniteAmmo) 
            	entityarrow.canBePickedUp = 2;
            else 
            	player.inventory.consumeInventoryItem(Items.arrow);
            if (!world.isRemote) 
            	world.spawnEntityInWorld(entityarrow);
        }
    }

    @Override
    public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
    {
        return p_77654_1_;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 72000;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.bow;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
    	ArrowNockEvent event = new ArrowNockEvent(player, stack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return event.result;
        }

        if (player.capabilities.isCreativeMode || player.inventory.hasItem(Items.arrow))
        {
            player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        }

        return stack;
    }
    
    @Override
    public int getItemEnchantability()
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister icons)
    {
        this.itemIcon = icons.registerIcon(WitcherCraft.MODID + ":" + "woodcrossbow_standby");
        this.iconArray = new IIcon[bowPullIconNames.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = icons.registerIcon(WitcherCraft.MODID + ":" + bowPullIconNames[i]);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(int par1)
    {
        return this.iconArray[par1];
    }
    
    /*@Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
    	if(this.getMaxDamage() == -1) list.add(EnumChatFormatting.BLUE + "Infinite Uses");
    	else list.add(EnumChatFormatting.GREEN + "" + (stack.getMaxDamage() - stack.getItemDamage()) + " Uses Remaining");
    	list.add(EnumChatFormatting.RED + "" + damage + " Minimum Ranged Damage");
    }*/
    
    @Override
    public boolean isFull3D(){
    	return true;
    }
    
    @Override
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        if (player.getItemInUse() == null) return itemIcon;
        int pulling = stack.getMaxItemUseDuration() - useRemaining;
        if (pulling >= 18) return iconArray[2];
        if (pulling > 13) return iconArray[1];
        return iconArray[0];
    }
    

}

