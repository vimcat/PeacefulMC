package com.vimcat.peacefulmc.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class ItemRenderRegister {
  public static void register(final Item item) {
    final String resName = item.getRegistryName().toString();
    final ModelResourceLocation res = new ModelResourceLocation(resName, "inventory");
    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, res);
  }
  public static void registerItemRenderer() {
    for (Item item : ItemRegistry.items.values()) {
      register(item);
    }

    for (Item item : ItemRegistry.itemList) {
      register(item);
    }
  }
}
