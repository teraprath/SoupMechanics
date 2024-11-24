package dev.mending.sm.config.impl;

import dev.mending.sm.config.BaseConfig;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class MainConfig extends BaseConfig {

    private boolean checkForUpdatesEnabled;
    private int restoreHealthAmount;
    private boolean recipeCocoaBeansEnabled;
    private boolean recipeCactusEnabled;
    private boolean vanillaHungerBarDisabled;

    public MainConfig(JavaPlugin plugin) {
        super(plugin, "config");
    }

    @Override
    public void onLoad(FileConfiguration config) {
        this.checkForUpdatesEnabled = config.getBoolean("check-for-updates");
        this.restoreHealthAmount = config.getInt("soup.restore-health-amount");
        this.recipeCocoaBeansEnabled = config.getBoolean("recipes.cocoa-beans");
        this.recipeCactusEnabled = config.getBoolean("recipes.cactus");
        this.vanillaHungerBarDisabled = config.getBoolean("vanilla-hunger-bar.disabled");
    }
}
