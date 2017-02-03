package io.github.allaudin.clatch;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Qazi on 2017-02-01.
 *
 * @author M.Allaudin
 */
class NumberThread extends Thread {

    List<Integer> list;
    CountDownLatch latch;

    NumberThread(String name, List<Integer> list, CountDownLatch latch){
        super(name);
        this.list = list;
        this.latch = latch;
    } // NumberThread

    @Override
    public void run() {
        super.run();
        String threadName = getName();

        System.out.printf("%s - starts waiting\n", threadName);
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int value = new Random().nextInt(100);
        System.out.printf("%s - inserting %d in the list\n", threadName, value);
        list.add(value);

        System.out.printf("%s - invoking countDown on latch\n", threadName);
        latch.countDown();

    } // run

} // NumberThread
