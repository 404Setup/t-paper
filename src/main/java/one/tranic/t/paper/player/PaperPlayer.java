package one.tranic.t.paper.player;

import net.kyori.adventure.text.Component;
import one.tranic.t.bukkit.player.BukkitPlayer;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;
import java.util.UUID;

@SuppressWarnings("all")
public class PaperPlayer extends BukkitPlayer {
    public PaperPlayer(Player player) {
        super(player);
    }

    public PaperPlayer(CommandSender commandSender) {
        super(commandSender);
    }

    /**
     * Creates an instance of {@link PaperPlayer} from the given {@link Player} instance.
     *
     * @param player The player instance to base the {@link PaperPlayer} on. Can be {@code null}.
     * @return A new {@link PaperPlayer} instance if the given player is not {@code null},
     * otherwise {@code null}.
     */
    public static @Nullable PaperPlayer createPlayer(@Nullable Player player) {
        if (player == null) return null;
        return new PaperPlayer(player);
    }

    /**
     * Creates a {@link PaperPlayer} instance from a {@link UUID}.
     *
     * @param uuid the unique identifier of the player; must not be null
     * @return a {@link PaperPlayer} instance if a corresponding player is found, or null if no player is found
     */
    public static @Nullable PaperPlayer createPlayer(@NotNull UUID uuid) {
        Player p = Bukkit.getPlayer(uuid);
        return createPlayer(p);
    }

    /**
     * Creates a BukkitPlayer instance for the specified username if the player is found.
     *
     * @param username The username of the player to create a BukkitPlayer instance for.
     *                 Must not be null.
     * @return A BukkitPlayer instance corresponding to the player with the provided username,
     * or null if no player with the given username is found.
     */
    public static @Nullable PaperPlayer createPlayer(@NotNull String username) {
        Player p = Bukkit.getPlayer(username);
        return createPlayer(p);
    }

    @Override
    public @NotNull Locale getLocale() {
        return getSourcePlayer().locale();
    }

    @Override
    public boolean kick() {
        return kick(Component.text("Losing connection to server"));
    }

    @Override
    public boolean kick(String reason) {
        return kick(Component.text(reason));
    }

    @Override
    public boolean kick(@NotNull Component reason) {
        getSourcePlayer().kick(reason);
        return true;
    }

    @Override
    public void sendMessage(@NotNull String message) {
        getSourcePlayer().sendMessage(message);
    }

    @Override
    public void sendMessage(@NotNull Component message) {
        getSourcePlayer().sendMessage(message);
    }
}
