package kor.toxicity.betterhealthbar.api;

import kor.toxicity.betterhealthbar.api.manager.ConfigManager;
import kor.toxicity.betterhealthbar.api.manager.HealthBarManager;
import kor.toxicity.betterhealthbar.api.manager.ResourcePackManager;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface BetterHealthBar {
    void reload();
    void reloadAsync(@NotNull Consumer<Long> callback);

    @NotNull ConfigManager getConfigManager();
    @NotNull ResourcePackManager getResourcePackManager();
    @NotNull HealthBarManager getHealthBarManager();

    void disableHealthBar(@NotNull Player player);
    void enableHealthBar(@NotNull Player player);
}
