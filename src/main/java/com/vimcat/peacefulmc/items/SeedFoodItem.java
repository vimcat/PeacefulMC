package com.vimcat.peacefulmc.items;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeedFood;

public class SeedFoodItem extends ItemSeedFood {
  public final float saturation;

  public SeedFoodItem(int healAmount, float saturation, Block crops) {
    super(healAmount, saturation, crops, Blocks.FARMLAND);
    this.saturation = saturation;
  }
}
