package kor.toxicity.betterhealthbar.api.util;

import org.jetbrains.annotations.Nullable;

import java.util.function.BiFunction;

public class FunctionUtil {
    private FunctionUtil() {
        throw new RuntimeException();
    }

    public static BiFunction<Double, Double, Boolean> getOperation(@Nullable String operation) {
        return switch (operation != null ? operation : "<=") {
            case "<" -> (a,b) -> a < b;
            case ">" -> (a,b) -> a > b;
            case "<=" -> (a,b) -> a <= b;
            case ">=" -> (a,b) -> a >= b;
            case "==" -> Double::equals;
            case "!=" -> (a,b) -> !a.equals(b);
            default -> (a,b) -> false;
        };
    }
}
