package util;

public class Util {
    public static void sleep(int milliseconds) {
        long start = System.currentTimeMillis();
        while (true) {
            if (!((start + milliseconds) > System.currentTimeMillis())) break;
        }
    }
}
