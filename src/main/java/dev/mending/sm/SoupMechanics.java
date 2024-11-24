package dev.mending.sm;

import dev.mending.sm.config.impl.MainConfig;
import dev.mending.sm.listener.FoodLevelListener;
import dev.mending.sm.listener.PlayerInteractListener;
import dev.mending.sm.recipe.impl.CactusRecipe;
import dev.mending.sm.recipe.impl.CocoaRecipe;
import dev.mending.sm.utils.UpdateChecker;
import lombok.Getter;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class SoupMechanics extends JavaPlugin {

    private final MainConfig mainConfig = new MainConfig(this);

    @Override
    public void onEnable() {

        mainConfig.init();
        registerEvents(getServer().getPluginManager());
        registerRecipes();

        if (mainConfig.isCheckForUpdatesEnabled()) {
            new UpdateChecker(this, "teraprath", "SoupMechanics").checkForUpdate();
        }
    }

    private void registerEvents(final PluginManager pm) {

        if (mainConfig.isVanillaHungerBarDisabled()) {
            pm.registerEvents(new FoodLevelListener(), this);
        }

        pm.registerEvents(new PlayerInteractListener(mainConfig.getRestoreHealthAmount()), this);
    }

    private void registerRecipes() {

        if (mainConfig.isRecipeCocoaBeansEnabled()) {
            new CocoaRecipe().register();
        }

        if (mainConfig.isRecipeCactusEnabled()) {
            new CactusRecipe().register();
        }
    }

}
