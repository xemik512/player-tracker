package com.app.playerscanner.playerscanner;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class Scanner {
    final private ItemStack itemStack;

    public Scanner() {
        this.itemStack = makeScanner();
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    private ItemStack makeScanner() {
        ItemStack scanner = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta = scanner.getItemMeta();
        String dn = ChatColor.GOLD + "Player Identifier";

        meta.setDisplayName(dn);
        meta.setLocalizedName(dn);
        meta.setUnbreakable(true);
        meta.setLore(Collections.singletonList("Identify masked individuals"));
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES);

        scanner.setItemMeta(meta);

        return scanner;
    }
}
