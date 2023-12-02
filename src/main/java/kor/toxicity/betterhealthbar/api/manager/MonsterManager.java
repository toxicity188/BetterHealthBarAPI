package kor.toxicity.betterhealthbar.api.manager;

import kor.toxicity.betterhealthbar.api.monster.HealthBarMonster;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface MonsterManager extends BetterHealthBarManager {
    @Nullable HealthBarMonster getMonster(@NotNull String name);
}
