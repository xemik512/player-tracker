package com.app.playerscanner.playerscanner;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerScanner extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Plugin 'PlayerScanner' has been enabled.");

        this.getCommand("giveScanner").setExecutor(this);

        this.getServer().getPluginManager().registerEvents(new UseItem(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Plugin 'PlayerScanner' has been disabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        if (command.getName().equals("giveScanner")) {
            if (args.length == 0) {
                sender.sendMessage("Too few arguments -- must specify the name of an online player");
                return false;
            } else if (args.length > 2) {
                sender.sendMessage("Too many arguments.");
                return false;
            }

            Player target = getServer().getPlayer(args[0]);

            if (target == null) {
                sender.sendMessage("The player " + args[0] + " is not online.");
                return false;
            }

            Scanner scanner_obj = new Scanner();
            ItemStack scanner_is = scanner_obj.getItemStack();

            target.getInventory().addItem(scanner_is);

            return true;
        }

        return false;
    }
}
