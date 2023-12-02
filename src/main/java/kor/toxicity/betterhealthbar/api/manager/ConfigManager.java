package kor.toxicity.betterhealthbar.api.manager;

public interface ConfigManager extends BetterHealthBarManager {
    double getBuffImageMultiplier();
    int getDefaultAscent();
    int getBuffImageAscent();
    long getHealthBarRemainTime();
    double getDefaultHealthBarHeight();
    double getFontSize();
    boolean isShowPlayerHealthBar();
    boolean isShowMeHealthBar();
}
