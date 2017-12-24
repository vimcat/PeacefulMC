package com.vimcat.peacefulmc.proxy;

import com.vimcat.peacefulmc.ItemModels;
import com.vimcat.peacefulmc.ItemRenderRegister;
import net.minecraftforge.fml.common.event.*;

public class ClientProxy extends CommonProxy {
  public void onServerStarting(FMLServerStartingEvent event) {

  }

  public void onPreInit(FMLPreInitializationEvent event) {
    super.onPreInit(event);
    ItemModels.preInit();
  }

  public void onInit(FMLInitializationEvent event) {
    super.onInit(event);
    ItemModels.init();
    ItemRenderRegister.registerItemRenderer();
  }

  public void onPostInit(FMLPostInitializationEvent event) {
    super.onPostInit(event);
  }

  public void onServerStopping(FMLServerStoppingEvent event) {
    super.onServerStopping(event);
  }
}
