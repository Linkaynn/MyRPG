package util;

import org.junit.Test;

public class Util_ {

    @Test (timeout=210)
    public void simulates_thread_sleep() throws Exception {
        Util.sleep(200);
    }
}
