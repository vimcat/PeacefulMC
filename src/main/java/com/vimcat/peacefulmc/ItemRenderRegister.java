package com.vimcat.peacefulmc;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ItemRenderRegister {
  public static void registerItemRenderer() {
    for (Item item : ItemRegistry.items.values()) {
      register(item);
    }

    for (Item item : ItemRegistry.itemList) {
      register(item);
    }
  }

  private static void register(final Item item) {
    final String resName = item.getRegistryName().toString();
    final ModelResourceLocation res = new ModelResourceLocation(resName, "inventory");
    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, res);
  }
}
