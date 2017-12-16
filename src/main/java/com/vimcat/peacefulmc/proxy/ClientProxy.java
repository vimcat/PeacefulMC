package com.vimcat.peacefulmc.proxy;

import com.vimcat.peacefulmc.ModBlocks;
import com.vimcat.peacefulmc.ModItems;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy {
  public void onServerStarting(FMLServerStartingEvent event) {

  }

  public void onPreInit(FMLPreInitializationEvent event) {
    super.onPreInit(event);
  }

  public void onInit(FMLInitializationEvent event) {
    super.onInit(event);


  }

  public void onPostInit(FMLPostInitializationEvent event) {
    super.onPostInit(event);
  }

  public void onServerStopping(FMLServerStoppingEvent event) {
    super.onServerStopping(event);
  }

  @SubscribeEvent
  public static void registerModels(ModelRegistryEvent event) {
    ModBlocks.initModels();
    ModItems.initModels();
  }
}
