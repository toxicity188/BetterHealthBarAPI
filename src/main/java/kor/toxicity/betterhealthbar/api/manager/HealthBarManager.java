package kor.toxicity.betterhealthbar.api.manager;

import kor.toxicity.betterhealthbar.api.healthbar.HealthBar;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface HealthBarManager extends BetterHealthBarManager {
    @Nullable HealthBar getHealthBar(@NotNull String name);
}
