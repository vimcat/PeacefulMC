package com.vimcat.peacefulmc;

import com.vimcat.peacefulmc.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(modid = PeacefulMC.MODID, name = PeacefulMC.MODNAME, version = PeacefulMC.VERSION,
  dependencies = "required-after:forge@[" + PeacefulMC.MIN_FORGE_VERSION + ",)")
public class PeacefulMC {
  public static final String MODID = "peacefulmc";
  public static final String MODNAME = "PeacefulMC";
  public static final String VERSION = "0.0.1";
  public static final String MIN_FORGE_VERSION = "11.16.0.1865";

  @SidedProxy(clientSide = "com.vimcat.peacefulmc.proxy.ClientProxy", serverSide = "com.vimcat.peacefulmc.proxy.CommonProxy")
  public static CommonProxy proxy;

  @Mod.Instance(PeacefulMC.MODID)
  public static PeacefulMC instance;
  public static Logger logger = LogManager.getLogger(PeacefulMC.MODID);

  @Mod.EventHandler
  public void onServerStarting(FMLServerStartingEvent event) {
    proxy.onServerStarting(event);
  }

  @Mod.EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    logger = event.getModLog();
    proxy.onPreInit(event);
  }

  @Mod.EventHandler
  public void onInit(FMLInitializationEvent event) {
    proxy.onInit(event);
  }

  @Mod.EventHandler
  public void onPostInit(FMLPostInitializationEvent event) {
    proxy.onPostInit(event);
  }

  @Mod.EventHandler
  public void onServerStopping(FMLServerStoppingEvent event) {
    proxy.onServerStopping(event);
  }
}
