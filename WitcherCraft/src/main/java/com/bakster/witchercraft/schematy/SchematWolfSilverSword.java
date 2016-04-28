package com.bakster.witchercraft.schematy;

import java.util.Random;

import com.bakster.witchercraft.WitcherCraft;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;

public class SchematWolfSilverSword extends Item {
	public SchematWolfSilverSword() {
        maxStackSize = 64;
        setCreativeTab(WitcherCraft.tabWitcherSchematy);
        setTextureName(WitcherCraft.MODID + ":" + "schemat");
        setUnlocalizedName("schematWolfSilverSword");
	}
	
	
}

