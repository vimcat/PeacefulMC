package com.vimcat.peacefulmc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModTabs extends CreativeTabs {
  public ModTabs(int par1, String par25str) {
    super(par1, par25str);
  }

  @Override
  @SideOnly(Side.CLIENT)
  public ItemStack getTabIconItem() {
    return new ItemStack(Items.SLIME_BALL, 1, 0);
  }

  public String getTranslatedTabLabel() {
    return "Peaceful MC";
  }
}
