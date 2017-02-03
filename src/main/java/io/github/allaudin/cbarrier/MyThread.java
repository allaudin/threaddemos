package io.github.allaudin.cbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Qazi on 2017-02-03.
 *
 * @author M.Allaudin
 */
class MyThread extends Thread {

    private final CyclicBarrier barrier;

    MyThread(String name, CyclicBarrier barrier){
        super(name);
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.printf("running %s \n", getName());
        int sleepTime = new Random().nextInt(2000);
        System.out.printf("[%s] sleeping for %dms\n", getName(), sleepTime);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("[%s] invoking await on barrier[%s]\n", getName(), barrier.hashCode());

        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    } // run

} // MyThread
