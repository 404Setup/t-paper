package one.tranic.t.paper.command.source;

import net.kyori.adventure.text.Component;
import one.tranic.t.bukkit.command.source.BukkitConsoleSource;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

public class PaperConsoleSource extends BukkitConsoleSource {
    @Override
    public void broadcastMessage(@NotNull Component message) {
        Bukkit.broadcast(message);
    }

    @Override
    public void sendMessage(@NotNull Component message) {
        Bukkit.getConsoleSender().sendMessage(message);
    }
}
