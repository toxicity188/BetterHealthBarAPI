package kor.toxicity.betterhealthbar.api.healthbar.condition;

import kor.toxicity.betterhealthbar.api.function.EntityCondition;
import kor.toxicity.betterhealthbar.api.util.FunctionUtil;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class ConditionBuilder {
    private static final Map<String, Function<ConfigurationSection, EntityCondition>> ENTITY_CONDITION_CONTAINER = new HashMap<>();

    private ConditionBuilder() {
        throw new RuntimeException();
    }

    static {
        add("health", c -> {
            var amount = c.getDouble("amount", 1);
            var operation = FunctionUtil.getOperation(c.getString("operation"));
            return h -> {
                var e = h.getEntity();
                return operation.apply(e.getHealth() / Objects.requireNonNull(e.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getValue(), amount);
            };
        });
        add("alive", c -> e -> !e.getEntity().isDead());
        add("type", c -> {
            var types = EnumSet.copyOf(c.getStringList("types").stream().map(s -> EntityType.valueOf(s.toUpperCase())).toList());
            return e -> types.contains(e.getEntity().getType());
        });
        add("dead", c -> h -> h.getEntity().isDead());
        add("hasarmor", c -> h -> {
            var e = h.getEntity();
            var attribute = e.getAttribute(Attribute.GENERIC_ARMOR);
            if (attribute != null && attribute.getValue() > 0) return true;
            var equipment = e.getEquipment();
            if (equipment == null) return false;
            return (equipment.getHelmet() != null && equipment.getHelmet().getType() != Material.AIR)
                    || (equipment.getChestplate() != null && equipment.getChestplate().getType() != Material.AIR)
                    || (equipment.getLeggings() != null && equipment.getLeggings().getType() != Material.AIR)
                    || (equipment.getBoots() != null && equipment.getBoots().getType() != Material.AIR);
        });
    }


    public static @NotNull EntityCondition create(@NotNull ConfigurationSection section) {
        var clazz = Objects.requireNonNull(section.getString("class"), "Class value not found.");
        var get = Objects.requireNonNull(ENTITY_CONDITION_CONTAINER.get(clazz.toLowerCase()), "The class named \"" + clazz + "\" doesn't exist.");
        return Objects.requireNonNull(get.apply(section), "Return value of this section is null.");
    }
    public static boolean add(@NotNull String name, @NotNull Function<ConfigurationSection, EntityCondition> createFunction) {
        return ENTITY_CONDITION_CONTAINER.putIfAbsent(name.toLowerCase(), createFunction) == null;
    }
}
