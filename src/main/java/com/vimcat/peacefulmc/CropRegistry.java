package com.vimcat.peacefulmc;

import com.vimcat.peacefulmc.blocks.CropBlock;
import com.vimcat.peacefulmc.items.SeedFoodItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.FMLLog;

import java.text.MessageFormat;
import java.util.HashMap;

public class CropRegistry {
  public static final String CROP_BLOCK_NAME = "vimcat{0}crop";
  public static final String ITEM_NAME = "{0}item";
  public static final String SEED_ITEM_NAME = "{0}seeditem";

  public static final String DOLLS_EYES = "dollseyes";

  public static final String[] cropNames = new String[] {
    DOLLS_EYES
  };

  private static boolean isInitialized = false;

  private static final HashMap<String, Item> seeds = new HashMap<String, Item>();
  private static final HashMap<String, ItemSeedFood> foods = new HashMap<String, net.minecraft.item.ItemSeedFood>();
  private static final HashMap<String, CropBlock> crops = new HashMap<String, CropBlock>();

  public static HashMap<String, Item> getSeeds() {
    return seeds;
  }

  public static HashMap<String, CropBlock> getCrops() {
    if (!isInitialized) {
      FMLLog.bigWarning("Crop registry is not initialized!");
      return new HashMap<String, CropBlock>();
    }

    return crops;
  }

  public static boolean isIsInitialized() {
    return isInitialized;
  }

  public static Item getSeed(String cropName) {
    if (!isInitialized) {
      FMLLog.bigWarning("Crop registry is not initialized (yet)!");
      return null;
    }

    if (!seeds.containsKey(cropName)) {
      FMLLog.bigWarning("No seed found for key %s", cropName);
      return null;
    }

    return seeds.get(cropName);
  }

  public static ItemSeedFood getFood(String cropName) {
    if (!isInitialized) {
      FMLLog.bigWarning("Crop registry is not initialized (yet)!");
      return null;
    }

    if (!foods.containsKey(cropName)) {
      FMLLog.bigWarning("No food found for key %s", cropName);
      return null;
    }

    return foods.get(cropName);
  }

  public static CropBlock getCrop(String cropName) {
    if (!isInitialized) {
      FMLLog.bigWarning("Crop registry is not initialized (yet)!");
      return null;
    }

    if (!crops.containsKey(cropName)) {
      FMLLog.bigWarning("No crop found for key %s", cropName);
      return null;
    }

    return crops.get(cropName);
  }

  public static void registerCrops() {
    if (isInitialized) {
      return;
    }

    for (String cropName : cropNames) {
      registerCrop(cropName);
      isInitialized = true;
    }
  }

  private static void registerCrop(String cropName) {
    final String registryName = MessageFormat.format(CROP_BLOCK_NAME, cropName);
    final CropBlock cropBlock = new CropBlock(registryName, cropName);

    BlockRegistry.registerBlock(registryName, null, cropBlock);

    final ItemSeedFood item = createItem(cropBlock);
    if (cropName == DOLLS_EYES) {
      item.setPotionEffect(new PotionEffect(MobEffects.POISON, 100, 0), 1F);
    }
    ItemRegistry.registerItem(item, MessageFormat.format(ITEM_NAME, cropName));
    cropBlock.setFood(item);

    final Item seedItem = createSeed(cropBlock);
    ItemRegistry.registerItem(seedItem, getSeedName(cropName));
    cropBlock.setSeed(seedItem);

    seeds.put(cropName, seedItem);
    foods.put(cropName, item);
    crops.put(cropName, cropBlock);
  }

  private static String getSeedName(String cropName) {
    return MessageFormat.format(SEED_ITEM_NAME, cropName);
  }

  private static SeedFoodItem createItem(CropBlock cropBlock) {
    return new SeedFoodItem(PeacefulMC.config.cropFoodRestore, PeacefulMC.config.cropSaturationRestore, cropBlock);
  }

  private static Item createSeed(CropBlock cropBlock) {
    return new ItemSeeds(cropBlock, Blocks.FARMLAND);
  }
}
