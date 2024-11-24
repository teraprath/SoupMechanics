package dev.mending.sm.recipe.impl;

import dev.mending.sm.recipe.BaseRecipe;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CocoaRecipe extends BaseRecipe {

    public CocoaRecipe() {
        super("cocoa_stew", new ItemStack(Material.MUSHROOM_STEW));
        setRecipe(Material.BOWL, Material.COCOA_BEANS);
    }

}
