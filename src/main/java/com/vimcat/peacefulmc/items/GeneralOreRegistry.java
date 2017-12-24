package com.vimcat.peacefulmc.items;

import com.vimcat.peacefulmc.CropRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class GeneralOreRegistry {
  public static final String poisonousOreDict = "reagentPoisonous";
  // Dyes
  public static final ItemStack dyeBlack = new ItemStack(Items.DYE, 1, 0);

  // Replacement items

  public static void initOreRegistry() {
    registerGeneralOres();
  }

  public static void registerGeneralOres() {
    OreDictionary.registerOre(poisonousOreDict, CropRegistry.getFood(CropRegistry.DOLLS_EYES));
  }
}
