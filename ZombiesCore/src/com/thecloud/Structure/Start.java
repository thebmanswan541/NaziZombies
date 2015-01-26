package com.thecloud.Structure;

public class Start implements Runnable {

    public static int countdowntime = 60;

    public void run() {
        countdowntime--;
        if (countdowntime == 30) {
            ChatUtilities.broadcast("");
        }
    }

}
