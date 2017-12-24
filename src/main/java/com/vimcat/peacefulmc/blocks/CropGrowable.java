package com.vimcat.peacefulmc.blocks;

import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public interface CropGrowable {
  int getMatureAge();
  boolean isMature(IBlockState state);
  List<ItemStack> getDrops(IBlockState world, BlockPos pos, IBlockState state, int fortune);
  PropertyInteger getAgeProperty();
}
