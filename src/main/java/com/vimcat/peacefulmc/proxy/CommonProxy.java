package com.vimcat.peacefulmc.proxy;

import com.vimcat.peacefulmc.*;
import com.vimcat.peacefulmc.items.GeneralOreRegistry;
import com.vimcat.peacefulmc.items.WorldGen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;

@Mod.EventBusSubscriber
public class CommonProxy {
  public void onServerStarting(FMLServerStartingEvent event) {

  }

  public void onPreInit(FMLPreInitializationEvent event) {
    CropRegistry.registerCrops();
    BlockRegistry.initBlockRegistry();
    MinecraftForge.EVENT_BUS.register(new BlockRegistry());
    ItemRegistry.registerItems();
    MinecraftForge.EVENT_BUS.register(new ItemRegistry());
  }

  public void onInit(FMLInitializationEvent event) {
    GameRegistry.registerWorldGenerator(new WorldGen(), 0);
    onBlocksAndItemsLoaded();
  }

  public void onPostInit(FMLPostInitializationEvent event) {

  }

  public void onServerStopping(FMLServerStoppingEvent event) {

  }

  public void onBlocksAndItemsLoaded() {
    GeneralOreRegistry.initOreRegistry();
    RecipeRegistry.registerRecipes();
    SeedDropRegistry.getSeedDrops();
  }
}
