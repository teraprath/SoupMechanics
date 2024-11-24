package dev.mending.sm.recipe.impl;

import dev.mending.sm.recipe.BaseRecipe;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CactusRecipe extends BaseRecipe {

    public CactusRecipe() {
        super("cactus_stew", new ItemStack(Material.MUSHROOM_STEW));
        setRecipe(Material.BOWL, Material.CACTUS);
    }
}
