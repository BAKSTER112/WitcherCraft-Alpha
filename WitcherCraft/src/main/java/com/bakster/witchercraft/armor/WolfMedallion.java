package com.bakster.witchercraft.armor;

import java.util.List;

import com.bakster.witchercraft.WitcherCraft;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class WolfMedallion extends ItemArmor {
	public String textureName;

	public WolfMedallion(String unlocalizedName, ArmorMaterial material, String textureName, int type) {
	    super(material, 0, type);
	    this.textureName = textureName;
	    this.setUnlocalizedName(unlocalizedName);
	    
	    this.setTextureName(WitcherCraft.MODID + ":" + unlocalizedName);
	    this.setCreativeTab(WitcherCraft.tabWitcherItems);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
	    return WitcherCraft.MODID + ":textures/armor/" + this.textureName + "_1.png";
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(EnumChatFormatting.RED + "Guild wolf");
		
		
	}
	
	@Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack armor)
    {
        player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 500, 1, true));
    }
}
