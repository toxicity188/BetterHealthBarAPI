package kor.toxicity.betterhealthbar.api;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class BetterHealthBarAPI {
    private static BetterHealthBar betterHealthBar;
    private BetterHealthBarAPI() {
        throw new RuntimeException();
    }
    public static @NotNull BetterHealthBar getBetterHealthBar() {
        return Objects.requireNonNull(betterHealthBar);
    }

    public static void setBetterHealthBar(@NotNull BetterHealthBar betterHealthBar) {
        if (BetterHealthBarAPI.betterHealthBar != null) throw new SecurityException();
        BetterHealthBarAPI.betterHealthBar = Objects.requireNonNull(betterHealthBar);
    }
}
