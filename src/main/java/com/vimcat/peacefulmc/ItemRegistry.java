package com.vimcat.peacefulmc;

import com.vimcat.peacefulmc.blocks.CropBlock;
import com.vimcat.peacefulmc.items.VimcatItemFood;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ItemRegistry {
  public static final List<Item> itemList = new ArrayList<Item>();
  public static final HashMap<String, Item> items = new HashMap<String, Item>();

  public static final HashSet<Item> allFood = new HashSet<Item>();

  // Items
  public static Item goldenrodItem;

  public static boolean initialized = false;

  public static void registerItems() {
    registerGenericItems();
    initialized = true;
  }

  private static Config config = PeacefulMC.config;

  private static void registerVanillaReplacementItems() {

  }

  private static void registerGenericItems() {
    goldenrodItem = registerGenericItem("goldenroditem");
  }

  private static void registerFoodItems() {

  }

  private static Item registerItemFood(String registryName, int amount, float saturation) {
    final Item item = new VimcatItemFood(amount, saturation);
    allFood.add(item);

    return registerItem(item, registryName);
  }

  private static Item registerItemFood(String registryName, int amount, float saturation, PotionEffect potionEffect, float potionProbability) {
    final Item item = new VimcatItemFood(amount, saturation).setPotionEffect(potionEffect, potionProbability);
    allFood.add(item);

    return registerItem(item, registryName);
  }

  private static ItemSeedFood registerItemSeedFood(String registryName, int amount, float saturation, Block crops, Block soil) {
    final Item item = new ItemSeedFood(amount, saturation, crops, soil);
    allFood.add(item);
    return (ItemSeedFood) registerItem(item, registryName);
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
