package kor.toxicity.betterhealthbar.api.healthbar.listener;

import kor.toxicity.betterhealthbar.api.function.EntityListener;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class ListenerBuilder {
    private static final Map<String, Function<ConfigurationSection, EntityListener>> ENTITY_LISTENER_MAP = new HashMap<>();

    private ListenerBuilder() {
        throw new RuntimeException();
    }

    static {
        add("health", c -> e -> e.getHealth() / Objects.requireNonNull(e.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getValue());
    }


    public static @NotNull EntityListener create(@NotNull ConfigurationSection section) {
        var clazz = Objects.requireNonNull(section.getString("class"), "Class value not found.");
        var get = Objects.requireNonNull(ENTITY_LISTENER_MAP.get(clazz.toLowerCase()), "The class named \"" + clazz + "\" doesn't exist.");
        return Objects.requireNonNull(get.apply(section), "Return value of this section is null.");
    }
    public static boolean add(@NotNull String name, @NotNull Function<ConfigurationSection, EntityListener> createFunction) {
        return ENTITY_LISTENER_MAP.putIfAbsent(name.toLowerCase(), createFunction) == null;
    }
}
