package kor.toxicity.betterhealthbar.api.monster;

import kor.toxicity.betterhealthbar.api.healthbar.HealthBarEntity;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

public interface MonsterPlaceholder {
    @NotNull Component parse(@NotNull HealthBarEntity entity);
}
