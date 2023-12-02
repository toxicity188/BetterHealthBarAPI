package kor.toxicity.betterhealthbar.api.healthbar;

import kor.toxicity.betterhealthbar.api.monster.HealthBarMonster;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface HealthBarEntity {
    static HealthBarEntity of(@NotNull LivingEntity livingEntity) {
        return new HealthBarEntity() {
            @Override
            public @Nullable HealthBarMonster getMonster() {
                return null;
            }

            @Override
            public @NotNull LivingEntity getEntity() {
                return livingEntity;
            }
        };
    }
    @Nullable HealthBarMonster getMonster();
    @NotNull LivingEntity getEntity();
}
