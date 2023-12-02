package kor.toxicity.betterhealthbar.api.monster;

import kor.toxicity.betterhealthbar.api.healthbar.HealthBar;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface HealthBarMonster {
    double getHealthBarHeight();
    @Nullable MonsterPlaceholder getPlaceholder();
    @Nullable HealthBar getHealthBarOverride();
}
