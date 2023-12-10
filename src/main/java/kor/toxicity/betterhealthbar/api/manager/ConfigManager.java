package kor.toxicity.betterhealthbar.api.manager;

import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Set;

public interface ConfigManager extends BetterHealthBarManager {
    double getBuffImageMultiplier();
    int getDefaultAscent();
    int getBuffImageAscent();
    long getHealthBarRemainTime();
    double getDefaultHealthBarHeight();
    double getFontSize();
    double getPlayerLookDistance();
    double getPlayerLookDegree();
    boolean isShowPlayerHealthBar();
    boolean isShowMeHealthBar();
    boolean isDisableToInvulnerableMob();
    boolean isUsingTextDisplay();
    @NotNull @Unmodifiable Set<EntityType> getDisableEntityType();
}
