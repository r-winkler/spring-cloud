package ch.renewinkler.util;

import java.util.Random;

public class RandomSleep {

    public static void randomSleep() {
        Random rand = new Random();
        int randomNum = rand.nextInt(4);
        if (randomNum == 0) sleep();
    }

    private static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
