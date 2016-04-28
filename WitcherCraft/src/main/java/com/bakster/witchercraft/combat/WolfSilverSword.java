package com.bakster.witchercraft.combat;

import java.util.List;

import com.bakster.witchercraft.WitcherCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;

public class WolfSilverSword extends ItemSword {

	
	public WolfSilverSword() {
		super(WitcherCraft.WITCHER_SILVER);
		
        setCreativeTab(WitcherCraft.tabWitcherCombat);
        setTextureName(WitcherCraft.MODID + ":" + "wolfsilversword");
        setUnlocalizedName("wolfsilversword");
	}
	
	@Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
    	list.add(EnumChatFormatting.RED + "Guild wolf");
    	
    	
    }

}
