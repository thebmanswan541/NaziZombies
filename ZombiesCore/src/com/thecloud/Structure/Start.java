package com.thecloud.Structure;

import com.thecloud.Listeners.Joining;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Start implements Runnable{

    int countdowntime = 60;

    public void run() {
        if (Joining.onlinePlayers.size() == 2) {
            ChatUtilities.broadcast("");
        }
    }

}
