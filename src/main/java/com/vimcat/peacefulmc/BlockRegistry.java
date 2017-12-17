package com.vimcat.peacefulmc;

import com.vimcat.peacefulmc.blocks.FossilOre;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

public class BlockRegistry {
  public static final List<Block> blocks = new ArrayList<Block>();

  // FossilOre Block
  public static Block fossilOre;
  public static ItemBlock fossilOreItemBlock;

  private static boolean initialized = false;

  public static void initBlockRegistry() {
    registerFossilOre();
    initialized = true;
  }

  private static void registerFossilOre() {
    fossilOre = new FossilOre();
    fossilOreItemBlock = new ItemBlock(fossilOre);
    ItemRegistry.items.put(FossilOre.registryName, fossilOreItemBlock);
    registerBlock(FossilOre.registryName, fossilOreItemBlock, fossilOre);
  }

  public static void registerBlock(String registerName, ItemBlock itemBlock, Block block) {
    block.setRegistryName(registerName);
    block.setUnlocalizedName(registerName);
    block.setCreativeTab(PeacefulMC.modTab);
    blocks.add(block);
    if (itemBlock != null) {
      itemBlock.setRegistryName(registerName);
      itemBlock.setUnlocalizedName(registerName);
      ItemRegistry.itemList.add(itemBlock);
    }
    return;
  }

  public static void registerBlock(String registerName, Block block) {
    final ItemBlock itemBlock = new ItemBlock(block);
    registerBlock(registerName, itemBlock, block);
  }

  @SubscribeEvent
  public void onBlockRegistry(RegistryEvent.Register<Block> event) {
    IForgeRegistry<Block> reg = event.getRegistry();
    reg.registerAll(blocks.toArray(new Block[0]));
  }
}
