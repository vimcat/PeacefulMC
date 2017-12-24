package com.vimcat.peacefulmc;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import java.util.Map;

public class SeedDropRegistry {
  public static void getSeedDrops() {
    for (Map.Entry<String, Boolean> entry : PeacefulMC.config.seedDropFromGrass.entrySet()) {
      if (entry.getValue()) {
        final Item item = CropRegistry.getSeed(entry.getKey());
        if (item == null) continue;
        MinecraftForge.addGrassSeed(new ItemStack(item, 1, 0), PeacefulMC.config.seedRarity);
      }
    }
  }
}
