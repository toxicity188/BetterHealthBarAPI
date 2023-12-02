package kor.toxicity.betterhealthbar.api.healthbar;

import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public interface HealthBarEntity {
    static HealthBarEntity of(@NotNull LivingEntity livingEntity) {
        return () -> livingEntity;
    }
    @NotNull LivingEntity getEntity();
}
