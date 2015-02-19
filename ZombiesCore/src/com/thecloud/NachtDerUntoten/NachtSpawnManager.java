package com.thecloud.NachtDerUntoten;

import com.thecloud.Structure.ZombieManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Zombie;

public class NachtSpawnManager {

    public static void spawnRound1() {
        if (Bukkit.getOnlinePlayers().size() <= 4) {
            for (Location loc : NachtSpawnPoints.getNachtRoom1()) {
                ZombieManager.createZombieSpawnChain(loc, 2, 150D, 0.207);
            }
        } else {

        }
    }

    public static void spawnRound2() {
        if (NachtSpawnPoints.getNachtDoor1().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 2, 250D, 0.207);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom2()) {
                    ZombieManager.createZombieSpawnChain(location, 2, 250D, 0.207);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        en.remove();
                        break;
                    }
                }
            } else {

            }
        } else if (NachtSpawnPoints.getNachtDoor2().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 2, 250D, 0.207);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom3()) {
                    ZombieManager.createZombieSpawnChain(location, 2, 250D, 0.207);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 2) break;
                        en.remove();
                        index++;
                    }
                }
            } else {

            }
        } else if (NachtSpawnPoints.getNachtDoor2().isUnlocked() && NachtSpawnPoints.getNachtDoor1().isUnlocked() || NachtSpawnPoints.getNachtDoor2().isUnlocked() && NachtSpawnPoints.getNachtDoor3().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 2, 250D, 0.207);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom2()) {
                    ZombieManager.createZombieSpawnChain(location, 2, 250D, 0.207);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom3()) {
                    ZombieManager.createZombieSpawnChain(location, 2, 250D, 0.207);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 9) break;
                        en.remove();
                        index++;
                    }
                }
            } else {

            }
        } else {
            for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                ZombieManager.createZombieSpawnChain(location, 3, 250D, 0.207);
            }
        }
    }

    public static void spawnRound3() {
        if (NachtSpawnPoints.getNachtDoor1().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 3, 350D, 0.207);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom2()) {
                    ZombieManager.createZombieSpawnChain(location, 3, 350D, 0.207);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 4) break;
                        en.remove();
                        index++;
                    }
                }
            } else {

            }
        } else if (NachtSpawnPoints.getNachtDoor2().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 2, 350D, 0.207);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom3()) {
                    ZombieManager.createZombieSpawnChain(location, 3, 350D, 0.207);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 2) break;
                        en.remove();
                        index++;
                    }
                }
            }
        } else if (NachtSpawnPoints.getNachtDoor2().isUnlocked() && NachtSpawnPoints.getNachtDoor1().isUnlocked() || NachtSpawnPoints.getNachtDoor2().isUnlocked() && NachtSpawnPoints.getNachtDoor3().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 2, 350D, 0.207);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom2()) {
                    ZombieManager.createZombieSpawnChain(location, 2, 350D, 0.207);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom3()) {
                    ZombieManager.createZombieSpawnChain(location, 2, 350D, 0.207);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 4) break;
                        en.remove();
                        index++;
                    }
                }
            } else {

            }
        } else {
            for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                ZombieManager.createZombieSpawnChain(location, 4, 350D, 0.207);
            }
        }
    }

    public static void spawnRound4() {
        if (NachtSpawnPoints.getNachtDoor1().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 3, 450D, 0.23);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom2()) {
                    ZombieManager.createZombieSpawnChain(location, 4, 450D, 0.23);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 3) break;
                        en.remove();
                        index++;
                    }
                }
            } else {

            }
        } else if (NachtSpawnPoints.getNachtDoor2().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 3, 450D, 0.23);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom3()) {
                    ZombieManager.createZombieSpawnChain(location, 3, 450D, 0.23);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 2) break;
                        en.remove();
                        index++;
                    }
                }
            }
        } else if (NachtSpawnPoints.getNachtDoor2().isUnlocked() && NachtSpawnPoints.getNachtDoor1().isUnlocked() || NachtSpawnPoints.getNachtDoor2().isUnlocked() && NachtSpawnPoints.getNachtDoor3().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 2, 450D, 0.23);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom2()) {
                    ZombieManager.createZombieSpawnChain(location, 3, 450D, 0.23);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom3()) {
                    ZombieManager.createZombieSpawnChain(location, 2, 450D, 0.23);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 2) break;
                        en.remove();
                        index++;
                    }
                }
            } else {

            }
        } else {
            for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                ZombieManager.createZombieSpawnChain(location, 5, 450D, 0.23);
            }
        }
    }

    public static void spawnRound5() {
        if (NachtSpawnPoints.getNachtDoor1().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 4, 550D, 0.23);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom2()) {
                    ZombieManager.createZombieSpawnChain(location, 3, 550D, 0.23);
                }
            } else {

            }
        } else if (NachtSpawnPoints.getNachtDoor2().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 3, 550D, 0.23);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom3()) {
                    ZombieManager.createZombieSpawnChain(location, 4, 550D, 0.23);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 2) break;
                        en.remove();
                        index++;
                    }
                }
            }
        } else if (NachtSpawnPoints.getNachtDoor2().isUnlocked() && NachtSpawnPoints.getNachtDoor1().isUnlocked() || NachtSpawnPoints.getNachtDoor2().isUnlocked() && NachtSpawnPoints.getNachtDoor3().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 2, 550D, 0.23);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom2()) {
                    ZombieManager.createZombieSpawnChain(location, 3, 550D, 0.23);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom3()) {
                    ZombieManager.createZombieSpawnChain(location, 3, 550D, 0.23);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 2) break;
                        en.remove();
                        index++;
                    }
                }
            } else {

            }
        } else {
            for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                ZombieManager.createZombieSpawnChain(location, 6, 550D, 0.23);
            }
            Location loc = NachtSpawnPoints.getNachtRoom1()[1];
            int index = 0;
            for (Entity en : loc.getWorld().getEntities()) {
                if (en instanceof Zombie) {
                    if (index == 1) break;
                    en.remove();
                    index++;
                }
            }
        }


    }

    public static void spawnRound6() {
        if (NachtSpawnPoints.getNachtDoor1().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 4, 650D, 0.23);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom2()) {
                    ZombieManager.createZombieSpawnChain(location, 5, 650D, 0.23);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 1) break;
                        en.remove();
                        index++;
                    }
                }
            } else {

            }
        } else if (NachtSpawnPoints.getNachtDoor2().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 4, 650D, 0.23);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom3()) {
                    ZombieManager.createZombieSpawnChain(location, 4, 650D, 0.23);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 2) break;
                        en.remove();
                        index++;
                    }
                }
            }
        } else if (NachtSpawnPoints.getNachtDoor2().isUnlocked() && NachtSpawnPoints.getNachtDoor1().isUnlocked() || NachtSpawnPoints.getNachtDoor2().isUnlocked() && NachtSpawnPoints.getNachtDoor3().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 3, 650D, 0.23);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom2()) {
                    ZombieManager.createZombieSpawnChain(location, 3, 650D, 0.23);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom3()) {
                    ZombieManager.createZombieSpawnChain(location, 3, 650D, 0.23);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 2) break;
                        en.remove();
                        index++;
                    }
                }
            } else {

            }
        } else {
            for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                ZombieManager.createZombieSpawnChain(location, 7, 650D, 0.23);
            }
            Location loc = NachtSpawnPoints.getNachtRoom1()[1];
            int index = 0;
            for (Entity en : loc.getWorld().getEntities()) {
                if (en instanceof Zombie) {
                    if (index == 1) break;
                    en.remove();
                    index++;
                }
            }
        }


    }

    public static void spawnRound7() {
        if (NachtSpawnPoints.getNachtDoor1().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 5, 750D, 0.23);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom2()) {
                    ZombieManager.createZombieSpawnChain(location, 5, 750D, 0.23);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 2) break;
                        en.remove();
                        index++;
                    }
                }
            } else {

            }
        } else if (NachtSpawnPoints.getNachtDoor2().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 5, 750D, 0.23);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom3()) {
                    ZombieManager.createZombieSpawnChain(location, 4, 750D, 0.23);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 3) break;
                        en.remove();
                        index++;
                    }
                }
            }
        } else if (NachtSpawnPoints.getNachtDoor2().isUnlocked() && NachtSpawnPoints.getNachtDoor1().isUnlocked() || NachtSpawnPoints.getNachtDoor2().isUnlocked() && NachtSpawnPoints.getNachtDoor3().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 3, 750D, 0.23);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom2()) {
                    ZombieManager.createZombieSpawnChain(location, 4, 750D, 0.23);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom3()) {
                    ZombieManager.createZombieSpawnChain(location, 3, 750D, 0.23);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 1) break;
                        en.remove();
                        index++;
                    }
                }
            } else {

            }
        } else {
            for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                ZombieManager.createZombieSpawnChain(location, 8, 750D, 0.23);
            }
            Location loc = NachtSpawnPoints.getNachtRoom1()[1];
            int index = 0;
            for (Entity en : loc.getWorld().getEntities()) {
                if (en instanceof Zombie) {
                    if (index == 2) break;
                    en.remove();
                    index++;
                }
            }
        }
    }

    public static void spawnRound8() {
        if (NachtSpawnPoints.getNachtDoor1().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 5, 850D, 0.23);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom2()) {
                    ZombieManager.createZombieSpawnChain(location, 6, 850D, 0.23);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 1) break;
                        en.remove();
                        index++;
                    }
                }
            } else {

            }
        } else if (NachtSpawnPoints.getNachtDoor2().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 5, 850D, 0.23);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom3()) {
                    ZombieManager.createZombieSpawnChain(location, 5, 850D, 0.23);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 3) break;
                        en.remove();
                        index++;
                    }
                }
            }
        } else if (NachtSpawnPoints.getNachtDoor2().isUnlocked() && NachtSpawnPoints.getNachtDoor1().isUnlocked() || NachtSpawnPoints.getNachtDoor2().isUnlocked() && NachtSpawnPoints.getNachtDoor3().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 3, 850D, 0.23);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom2()) {
                    ZombieManager.createZombieSpawnChain(location, 4, 850D, 0.23);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom3()) {
                    ZombieManager.createZombieSpawnChain(location, 4, 850D, 0.23);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 1) break;
                        en.remove();
                        index++;
                    }
                }
            } else {

            }
        } else {
            for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                ZombieManager.createZombieSpawnChain(location, 9, 850D, 0.23);
            }
            Location loc = NachtSpawnPoints.getNachtRoom1()[1];
            int index = 0;
            for (Entity en : loc.getWorld().getEntities()) {
                if (en instanceof Zombie) {
                    if (index == 3) break;
                    en.remove();
                    index++;
                }
            }
        }
    }

    public static void spawnRound9() {
        if (NachtSpawnPoints.getNachtDoor1().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 5, 950D, 0.276);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom2()) {
                    ZombieManager.createZombieSpawnChain(location, 7, 950D, 0.276);
                }
            } else {

            }
        } else if (NachtSpawnPoints.getNachtDoor2().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 5, 950D, 0.276);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom3()) {
                    ZombieManager.createZombieSpawnChain(location, 6, 950D, 0.276);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 3) break;
                        en.remove();
                        index++;
                    }
                }
            }
        } else if (NachtSpawnPoints.getNachtDoor2().isUnlocked() && NachtSpawnPoints.getNachtDoor1().isUnlocked() || NachtSpawnPoints.getNachtDoor2().isUnlocked() && NachtSpawnPoints.getNachtDoor3().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 3, 950D, 0.276);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom2()) {
                    ZombieManager.createZombieSpawnChain(location, 5, 950D, 0.276);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom3()) {
                    ZombieManager.createZombieSpawnChain(location, 4, 950D, 0.276);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 1) break;
                        en.remove();
                        index++;
                    }
                }
            } else {

            }
        } else {
            for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                ZombieManager.createZombieSpawnChain(location, 10, 950D, 0.276);
            }
            Location loc = NachtSpawnPoints.getNachtRoom1()[1];
            int index = 0;
            for (Entity en : loc.getWorld().getEntities()) {
                if (en instanceof Zombie) {
                    if (index == 4) break;
                    en.remove();
                    index++;
                }
            }
        }
    }

    public static void spawnRound10() {
        if (NachtSpawnPoints.getNachtDoor1().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 6, 1045D, 0.276);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom2()) {
                    ZombieManager.createZombieSpawnChain(location, 7, 1045D, 0.276);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 1) break;
                        en.remove();
                        index++;
                    }
                }
            } else {

            }
        } else if (NachtSpawnPoints.getNachtDoor2().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 5, 1045D, 0.276);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom3()) {
                    ZombieManager.createZombieSpawnChain(location, 7, 1045D, 0.276);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 3) break;
                        en.remove();
                        index++;
                    }
                }
            }
        } else if (NachtSpawnPoints.getNachtDoor2().isUnlocked() && NachtSpawnPoints.getNachtDoor1().isUnlocked() || NachtSpawnPoints.getNachtDoor2().isUnlocked() && NachtSpawnPoints.getNachtDoor3().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 4, 1045D, 0.276);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom2()) {
                    ZombieManager.createZombieSpawnChain(location, 5, 1045D, 0.276);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom3()) {
                    ZombieManager.createZombieSpawnChain(location, 4, 1045D, 0.276);
                }
            } else {

            }
        } else {
            for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                ZombieManager.createZombieSpawnChain(location, 10, 1045D, 0.276);
            }
        }
    }

    public static void spawnRound11() {
        if (NachtSpawnPoints.getNachtDoor1().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 6, 1150D, 0.322);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom2()) {
                    ZombieManager.createZombieSpawnChain(location, 8, 1150D, 0.322);
                }
            } else {

            }
        } else if (NachtSpawnPoints.getNachtDoor2().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 5, 1150D, 0.322);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom3()) {
                    ZombieManager.createZombieSpawnChain(location, 7, 1150D, 0.322);
                }
                Location loc = NachtSpawnPoints.getNachtRoom1()[1];
                int index = 0;
                for (Entity en : loc.getWorld().getEntities()) {
                    if (en instanceof Zombie) {
                        if (index == 3) break;
                        en.remove();
                        index++;
                    }
                }
            }
        } else if (NachtSpawnPoints.getNachtDoor2().isUnlocked() && NachtSpawnPoints.getNachtDoor1().isUnlocked() || NachtSpawnPoints.getNachtDoor2().isUnlocked() && NachtSpawnPoints.getNachtDoor3().isUnlocked()) {
            if (Bukkit.getOnlinePlayers().size() <= 4) {
                for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                    ZombieManager.createZombieSpawnChain(location, 4, 1150D, 0.322);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom2()) {
                    ZombieManager.createZombieSpawnChain(location, 5, 1150D, 0.322);
                }
                for (Location location : NachtSpawnPoints.getNachtRoom3()) {
                    ZombieManager.createZombieSpawnChain(location, 4, 1150D, 0.322);
                }
            } else {

            }
        } else {
            for (Location location : NachtSpawnPoints.getNachtRoom1()) {
                ZombieManager.createZombieSpawnChain(location, 10, 1150D, 0.322);
            }
        }
    }
}
