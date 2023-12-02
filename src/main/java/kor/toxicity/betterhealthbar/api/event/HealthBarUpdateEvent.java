package kor.toxicity.betterhealthbar.api.event;

import kor.toxicity.betterhealthbar.api.healthbar.HealthBarEntity;
import lombok.Getter;
import lombok.Setter;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
public class HealthBarUpdateEvent extends Event implements BetterHealthBarEvent {
    private final @NotNull Player player;
    private final @NotNull HealthBarEntity entity;
    private @Nullable Component component;
    public HealthBarUpdateEvent(@NotNull Player player, @NotNull HealthBarEntity entity) {
        super(true);
        this.player = player;
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
