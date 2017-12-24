package com.vimcat.peacefulmc.items;

import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;

public class VimcatItemFood extends ItemFood {
  public final float saturation;
  /** represents the potion effect that will occurr upon eating this food. Set by setPotionEffect */
  private PotionEffect potionId;
  /** probably of the set potion effect occurring */
  private float potionEffectProbability;

  public VimcatItemFood(int healAmount, float saturation) {
    super(healAmount, saturation, false);
    this.saturation = saturation;
  }

  @Override
  public ItemFood setPotionEffect(PotionEffect effect, float probability) {
    this.potionId = effect;
    this.potionEffectProbability = probability;
    return this;
  }
}
