package kor.toxicity.betterhealthbar.api.healthbar;

import kor.toxicity.betterhealthbar.api.function.EntityCondition;
import kor.toxicity.betterhealthbar.api.function.EntityListener;
import kor.toxicity.betterhealthbar.api.resource.HealthBarResource;
import net.kyori.adventure.text.format.TextColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface HealthBarDisplay {
    @NotNull HealthBarResource getHealthBarResource();
    @NotNull EntityCondition getCondition();
    @NotNull EntityListener getListener();
    @Nullable TextColor getColor();
    int getWidth();
    boolean isInitiallyUpdated();
    boolean isPushed();
}
