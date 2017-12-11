package com.vimcat.peacefulmc.blocks;

import com.vimcat.peacefulmc.PeacefulMC;
import com.vimcat.peacefulmc.items.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

public final class BlockRegistry {
  public static final List<Block> blocks = new ArrayList<Block>();

  public static final String compostItemName = "compost";
  public static Block compost;
  public static ItemBlock compostItemBlock;

  private static boolean initialized = false;

  private static void registerCompost() {
    compost = new CompostBlock();
    compostItemBlock = new ItemBlock(compost);
    ItemRegistry.items.put(CompostBlock.registryName, compostItemBlock);
  }

  public static void initBlockRegistry() {
    registerCompost();
    initialized = true;
  }

  public static void registerBlock(String registerName, ItemBlock itemBlock, Block block) {
    block.setRegistryName(registerName);
    block.setUnlocalizedName(registerName);
    block.setCreativeTab(PeacefulMC.modTab);
    block.setHardness(1.0F);
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
  public void onBlockRegistry(RegistryEvent.Register<Block> e) {
    IForgeRegistry<Block> reg = e.getRegistry();
    reg.registerAll(blocks.toArray(new Block[0]));
  }
}
