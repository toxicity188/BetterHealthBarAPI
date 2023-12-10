package kor.toxicity.betterhealthbar.api.function;

import kor.toxicity.betterhealthbar.api.healthbar.HealthBarEntity;
import org.bukkit.entity.LivingEntity;

import java.util.function.Function;

@FunctionalInterface
public interface EntityListener extends Function<HealthBarEntity, Double> {
    EntityListener EMPTY = e -> 0D;
}
