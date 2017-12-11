package com.vimcat.peacefulmc;

import com.vimcat.peacefulmc.blocks.BlockRegistry;
import com.vimcat.peacefulmc.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;


@Mod(modid = PeacefulMC.MODID, name = PeacefulMC.MODNAME, version = PeacefulMC.VERSION,
  dependencies = "required-after:forge@[" + PeacefulMC.MIN_FORGE_VERSION + ",)")
public class PeacefulMC {
  public static final String MODID = "peacefulmc";
  public static final String MODNAME = "PeacefulMC";
  public static final String VERSION = "0.0.1";
  public static final String MIN_FORGE_VERSION = "11.16.0.1865";

  @SidedProxy(clientSide = "com.vimcat.peacefulmc.proxy.ClientProxy", serverSide = "com.vimcat.peacefulmc.proxy.ServerProxy")
  public static CommonProxy proxy;

  @Mod.Instance
  public static PeacefulMC instance;

  public static Logger logger;

  public static final CreativeTabs modTab = new CreativeTabs(PeacefulMC.MODID) {
    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getTabIconItem() {
      return new ItemStack(BlockRegistry.compostItemBlock);
    }
  };

  @Mod.EventHandler
  public void preInit(FMLPreInitializationEvent e) {
    logger = e.getModLog();
    proxy.preInit(e);
  }

  @Mod.EventHandler
  public void init(FMLInitializationEvent e) {
    proxy.init(e);
  }

  @Mod.EventHandler
  public void postInit(FMLPostInitializationEvent e) {
    proxy.postInit(e);
  }
}
