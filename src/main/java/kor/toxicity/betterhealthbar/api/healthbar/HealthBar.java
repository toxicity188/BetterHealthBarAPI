package kor.toxicity.betterhealthbar.api.healthbar;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;
import java.util.UUID;

public interface HealthBar {
    @NotNull UUID getUniqueID();
    @NotNull HealthBarTrigger getHealthBarTrigger();
    @NotNull @Unmodifiable List<HealthBarDisplay> getHealthBarDisplay();
    @NotNull HealthBarTask show(@NotNull Player player, @NotNull HealthBarEntity entity, @NotNull Runnable end);
}
