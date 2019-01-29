package cn.biosan.trace;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class IntegerTests {

    @Test
    public void test() {

        for (int index = 0; index <= 2048; index++) {
            int realQueueSize = 1 << (32 - Integer.numberOfLeadingZeros(index - 1));
            System.out.println("index："+index+ "  realQueueSize:"+realQueueSize);
        }
    }

}

