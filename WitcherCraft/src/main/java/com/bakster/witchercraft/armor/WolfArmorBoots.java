package com.bakster.witchercraft.armor;

import java.util.List;

import com.bakster.witchercraft.WitcherCraft;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.EnumChatFormatting;

public class WolfArmorBoots extends ItemArmor {

	public String textureName;

	public WolfArmorBoots(String unlocalizedName, ArmorMaterial material, String textureName, int type) {
	    super(material, 0, type);
	    this.textureName = textureName;
	    this.setUnlocalizedName(unlocalizedName);
	    this.setTextureName(WitcherCraft.MODID + ":" + unlocalizedName);
	    this.setCreativeTab(WitcherCraft.tabWitcherCombat);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
	    return WitcherCraft.MODID + ":textures/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(EnumChatFormatting.RED + "Guild wolf");
		
		
	}
}
