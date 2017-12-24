package com.vimcat.peacefulmc.addons;

import net.minecraftforge.fml.common.event.FMLInterModComms;

public class Waila {
  public static void init() {
    FMLInterModComms.sendMessage("Waila", "register", "com.vimcat.peacfulmc.addons.WailaHandler.WailaHandler");
  }
}
