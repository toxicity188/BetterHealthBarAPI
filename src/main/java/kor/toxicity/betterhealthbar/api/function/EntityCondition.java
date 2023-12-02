package kor.toxicity.betterhealthbar.api.function;

import org.bukkit.entity.LivingEntity;

import java.util.function.Function;

@FunctionalInterface
public interface EntityCondition extends Function<LivingEntity, Boolean> {
    EntityCondition EMPTY = e -> true;
}
