package kor.toxicity.betterhealthbar.api.healthbar.placeholder;

import kor.toxicity.betterhealthbar.api.function.EntityPlaceholder;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Function;

public class PlaceholderBuilder {
    private static final Map<String, Function<String[], EntityPlaceholder>> PLACEHOLDER_MAP = new HashMap<>();
    static {
        add("name", a -> p -> p.getEntity().getName());
        add("type", a -> p -> p.getEntity().getType().name());
        add("health", a -> p -> Double.toString(p.getEntity().getHealth()));
        add("maxhealth", a -> p -> Optional.ofNullable(p.getEntity().getAttribute(Attribute.GENERIC_MAX_HEALTH)).map(AttributeInstance::getValue).orElse(0D).toString());
        add("armor", a -> p -> {
            var d = 0D;
            var equipment = p.getEntity().getEquipment();
            if (equipment == null) return "<none>";
            d += Optional.ofNullable(equipment.getHelmet()).map(ItemStack::getItemMeta).map(meta -> meta.getAttributeModifiers(Attribute.GENERIC_ARMOR)).map(modifiers -> modifiers.stream().mapToDouble(AttributeModifier::getAmount).sum()).orElse(0D);
            d += Optional.ofNullable(equipment.getChestplate()).map(ItemStack::getItemMeta).map(meta -> meta.getAttributeModifiers(Attribute.GENERIC_ARMOR)).map(modifiers -> modifiers.stream().mapToDouble(AttributeModifier::getAmount).sum()).orElse(0D);
            d += Optional.ofNullable(equipment.getLeggings()).map(ItemStack::getItemMeta).map(meta -> meta.getAttributeModifiers(Attribute.GENERIC_ARMOR)).map(modifiers -> modifiers.stream().mapToDouble(AttributeModifier::getAmount).sum()).orElse(0D);
            d += Optional.ofNullable(equipment.getBoots()).map(ItemStack::getItemMeta).map(meta -> meta.getAttributeModifiers(Attribute.GENERIC_ARMOR)).map(modifiers -> modifiers.stream().mapToDouble(AttributeModifier::getAmount).sum()).orElse(0D);
            return Double.toString(d);
        });
    }
    private PlaceholderBuilder() {
        throw new RuntimeException();
    }

    public static @NotNull EntityPlaceholder parse(@NotNull String target) {
        var list = new ArrayList<EntityPlaceholder>();
        var sb = new StringBuilder();
        var skip = false;
        for (char c : target.toCharArray()) {
            if (skip) {
                skip = false;
                sb.append(c);
            } else switch (c) {
                case '\\' -> skip = true;
                case '[' -> {
                    var string = sb.toString();
                    list.add(h -> string);
                    sb.setLength(0);
                }
                case ']' -> {
                    var str = sb.toString().split(":");

                    var get = PLACEHOLDER_MAP.get(str[0]);
                    var newArr = new String[str.length - 1];
                    System.arraycopy(str, 1, newArr, 0, newArr.length);

                    list.add(Objects.requireNonNullElseGet(get.apply(newArr), () -> h -> "<none>"));
                    sb.setLength(0);
                }
                default -> sb.append(c);
            }
        }
        if (!sb.isEmpty()) {
            var string = sb.toString();
            list.add(h -> string);
        }
        return h -> {
            var builder = new StringBuilder();
            list.forEach(p -> builder.append(p.apply(h)));
            return builder.toString();
        };
    }
    public static boolean add(@NotNull String name, @NotNull Function<String[], EntityPlaceholder> createFunction) {
        return PLACEHOLDER_MAP.putIfAbsent(name.toLowerCase(), createFunction) == null;
    }
}
