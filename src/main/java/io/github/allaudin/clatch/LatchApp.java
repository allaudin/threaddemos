package io.github.allaudin.clatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Qazi on 2017-01-25.
 *
 * @author M.Allaudin
 */
public class LatchApp {
    
    public static void run() throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(2);

        ThreadOne one = new ThreadOne(list, latch);
        ThreadTwo two = new ThreadTwo(list, latch);
        NumberThread three = new ThreadThree(list, latch, one, two);

        three.start();
        one.start();
        two.start();

        one.join();
        two.join();
        three.join();

    } // main
    
} // LatchApp

