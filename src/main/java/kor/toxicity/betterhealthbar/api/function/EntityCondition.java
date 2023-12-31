package kor.toxicity.betterhealthbar.api.function;

import kor.toxicity.betterhealthbar.api.healthbar.HealthBarEntity;
import org.bukkit.entity.LivingEntity;

import java.util.function.Function;

@FunctionalInterface
public interface EntityCondition extends Function<HealthBarEntity, Boolean> {
    EntityCondition EMPTY = e -> true;
}
