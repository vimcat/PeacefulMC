package com.vimcat.peacefulmc;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemRegistry {
  public static final List<Item> itemList = new ArrayList<Item>();
  public static final HashMap<String, Item> items = new HashMap<String, Item>();

  public static boolean initialized = false;

  public static void registerItems() {
    initialized = true;
  }

  private static Item registerGenericItem(String registryName) {
    final Item item = new Item();
    return registerItem(item, registryName);
  }

  public static Item registerItem(Item item, String registryName) {
    item.setCreativeTab(PeacefulMC.modTab);
    item.setRegistryName(registryName);
    item.setUnlocalizedName(registryName);
    itemList.add(item);
    return item;
  }

  @SubscribeEvent
  public void onItemRegistry(RegistryEvent.Register<Item> event) {
    IForgeRegistry<Item> reg = event.getRegistry();
    reg.registerAll(itemList.toArray(new Item[0]));
  }
}
