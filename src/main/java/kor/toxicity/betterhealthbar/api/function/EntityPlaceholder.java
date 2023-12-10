package kor.toxicity.betterhealthbar.api.function;

import kor.toxicity.betterhealthbar.api.healthbar.HealthBarEntity;

import java.util.function.Function;

@FunctionalInterface
public interface EntityPlaceholder extends Function<HealthBarEntity, String> {
    EntityPlaceholder EMPTY = e -> "<none>";
}
