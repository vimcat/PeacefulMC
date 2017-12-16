package com.vimcat.peacefulmc;

import com.vimcat.peacefulmc.blocks.FossilOre;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
  public static CreativeTabs peacefulMC = new ModTabs(CreativeTabs.getNextID(), "PeacfulMC");
  @GameRegistry.ObjectHolder("peacefulmc:fossil")
  public static FossilOre fossilOre;

  @SideOnly(Side.CLIENT)
  public static void initModels() {
    fossilOre.initModel();
  }
}
