package kor.toxicity.betterhealthbar.api.manager;

import kor.toxicity.betterhealthbar.api.resource.BuffResource;
import kor.toxicity.betterhealthbar.api.resource.HealthBarResource;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;

public interface ResourcePackManager extends BetterHealthBarManager {
    @Nullable BuffResource getByPotionType(@NotNull PotionEffectType type);
    @Nullable HealthBarResource getHealthBarResource(@NotNull String name);
    @NotNull @Unmodifiable List<BuffResource> getAllBuffValues();
}
