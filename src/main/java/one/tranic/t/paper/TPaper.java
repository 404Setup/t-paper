package one.tranic.t.paper;

import one.tranic.t.base.TInterface;
import one.tranic.t.base.command.source.SystemCommandSource;
import one.tranic.t.base.player.Player;
import one.tranic.t.bukkit.player.BukkitPlayer;
import one.tranic.t.paper.command.source.PaperConsoleSource;
import one.tranic.t.paper.player.PaperPlayer;
import one.tranic.t.utils.Collections;
import one.tranic.t.utils.minecraft.Platform;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("unused")
public class TPaper implements TInterface<CommandSender, org.bukkit.entity.Player> {
    private static boolean initialized = false;
    private final Plugin plugin;
    private final Platform[] supportedPlatforms = new Platform[]{Platform.Paper, Platform.ShreddedPaper, Platform.Folia};

    public TPaper(Plugin plugin) {
        this.plugin = plugin;
        enable();
    }

    public void disable() {
        initialized = false;
    }

    @Override
    public void enable() {
        if (initialized) return;
        initialized = true;
    }

    @Override
    public Platform[] getSupportedPlatforms() {
        return supportedPlatforms;
    }

    @Override
    public @Nullable Player<org.bukkit.entity.Player> getPlayer(@NotNull String name) {
        return PaperPlayer.createPlayer(name);
    }

    @Override
    public @Nullable Player<org.bukkit.entity.Player> getPlayer(@NotNull UUID uuid) {
        return PaperPlayer.createPlayer(uuid);
    }

    @Override
    public @NotNull List<Player<org.bukkit.entity.Player>> getOnlinePlayers() {
        final List<Player<org.bukkit.entity.Player>> players = Collections.newArrayList();
        for (var p : Bukkit.getOnlinePlayers())
            players.add(BukkitPlayer.createPlayer(p));
        return players;
    }

    @Override
    public @NotNull List<org.bukkit.entity.Player> getPlatformOnlinePlayers() {
        return Collections.newArrayList(Bukkit.getOnlinePlayers());
    }

    @Override
    public @NotNull List<String> getOnlinePlayersName() {
        final List<String> players = Collections.newArrayList();
        for (var p : Bukkit.getOnlinePlayers())
            players.add(p.getName());
        return players;
    }

    @Override
    public SystemCommandSource<CommandSender, org.bukkit.entity.Player> getConsoleSource() {
        return new PaperConsoleSource();
    }
}
