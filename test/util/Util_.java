package util;

import org.junit.Test;

public class Util_ {

    @Test (timeout=200)
    public void simulates_thread_sleep() throws Exception {
        Util.sleep(200);
    }
}
