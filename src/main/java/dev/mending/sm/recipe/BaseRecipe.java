package dev.mending.sm.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public abstract class BaseRecipe {

    private final NamespacedKey key;
    private final ItemStack itemStack;
    private ShapelessRecipe recipe;

    public BaseRecipe(String id, ItemStack itemStack) {
        this.itemStack = itemStack;
        this.key = new NamespacedKey("soupmechanics", id);
    }

    public BaseRecipe setRecipe(Material... ingredients) {
        ShapelessRecipe shapelessRecipe = new ShapelessRecipe(key, itemStack);
        for (Material ingredient : ingredients) {
            shapelessRecipe.addIngredient(ingredient);
        }
        this.recipe = shapelessRecipe;
        return this;
    }

    public void register() {
        if (this.recipe != null) {
            Bukkit.addRecipe(recipe);
        }
    }
}
