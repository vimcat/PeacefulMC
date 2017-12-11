package com.vimcat.peacefulmc.blocks;

import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import com.vimcat.peacefulmc.PeacefulMC;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

public class CompostBlock extends Block {
  public static final String registryName = "compost";
  public CompostBlock() {
    super(Material.GROUND);
    setCreativeTab(PeacefulMC.modTab);
    setUnlocalizedName(PeacefulMC.MODID + ".compost");
    setHarvestLevel("shovel", 0);
    setTickRandomly(true);
    setSoundType(SoundType.GROUND);
  }

  @SideOnly(Side.CLIENT)
  public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
    super.addInformation(stack, worldIn, tooltip, flagIn);
    tooltip.add(TextFormatting.GOLD + "It's what plants need.");
  }

  @Override
  public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
    super.updateTick(world, pos, state, rand);

    EnumFacing randomDirection = EnumFacing.DOWN;
    while (randomDirection == EnumFacing.DOWN) {
      randomDirection = EnumFacing.random(rand);
    }

    attemptSoilBuilding(world, pos.offset(randomDirection), rand, randomDirection == EnumFacing.UP);
  }

  public static boolean tryGrowthTickAt(World world, BlockPos pos, Random rand) {
    IBlockState state = world.getBlockState(pos);
    Block block = state.getBlock();
    if ((block instanceof IPlantable || block instanceof IGrowable) && block.getTickRandomly()) {
      block.updateTick(world, pos, state, rand);
      return true;
    }
    return false;
  }

  public void attemptSoilBuilding(World world, BlockPos pos, Random rand, boolean growPlantDirectly) {
    tryGrowthTickAt(world, pos.up(), rand);
    if (growPlantDirectly) {
      tryGrowthTickAt(world, pos, rand);
    }
  }
}
