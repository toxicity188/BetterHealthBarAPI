package kor.toxicity.betterhealthbar.api.event;

import kor.toxicity.betterhealthbar.api.healthbar.HealthBar;
import kor.toxicity.betterhealthbar.api.healthbar.HealthBarEntity;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class HealthBarCreateEvent extends Event implements BetterHealthBarEvent {
    private final @NotNull Player player;
    private final @NotNull HealthBarEntity entity;
    private @NotNull HealthBar healthBar;
    public HealthBarCreateEvent(@NotNull Player player, @NotNull HealthBar healthBar, @NotNull HealthBarEntity entity) {
        super(true);
        this.player = player;
        this.healthBar = healthBar;
        this.entity = entity;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }
    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}
