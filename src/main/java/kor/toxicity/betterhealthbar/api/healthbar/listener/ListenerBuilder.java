package kor.toxicity.betterhealthbar.api.healthbar.listener;

import kor.toxicity.betterhealthbar.api.function.EntityListener;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class ListenerBuilder {
    private static final Map<String, Function<ConfigurationSection, EntityListener>> ENTITY_LISTENER_MAP = new HashMap<>();

    private ListenerBuilder() {
        throw new RuntimeException();
    }

    static {
        add("health", c -> h -> {
            var e = h.getEntity();
            return e.getHealth() / Objects.requireNonNull(e.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getValue();
        });
        add("healthbefore", c -> h -> {
            var e = h.getEntity();
            return (e.getHealth() + e.getLastDamage()) / Objects.requireNonNull(e.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getValue();
        });
        add("food", c -> h -> {
            if (h.getEntity() instanceof HumanEntity entity) {
                return (double) entity.getFoodLevel() / 20D;
            } else return 0D;
        });
        add("armor", c -> h -> {
            var d = 0D;
            var e = h.getEntity();
            var equipment = e.getEquipment();
            if (equipment == null) return 0D;
            var armor = e.getAttribute(Attribute.GENERIC_ARMOR);
            if (armor != null) d += armor.getValue();
            d += Optional.ofNullable(equipment.getHelmet()).map(ItemStack::getItemMeta).map(meta -> meta.getAttributeModifiers(Attribute.GENERIC_ARMOR)).map(attribute -> attribute.stream().mapToDouble(AttributeModifier::getAmount).sum()).orElse(0D);
            d += Optional.ofNullable(equipment.getChestplate()).map(ItemStack::getItemMeta).map(meta -> meta.getAttributeModifiers(Attribute.GENERIC_ARMOR)).map(attribute -> attribute.stream().mapToDouble(AttributeModifier::getAmount).sum()).orElse(0D);
            d += Optional.ofNullable(equipment.getLeggings()).map(ItemStack::getItemMeta).map(meta -> meta.getAttributeModifiers(Attribute.GENERIC_ARMOR)).map(attribute -> attribute.stream().mapToDouble(AttributeModifier::getAmount).sum()).orElse(0D);
            d += Optional.ofNullable(equipment.getBoots()).map(ItemStack::getItemMeta).map(meta -> meta.getAttributeModifiers(Attribute.GENERIC_ARMOR)).map(attribute -> attribute.stream().mapToDouble(AttributeModifier::getAmount).sum()).orElse(0D);
            return d / 20;
        });

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
