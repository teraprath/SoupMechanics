package dev.mending.sm.listener;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractListener implements Listener {

    private final int restoreHealth;

    public PlayerInteractListener(int restoreHealth) {
        this.restoreHealth = restoreHealth;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        if (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            return;
        }

        if (e.getItem() != null && e.getItem().getType().equals(Material.MUSHROOM_STEW)) {

            final Player player = e.getPlayer();

            if (player.getGameMode().equals(GameMode.CREATIVE) || player.getHealth() == 20) {
                return;
            }

            e.setCancelled(true);

            if (player.getHealth() + restoreHealth >= 20) {
                player.setHealth(20);
            } else {
                player.setHealth(player.getHealth() + restoreHealth);
            }

            player.getInventory().setItemInMainHand(new ItemStack(Material.BOWL));
        }
    }

}
