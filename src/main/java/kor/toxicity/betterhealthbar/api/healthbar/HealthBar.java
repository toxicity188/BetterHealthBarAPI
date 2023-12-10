package kor.toxicity.betterhealthbar.api.healthbar;

import kor.toxicity.betterhealthbar.api.function.EntityCondition;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface HealthBar {
    @NotNull UUID getUniqueID();
    @NotNull @Unmodifiable Set<HealthBarTrigger> getHealthBarTrigger();
    @NotNull @Unmodifiable List<HealthBarDisplay> getHealthBarDisplay();
    @NotNull EntityCondition getGlobalCondition();
    @NotNull HealthBarTask show(@NotNull Player player, @NotNull HealthBarEntity entity, @NotNull Runnable end);
    @NotNull Vector getScale();
}
