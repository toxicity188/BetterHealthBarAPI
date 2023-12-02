package kor.toxicity.betterhealthbar.api.healthbar;

import kor.toxicity.betterhealthbar.api.function.EntityCondition;
import kor.toxicity.betterhealthbar.api.function.EntityListener;
import kor.toxicity.betterhealthbar.api.resource.HealthBarResource;
import org.jetbrains.annotations.NotNull;

public interface HealthBarDisplay {
    @NotNull HealthBarResource getHealthBarResource();
    @NotNull EntityCondition getCondition();
    @NotNull EntityListener getListener();
    boolean isInitiallyUpdated();
}
