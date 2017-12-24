package com.vimcat.peacefulmc.addons;

import com.vimcat.peacefulmc.blocks.CropBlock;
import com.vimcat.peacefulmc.blocks.CropGrowable;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import mcp.mobius.waila.cbcore.LangUtil;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class WailaHandler implements IWailaDataProvider {
  @Override
  public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
    if (accessor.getBlock() instanceof CropBlock) {
      CropBlock crop = (CropBlock) accessor.getBlock();
      return new ItemStack(crop.getCrop());
    } else {
      return ItemStack.EMPTY;
    }
  }

  @Override
  public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
    return currenttip;
  }

  @Override
  public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
    if (!config.getConfig("general.showcrop") || accessor.getBlock() == null || !(accessor.getBlock() instanceof CropGrowable)) {
      return currenttip;
    }

    currenttip.clear();

    float matureAge = ((CropGrowable) accessor.getBlock()).getMatureAge();
    final int growthState = accessor.getMetadata();

    final float growthValue = (growthState / matureAge) * 100.0F;

    if (growthValue < 100.0) {
      currenttip.add(String.format("%s : %.0f %%", LangUtil.translateG("hud.msg.growth"), growthValue));
    } else {
      currenttip.add(String.format("%s : %s", LangUtil.translateG("hud.msg.growth"), LangUtil.translateG("hud.msg.mature")));
    }

    return currenttip;
  }

  @Override
  public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
    return currenttip;
  }

  @Override
  public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, BlockPos pos) {
    if (te != null) {
      te.deserializeNBT(tag);
    }

    return tag;
  }

  public static void callbackRegister(IWailaRegistrar registrar) {
    registrar.registerBodyProvider(new WailaHandler(), CropBlock.class);
  }
}
