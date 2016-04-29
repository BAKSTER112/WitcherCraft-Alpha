package com.bakster.witchercraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;


import com.bakster.witchercraft.*;
import com.bakster.witchercraft.armor.WolfArmorBoots;
import com.bakster.witchercraft.armor.WolfArmorChest;
import com.bakster.witchercraft.armor.WolfArmorLeggings;
import com.bakster.witchercraft.armor.WolfMedallion;
import com.bakster.witchercraft.combat.*;
import com.bakster.witchercraft.proxy.*;
import com.bakster.witchercraft.items.*;
import com.bakster.witchercraft.schematy.*;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = WitcherCraft.MODID, version = WitcherCraft.VERSION)

public class WitcherCraft {


    public static final String MODID = "WitcherCraft";
    public static final String VERSION = "1.0";
    
    @SidedProxy(clientSide = "com.bakster.witchercraft.proxy.ClientProxy", serverSide = "com.bakster.witchercraft.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    @Instance(MODID)
   	public static WitcherCraft instance;
    
   
	
    public static CreativeTabs tabWitcherCombat = new CreativeTabs("tabWitcherCombat") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			
			
			ItemStack iStack = new ItemStack(WitcherCraft.wolfSilverSword);
	        return iStack.getItem();
		}
	};
	
	public static CreativeTabs tabWitcherItems = new CreativeTabs("tabWitcherItems") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			
			
			ItemStack iStack = new ItemStack(WitcherCraft.meteorSilver_ingot);
	        return iStack.getItem();
		}
	};
	
	public static CreativeTabs tabWitcherSchematy = new CreativeTabs("tabWitcherSchematy") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			
			
			ItemStack iStack = new ItemStack(WitcherCraft.schematWolfSilverSword);
	        return iStack.getItem();
		}
	};
    
    //material
	public static ToolMaterial WITCHER_SILVER = EnumHelper.addToolMaterial("WITCHER_SILVER", 0, 4000, 1.0F, 10.0F, 0);
	public static ArmorMaterial WOLF_ARMOR = EnumHelper.addArmorMaterial("WOLF_ARMOR", 40, new int[] {3, 8, 6, 3}, 30);
	public static ArmorMaterial MEDALLION_MATERIAL = EnumHelper.addArmorMaterial("MEDALLION_MATERIAL", 20000, new int[] {1, 1, 1, 1}, 0);
	
    //itemy
	public static Item meteorSilver_ingot;
	public static Item silver_ingot;
	
	
	//bron
	public static Item crossbowWood;
	public static Item wolfSilverSword;
	
	
	//zborje
	public static Item wolfMedallion;
	
	public static Item wolfArmorChest;
	public static Item wolfArmorBoots;
	public static Item wolfArmorLeggings;
	
	
	//schemat
	public static Item schematWolfSilverSword;
	
	
    
    @EventHandler
	public void preInit(FMLPreInitializationEvent event){
    	
    	//itemy
    	meteorSilver_ingot = new MeteorSilverIngot();
    	silver_ingot = new SilverIngot();
    	
    	
    	//bron
    	wolfSilverSword = new WolfSilverSword();
    	crossbowWood = new Crossbowwood();
    	
    	
    	//zbroje
    	wolfArmorChest = new WolfArmorChest("wolfArmorChest", WOLF_ARMOR, "wolfguild", 1);
    	wolfArmorBoots = new WolfArmorBoots("wolfArmorBoots", WOLF_ARMOR, "wolfguild", 3);
    	wolfArmorLeggings = new WolfArmorLeggings("wolfArmorLeggings", WOLF_ARMOR, "wolfguild", 2);
    	
    	wolfMedallion = new WolfMedallion("wolfMedallion", MEDALLION_MATERIAL, "wolfguild", 0);
    	
    	//schematy
    	schematWolfSilverSword = new SchematWolfSilverSword();
    	
    	
    	
    	
    	
    	
    	//bloki
		
		//naphthaGenerator = new NaphthaGenerator().setCreativeTab(BaksCraft.tabBaksMachines).setBlockName("naphthaGenerator");
	}
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	//itemy
    	GameRegistry.registerItem(meteorSilver_ingot, "meteorSilver_ingot");
    	GameRegistry.registerItem(silver_ingot, "silver_ingot");
    	
    	//bronie
    	GameRegistry.registerItem(wolfSilverSword, "wolfSilverSword");
    	GameRegistry.registerItem(crossbowWood, "Crossbowwood");
    	
    	//zbroje
    	GameRegistry.registerItem(wolfArmorChest, "wolfArmorChest"); 
    	GameRegistry.registerItem(wolfArmorBoots, "wolfArmorBoots"); 
    	GameRegistry.registerItem(wolfArmorLeggings, "wolfArmorLeggings"); 
    	GameRegistry.registerItem(wolfMedallion, "wolfMedallion"); 
    	
    	//schematy
    	GameRegistry.registerItem(schematWolfSilverSword, "schematWolfSilverSword");
    	
    	//GameRegistry.registerBlock(copperOre, "copperOre");
    	
    	
    	
    	
    	
		
    }
}
