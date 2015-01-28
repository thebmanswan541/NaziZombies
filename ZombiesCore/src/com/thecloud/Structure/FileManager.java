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

    File arenas;
    FileConfiguration arenasConfig;

    public void setup(Plugin p) {
        arenas = new File(p.getDataFolder(), "arenas.yml");

        if (!arenas.exists()) {
            try {
                arenas.createNewFile();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        arenasConfig = YamlConfiguration.loadConfiguration(arenas);
    }

    public FileConfiguration getArenas() {
        return arenasConfig;
    }

    public void saveArenas() {
        try {
            arenasConfig.save(arenas);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

