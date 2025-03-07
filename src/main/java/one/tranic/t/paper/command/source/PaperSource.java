package one.tranic.t.paper.command.source;

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import one.tranic.t.bukkit.command.source.BukkitSource;
import one.tranic.t.paper.player.PaperPlayer;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class PaperSource extends BukkitSource {
    public PaperSource(CommandSender commandSender, String[] args) {
        super(commandSender, args);
    }

    @Override
    public void sendMessage(String message) {
        getSource().sendMessage(message);
    }

    @Override
    public void sendMessage(@NotNull Component message) {
        getSource().sendMessage(message);
    }

    @Override
    @SuppressWarnings("all")
    public void showBossBar(@NotNull BossBar bossBar) {
        if (isPlayer()) asPlayer().getSourcePlayer().showBossBar(bossBar);

    }

    @Override
    @SuppressWarnings("all")
    public void hideBossBar(@NotNull BossBar bossBar) {
        if (isPlayer()) asPlayer().getSourcePlayer().hideBossBar(bossBar);
    }

    @Override
    @SuppressWarnings("all")
    public void showTitle(@NotNull Title title) {
        if (isPlayer()) asPlayer().getSourcePlayer().showTitle(title);
    }

    @Override
    @SuppressWarnings("all")
    public void clearTitle() {
        if (isPlayer()) asPlayer().getSourcePlayer().clearTitle();
    }

    @Override
    public @Nullable PaperPlayer asPlayer() {
        return (PaperPlayer) super.asPlayer();
    }
}
