package com.vimcat.peacefulmc.proxy;

import com.vimcat.peacefulmc.Config;
import com.vimcat.peacefulmc.ModBlocks;
import com.vimcat.peacefulmc.blocks.FossilOre;
import com.vimcat.peacefulmc.items.WorldGen;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;

@Mod.EventBusSubscriber
public class CommonProxy {
  public static Configuration config;
  public void onServerStarting(FMLServerStartingEvent event) {

  }

  public void onPreInit(FMLPreInitializationEvent event) {
    File directory = event.getModConfigurationDirectory();
    config = new Configuration(new File(directory.getPath(), "peacefulmc.cfg"));
    Config.readConfig();
  }

  public void onInit(FMLInitializationEvent event) {
    if (config.hasChanged()) {
      config.save();
    }
    GameRegistry.registerWorldGenerator(new WorldGen(), 0);
  }

  public void onPostInit(FMLPostInitializationEvent event) {

  }

  public void onServerStopping(FMLServerStoppingEvent event) {

  }

  @SubscribeEvent
  public static void registerItems(RegistryEvent.Register<Item> event) {
    event.getRegistry().register(new ItemBlock(ModBlocks.FossilOre).setRegistryName(ModBlocks.FossilOre.getRegistryName()));
  }

  @SubscribeEvent
  public static void registerBlocks(RegistryEvent.Register<Block> event) {
    event.getRegistry().register(new FossilOre());
  }
}
