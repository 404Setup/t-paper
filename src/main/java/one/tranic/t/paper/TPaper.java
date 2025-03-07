package one.tranic.t.paper;

import one.tranic.t.base.TBase;
import one.tranic.t.base.command.source.CommandSource;
import one.tranic.t.base.command.source.SystemCommandSource;
import one.tranic.t.base.player.Player;
import one.tranic.t.base.player.Players;
import one.tranic.t.bukkit.player.BukkitPlayers;
import one.tranic.t.paper.command.source.PaperConsoleSource;
import one.tranic.t.utils.Reflect;
import org.bukkit.plugin.Plugin;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

public class TPaper {
    private static boolean initialized = false;

    public static void init(Plugin plugin) {
        if (initialized) return;
        try {
            Reflect.assignToStaticFieldIfUninitialized(TBase.class, "getConsoleSourceSupplier", (Supplier<CommandSource<?, ?>>) TPaper::getBukkitConsoleSource, false);
            Reflect.assignToStaticFieldIfUninitialized(Players.class, "getPlayerWithStringMethod", (Function<String, Player<?>>) BukkitPlayers::getPlayer, false);
            Reflect.assignToStaticFieldIfUninitialized(Players.class, "getPlayerWithUUIDMethod", (Function<UUID, Player<?>>) BukkitPlayers::getPlayer, false);
            Reflect.assignToStaticFieldIfUninitialized(Players.class, "getOnlinePlayersMethod", (Supplier<List<Player<?>>>) BukkitPlayers::getOnlinePlayers, false);
            Reflect.assignToStaticFieldIfUninitialized(Players.class, "getPlatformOnlinePlayersMethod", (Supplier<List<?>>) BukkitPlayers::getPlatformOnlinePlayers, false);
            Reflect.assignToStaticFieldIfUninitialized(Players.class, "getOnlinePlayersNameMethod", (Supplier<List<String>>) BukkitPlayers::getOnlinePlayersName, false);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        initialized = true;
    }

    public static void disable() {
        initialized = false;
    }

    public static SystemCommandSource<?, ?> getBukkitConsoleSource() {
        return new PaperConsoleSource();
    }
}
