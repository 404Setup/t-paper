package one.tranic.t.paper.plugin;

import io.papermc.paper.plugin.configuration.PluginMeta;
import one.tranic.t.utils.Rand;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.PluginBase;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.PluginLogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.InputStream;
import java.util.List;

@SuppressWarnings("all")
public class InternalPlugin extends PluginBase {
    @SuppressWarnings("all")
    private final String pluginName;
    private boolean enabled = true;
    @SuppressWarnings("all")
    private PluginDescriptionFile pdf;

    public InternalPlugin() {
        this.pluginName = "TPaper" + Rand.generateRandomId(4);
        pdf = new PluginDescriptionFile(pluginName, "1.0", "tpaper");
    }

    @Override
    public @NotNull File getDataFolder() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public @NotNull PluginDescriptionFile getDescription() {
        return pdf;
    }

    @Override
    public @NotNull PluginMeta getPluginMeta() {
        return pdf;
    }

    @Override
    public @NotNull FileConfiguration getConfig() {
        throw new UnsupportedOperationException("Not supported.");
    }
    // Paper end

    @Override
    public InputStream getResource(@NotNull String filename) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void saveConfig() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void saveDefaultConfig() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void saveResource(@NotNull String resourcePath, boolean replace) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void reloadConfig() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public @NotNull PluginLogger getLogger() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public @NotNull PluginLoader getPluginLoader() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public @NotNull Server getServer() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public void onDisable() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void onLoad() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void onEnable() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public boolean isNaggable() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void setNaggable(boolean canNag) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(@NotNull String worldName, String id) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public @Nullable BiomeProvider getDefaultBiomeProvider(@NotNull String worldName, @Nullable String id) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args) {
        throw new UnsupportedOperationException("Not supported.");
    }
}
