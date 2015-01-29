package com.thecloud.Structure;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class FileManager {

    private FileManager() { }

    static FileManager instance;

    public static FileManager getInstance() {
        return instance;
    }

    File spawns;
    FileConfiguration spawnsConfig;

    public void setup(Plugin p) {
        spawns = new File(p.getDataFolder(), "spawn.yml");

        if (!spawns.exists()) {
            try {
                spawns.createNewFile();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        spawnsConfig = YamlConfiguration.loadConfiguration(spawns);
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
}

