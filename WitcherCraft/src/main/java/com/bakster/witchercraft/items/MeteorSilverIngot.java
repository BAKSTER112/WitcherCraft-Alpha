package com.bakster.witchercraft.items;

import com.bakster.witchercraft.WitcherCraft;

import net.minecraft.item.Item;

public class MeteorSilverIngot extends Item {
	public MeteorSilverIngot() {
        maxStackSize = 64;
        setCreativeTab(WitcherCraft.tabWitcherItems);
        setTextureName(WitcherCraft.MODID + ":" + "meteorsilver_ingot");
        setUnlocalizedName("meteorSilver_ingot");
	}
}
