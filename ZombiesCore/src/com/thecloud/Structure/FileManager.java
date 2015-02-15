package com.thecloud.Structure;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class FileManager {

    private FileManager() {  }
    private static FileManager instance = new FileManager();

    public static FileManager getInstance() {
        return instance;
    }

    File configFile;
    FileConfiguration config;

    File spawns;
    FileConfiguration spawnsConfig;

    File doors;
    FileConfiguration doorsConfig;

    File spawnPoints;
    FileConfiguration spConfig;

    public void setup(Plugin p) {
        if (!p.getDataFolder().exists()) p.getDataFolder().mkdir();

        spawns = new File(p.getDataFolder(), "spawn.yml");
        doors = new File(p.getDataFolder(), "doors.yml");
        spawnPoints = new File(p.getDataFolder(), "spawnpoints.yml");
        configFile = new File(p.getDataFolder(), "config.yml");

        if (!spawns.exists()) {
            try {
                spawns.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!doors.exists()) {
            try {
                doors.createNewFile();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        if (!spawnPoints.exists()) {
            try {
                spawnPoints.createNewFile();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        config = YamlConfiguration.loadConfiguration(configFile);
        spawnsConfig = YamlConfiguration.loadConfiguration(spawns);
        doorsConfig = YamlConfiguration.loadConfiguration(doors);
        spConfig = YamlConfiguration.loadConfiguration(spawnPoints);
    }

    public FileConfiguration getSpawns() {
        return spawnsConfig;
    }

    public void saveSpawns() {
        try {
            spawnsConfig.save(spawns);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void set(String path, Object value) {
        doorsConfig.set(path, value);
        save();
    }

    public ConfigurationSection createConfigurationSection(String path) {
        ConfigurationSection section = doorsConfig.createSection(path);
        save();
        return section;
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String path) {
        return (T) doorsConfig.get(path);
    }

    public boolean contains(String path) {
        return doorsConfig.contains(path);
    }

    public void save() {
        try {
            doorsConfig.save(doors);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getSpawnPoints() {
        return spConfig;
    }

    public void saveSpawnPoints() {
        try {
            spConfig.save(spawnPoints);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void saveConfig() {
        try {
            config.save(configFile);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}




