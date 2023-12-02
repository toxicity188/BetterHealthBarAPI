package kor.toxicity.betterhealthbar.api.function;

import org.bukkit.entity.LivingEntity;

import java.util.function.Function;

@FunctionalInterface
public interface EntityListener extends Function<LivingEntity, Double> {
    EntityListener EMPTY = e -> 0D;
}
