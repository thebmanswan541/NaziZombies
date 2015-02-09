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

    File spawns;
    FileConfiguration spawnsConfig;

    File doors;
    FileConfiguration doorsConfig;

    public void setup(Plugin p) {
        if (!p.getDataFolder().exists()) p.getDataFolder().mkdir();

        spawns = new File(p.getDataFolder(), "spawn.yml");
        doors = new File(p.getDataFolder(), "doors.yml");

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

        spawnsConfig = YamlConfiguration.loadConfiguration(spawns);
        doorsConfig = YamlConfiguration.loadConfiguration(doors);
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
    }

    public ConfigurationSection createConfigurationSection(String path) {
        ConfigurationSection section = doorsConfig.createSection(path);
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
}




