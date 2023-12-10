package kor.toxicity.betterhealthbar.api.resource;

import kor.toxicity.betterhealthbar.api.healthbar.HealthBarEntity;
import kor.toxicity.betterhealthbar.api.healthbar.HealthBarType;
import kor.toxicity.betterhealthbar.api.util.ImageComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;
import java.util.function.Function;

public interface HealthBarResource extends Resource {
    @NotNull String getAsset();
    int getAscent();
    @NotNull HealthBarType getType();
    @NotNull @Unmodifiable Function<HealthBarEntity, List<ImageComponent>> getImageComponents();
}
