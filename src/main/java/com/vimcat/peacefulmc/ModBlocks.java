package com.vimcat.peacefulmc;

import com.vimcat.peacefulmc.blocks.FossilOre;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
  @ObjectHolder("peacefulmc:fossil")
  public static FossilOre FossilOre;

  @SideOnly(Side.CLIENT)
  public static void initModels() {
    FossilOre.initModel();
  }
}
