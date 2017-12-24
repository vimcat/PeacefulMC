package com.vimcat.peacefulmc;

import com.vimcat.peacefulmc.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
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

  public static final CreativeTabs modTab = new CreativeTabs(MODID) {
    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getTabIconItem() {
      return new ItemStack(Items.SLIME_BALL);
    }
  };

  @Mod.Instance(PeacefulMC.MODID)
  public static PeacefulMC instance;
  public static Logger logger = LogManager.getLogger(PeacefulMC.MODID);

  public static Config config;

  @Mod.EventHandler
  public void onServerStarting(FMLServerStartingEvent event) {
    proxy.onServerStarting(event);
  }

  @Mod.EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    config = new Config(new Configuration(event.getSuggestedConfigurationFile()));
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
