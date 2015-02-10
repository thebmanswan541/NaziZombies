package com.thecloud.Structure;

import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;

public class DoorManager {

    private DoorManager() { }

    private static DoorManager instance = new DoorManager();

    public static DoorManager getInstance() {
        return instance;
    }

    private ArrayList<Door> doors;

    public void setup() {
        doors = new ArrayList<Door>();

        if (!FileManager.getInstance().contains("doors")) {
            FileManager.getInstance().createConfigurationSection("doors");
        }

        for (String door : FileManager.getInstance().<ConfigurationSection>get("doors").getKeys(false)) {
            doors.add(new Door(door, FileManager.getInstance().<ConfigurationSection>get("doors." + door).getValues(true)));
        }
    }

    public Door[] getDoors() {
        return doors.toArray(new Door[doors.size()]);
    }

    public void addDoor(Door d) {
        doors.add(d);
        d.save();
    }

    public void removeDoor(Door d) {
        doors.remove(d);
        FileManager.getInstance().set("doors."+d.getDoorName(), null);
    }

    public Door getDoor(String name) {
        for (Door d : doors) {
            if (d.getDoorName().equals(name)) {
                return d;
            }
        }
        return null;
    }


}
