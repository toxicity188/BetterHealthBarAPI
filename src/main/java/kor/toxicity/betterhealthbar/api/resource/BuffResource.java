package kor.toxicity.betterhealthbar.api.resource;

import kor.toxicity.betterhealthbar.api.util.ImageComponent;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public interface BuffResource extends Resource {
    @NotNull PotionEffectType getPotionEffectType();
    @NotNull ImageComponent getImageComponent();
}
