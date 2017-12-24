package com.vimcat.peacefulmc;

import com.vimcat.peacefulmc.blocks.CropBlock;
import com.vimcat.peacefulmc.blocks.FossilOre;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ItemModels {
  private static final HashMap<Item, ItemModelList> models = new HashMap<Item, ItemModelList>();

  public static void preInit() {
    defineItemModels();
    prepareModels();
  }

  public static void init() {
    registerModels();
  }

  private static void defineItemModels() {
    for (CropBlock crop : CropRegistry.getCrops().values()) {
      registerItemModels(getItem(crop), new ItemModelList("crops/")
          .add(0, crop.getStageId(0))
          .add(1, crop.getStageId(1))
          .add(2, crop.getStageId(2))
          .add(3, crop.getStageId(3)));
    }
  }

  private static void registerItemModels(Item item, ItemModelList list) {
    models.put(item, list);
  }

  private static void prepareModels() {
    for (Map.Entry<Item, ItemModelList> entry : models.entrySet()) {
      Item item = entry.getKey();
      Collection<String> registrations = entry.getValue().getRegistrations().values();

      for (String registration : registrations) {
        if (item == null || registration == null) continue;
        ModelBakery.registerItemVariants(item, new ResourceLocation(registration));
      }
    }
  }

  private static void registerModels() {
    for (HashMap.Entry<Item, ItemModelList> entry : models.entrySet()) {
      Item item = entry.getKey();
      HashMap<Integer, String> registrations = entry.getValue().getRegistrations();
      for (Map.Entry<Integer, String> registration : registrations.entrySet()) {
        int meta = registration.getKey();
        String path = registration.getValue();

        ModelResourceLocation resource = new ModelResourceLocation(path, "inventory");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, resource);
      }
    }
  }

  private static Item getItem(Block block) {
    return Item.getItemFromBlock(block);
  }
}
