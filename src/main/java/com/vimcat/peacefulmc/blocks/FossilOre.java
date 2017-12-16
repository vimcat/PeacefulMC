package com.vimcat.peacefulmc.blocks;

import com.vimcat.peacefulmc.ModItems;
import com.vimcat.peacefulmc.PeacefulMC;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.*;

public class FossilOre extends Block {
  @Override
  public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
   Random rand = world instanceof World ? ((World) world).rand : RANDOM;
   int count = quantityDropped(state, fortune, rand);
   for (int i = 0; i < count; i++) {
     Item item = Items.BONE;
     if (item != Items.AIR) {
       drops.add(new ItemStack(item, RANDOM.nextInt(5) + 2, this.damageDropped(state)));
     }
   }
  }

  public FossilOre() {
    super(Material.ROCK);
    this.setSoundType(SoundType.STONE);
    this.setHarvestLevel("pickaxe", 0);
    this.setHardness(1.0F);
    this.setUnlocalizedName(PeacefulMC.MODID + ".fossil");
    setRegistryName("fossil");
    this.setCreativeTab(ModItems.peacefulMC);
  }

  @SideOnly(Side.CLIENT)
  public void initModel() {
    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
  }
}
