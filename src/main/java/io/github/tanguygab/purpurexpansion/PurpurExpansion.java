package io.github.tanguygab.purpurexpansion;


import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class PurpurExpansion extends PlaceholderExpansion {


    @Override
    public @NotNull String getIdentifier() {
        return "purpur";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Tanguygab";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public boolean canRegister() {
        try {
            Class.forName("org.purpurmc.purpur.language.Language");
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {
        String[] args = params.split("_");
        String type = args.length > 0 ? args[0] : "";
        String placeholder = args.length > 1 ? args[1] : "";

        switch (type) {
            case "server" -> {
                switch (placeholder) {
                    case "name" -> Bukkit.getServer().getName();
                    case "lagging" -> Bukkit.getServer().isLagging();
                }
            }
            case "player" -> {
                Player p = player.getPlayer();
                if (p == null) break;
                switch (placeholder) {
                    case "purpurclient" -> p.usesPurpurClient();
                    case "afk" -> p.isAfk();
                    case "spawninvulnerable" -> p.isSpawnInvulnerable();
                    case "immunetofire" -> p.isImmuneToFire();
                }
            }
        }

        return null;
    }
}
