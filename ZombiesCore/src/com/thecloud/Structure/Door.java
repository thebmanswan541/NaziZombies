package com.thecloud.Structure;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;

public class Door implements ConfigurationSerializable{

    private String name;
    private String location;
    private int cost;
    private boolean unlocked;

    public Door(String name, String location, int cost) {
        this.name = name;
        this.location = location;
        this.cost = cost;
    }

    public Door(String name, Map<String, Object> map) {
        this.name = name;
        this.location = (String) map.get("location");
        this.cost = (Integer) map.get("cost");
        this.unlocked = (Boolean) map.get("unlocked");
    }

    public String getDoorName() {
        return name;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public Map<String, Object> serialize() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("location", location);
        map.put("cost", cost);
        map.put("unlocked", unlocked);
        return map;
    }

    public void save() {
        FileManager.getInstance().set("doors."+getDoorName(), serialize());
    }

}
