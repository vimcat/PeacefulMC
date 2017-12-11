package com.vimcat.peacefulmc.items;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import com.vimcat.peacefulmc.PeacefulMC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ItemRegistry {
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
    item.setUnlocalizedName(PeacefulMC.MODID + "." + registryName);
    itemList.add(item);
    return item;
  }

  @SubscribeEvent
  public void onItemRegistry(RegistryEvent.Register<Item> e) {
    IForgeRegistry<Item> reg = e.getRegistry();
    reg.registerAll(itemList.toArray(new Item[0]));

  }
}
