package com.vimcat.peacefulmc;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeRegistry {
  public static void registerRecipes() {
    registerSmelting();
    registerPotions();
  }

  private static void registerSmelting() {
    addSmelting(ItemRegistry.goldenrodItem, Items.BLAZE_ROD);
  }

  private static void registerPotions() {
    PotionHelper.addMix(PotionTypes.AWKWARD, CropRegistry.getFood("dollseyes"), PotionTypes.POISON);
    PotionHelper.addMix(PotionTypes.WATER, CropRegistry.getFood("dollseyes"), PotionTypes.MUNDANE);
  }

  private static void addSmelting(Item input, Item output) {
    GameRegistry.addSmelting(input, new ItemStack(output), 0.1F);
  }

  private static void addSmelting(Block input, Item output) {
    GameRegistry.addSmelting(input, new ItemStack(output), 0.1F);
  }
}
