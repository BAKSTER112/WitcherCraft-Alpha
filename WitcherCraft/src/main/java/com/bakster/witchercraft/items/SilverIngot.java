package com.bakster.witchercraft.items;

import com.bakster.witchercraft.WitcherCraft;

import net.minecraft.item.Item;

public class SilverIngot extends Item {
	public SilverIngot() {
        maxStackSize = 64;
        setCreativeTab(WitcherCraft.tabWitcherItems);
        setTextureName(WitcherCraft.MODID + ":" + "meteorsilver_ingot");
        setUnlocalizedName("silver_ingot");
	}
}
