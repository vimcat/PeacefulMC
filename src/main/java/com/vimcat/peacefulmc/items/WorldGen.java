package com.vimcat.peacefulmc.items;

import com.vimcat.peacefulmc.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGen implements IWorldGenerator {
  @Override
  public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
    this.runGenerator(this.fossilOre, world, random, chunkX, chunkZ, 15, 0, 70);
  }

  private WorldGenerator fossilOre;

  public WorldGen() {
    this.fossilOre = new WorldGenMinable(ModBlocks.FossilOre.getDefaultState(), 7);
  }

  private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight) {
      throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");
    }

    int heightDiff = maxHeight - minHeight + 1;
    for (int i = 0; i < chancesToSpawn; i++) {
      int x = chunk_X * 16 + rand.nextInt(16);
      int y = minHeight + rand.nextInt(heightDiff);
      int z = chunk_Z * 16 + rand.nextInt(16);
      generator.generate(world, rand, new BlockPos(x, y, z));
    }
  }
}
