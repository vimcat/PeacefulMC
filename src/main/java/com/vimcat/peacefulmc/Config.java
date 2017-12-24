package com.vimcat.peacefulmc;

import com.vimcat.peacefulmc.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

import java.util.HashMap;

public class Config {
  private final Configuration config;

  private static final String CATEGORY_GENERAL = "general";
  private static final String CATEGORY_DIMENSIONS = "dimensions";
  private static final String CATEGORY_CROPS = "crops";
  private static final String CATEGORY_SEEDS = "seeds";
  private static final String CATEGORY_MISC_RECIPES = "miscrecipes";

  // default config
  private static final int defaultCropFoodRestore = 1;
  private static final double defaultSaturationSmall = 0.6D;

  // config
  public int cropFoodRestore;
  public float cropSaturationRestore;
  public static boolean cropsDropSeeds;
  public int seedRarity;
  public static boolean enableNetherStarRecipe;
  public static boolean enableEnderPearlRecipe;
  public static boolean enableSlimeBallRecipe;

  public final HashMap<String, Boolean> seedDropFromGrass = new HashMap<String, Boolean>();

  public Config(Configuration config){
    this.config = config;
    initSettings();
  }

  private void initSettings() {
    config.load();
    initGeneralSettings();
    initCropSettings();
    initSeedDropSettings();
    initMiscRecipesSettings();

    if (config.hasChanged()) {
      config.save();
    }
  }

  private void initGeneralSettings() {
    config.addCustomCategoryComment(CATEGORY_GENERAL, "General Settings");

  }

  private void initCropSettings() {
    cropFoodRestore = config.get(CATEGORY_CROPS, "cropfoodrestore", defaultCropFoodRestore).getInt();
    cropSaturationRestore = (float) config.get(CATEGORY_CROPS, "cropSaturationRestore", defaultSaturationSmall).getDouble();
  }

  private void initSeedDropSettings() {
    config.addCustomCategoryComment(CATEGORY_SEEDS, "Seeds Settings");
    seedRarity = config.get(CATEGORY_SEEDS, "seedrarity", 1).getInt();

    initSeedDropFromGrassSetting("dollseyesdropfromgrass", CropRegistry.DOLLS_EYES, true);
  }

  private void initSeedDropFromGrassSetting(String key, String item) {
    boolean doDrop = config.get(CATEGORY_SEEDS, key, false).getBoolean();
    seedDropFromGrass.put(item, doDrop);
  }

  private void initSeedDropFromGrassSetting(String key, String item, boolean shouldDrop) {
    boolean doDrop = config.get(CATEGORY_SEEDS, key, shouldDrop).getBoolean();
    seedDropFromGrass.put(item, doDrop);
  }

  private void initMiscRecipesSettings() {
    enableEnderPearlRecipe = config.get(CATEGORY_MISC_RECIPES, "enableEnderPearlRecipe", true).getBoolean();
    enableNetherStarRecipe = config.get(CATEGORY_MISC_RECIPES, "enableNetherStarRecipe", true).getBoolean();
    enableSlimeBallRecipe = config.get(CATEGORY_MISC_RECIPES, "enableSlimeBallRecipe", true).getBoolean();
  }
}
