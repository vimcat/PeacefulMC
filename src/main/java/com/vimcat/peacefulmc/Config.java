package com.vimcat.peacefulmc;

import com.vimcat.peacefulmc.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class Config {
  private static final String CATEGORY_GENERAL = "general";
  private static final String CATEGORY_DIMENSIONS = "dimensions";

  public static void readConfig() {
    Configuration cfg = CommonProxy.config;
    try {
      cfg.load();
      initGeneralConfig(cfg);
      initDimensionConfig(cfg);
    } catch (Exception event) {
      PeacefulMC.logger.log(Level.ERROR, "Problem loading config file", event);
    } finally {
      if (cfg.hasChanged()) {
        cfg.save();
      }
    }
  }

  private static void initGeneralConfig(Configuration cfg) {
    cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");

  }

  public static void initDimensionConfig(Configuration cfg) {
    cfg.addCustomCategoryComment(CATEGORY_DIMENSIONS, "Dimension configuration");

  }
}
