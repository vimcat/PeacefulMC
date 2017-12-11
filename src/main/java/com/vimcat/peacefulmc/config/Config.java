package com.vimcat.peacefulmc.config;

import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;
import com.vimcat.peacefulmc.PeacefulMC;
import com.vimcat.peacefulmc.proxy.CommonProxy;

public class Config {
  private static final String CATEGORY_GENERAL = "general";
  private static final String CATEGORY_DIMENSIONS = "dimensions";

  public static void readConfig() {
    Configuration cfg = CommonProxy.config;
    try {
      cfg.load();
      initGeneralConfig(cfg);
      initDimensionConfig(cfg);
    } catch (Exception e) {
      PeacefulMC.logger.log(Level.ERROR, "Problem loading config file!", e);
    } finally {
      if (cfg.hasChanged()) {
        cfg.save();
      }
    }
  }

  private static void initGeneralConfig(Configuration cfg) {
    cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
  }

  private static void initDimensionConfig(Configuration cfg) {
    cfg.addCustomCategoryComment(CATEGORY_DIMENSIONS, "Dimension configuration");
  }
}
