package kor.toxicity.betterhealthbar.api.healthbar;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;

public interface HealthBar {
    @NotNull HealthBarTrigger getHealthBarTrigger();
    @NotNull @Unmodifiable List<HealthBarDisplay> getHealthBarDisplay();
    @NotNull HealthBarTask show(@NotNull Player player, @NotNull HealthBarEntity entity, @NotNull Runnable end);
}
