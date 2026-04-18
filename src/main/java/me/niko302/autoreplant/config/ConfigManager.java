package me.niko302.autoreplant.config;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.stream.Collectors;

public class ConfigManager {

    private final Plugin plugin;

    private FileConfiguration config;

    private boolean useFortune; // Variable to store the use-fortune setting
    private boolean autoreplantEnabled; // Variable to store the autoreplant status
    private boolean ignoreToolRestrictions; // Variable to store the ignore-tool-restrictions status

    public ConfigManager(Plugin plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    private void loadConfig() {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();
        config = plugin.getConfig();

        // Load use-fortune setting
        useFortune = config.getBoolean("use-fortune", true);

        // Load autoreplant setting
        autoreplantEnabled = config.getBoolean("autoreplant-enabled", true);

        // Load ignore-tool-restrictions setting
        ignoreToolRestrictions = config.getBoolean("ignore-tool-restrictions", false);
    }

    public List<Material> getAllowedItems() {
        return config.getStringList("allowed-items").stream().map(Material::valueOf).collect(Collectors.toList());
    }

}