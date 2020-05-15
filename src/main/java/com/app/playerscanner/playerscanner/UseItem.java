package com.app.playerscanner.playerscanner;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class UseItem implements Listener {
    @EventHandler
    public void onConsume(PlayerInteractEntityEvent evt) {
        if (evt.getRightClicked().getType() != EntityType.PLAYER) {
            return;
        }

        Player player = evt.getPlayer();

        ItemStack usedItem = null;
        EquipmentSlot hand = evt.getHand();

        if (hand == EquipmentSlot.HAND) {
            usedItem = player.getInventory().getItemInMainHand();
        } else if (hand == EquipmentSlot.OFF_HAND) {
            usedItem = player.getInventory().getItemInOffHand();
        }

        if (usedItem == null || !usedItem.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Player Identifier")) {
            return;
        }

        Player target;

        try {
            target = (Player) evt.getRightClicked();
        } catch (Exception e) {
            return;
        }

        doUseItem(player, target);
    }

    private void doUseItem(Player player, Player target) {
        if (target.hasPermission("PlayerScanner.immune")) {
            player.sendMessage(ChatColor.AQUA + "You feel as though you can't make out who this is.");
        } else {
            player.sendMessage(ChatColor.AQUA + "You feel as though this is probably " + target.getDisplayName() + ".");
        }
    }
}
