package io.github.allaudin.clatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Qazi on 2017-02-01.
 *
 * @author M.Allaudin
 */
class ThreadThree extends NumberThread {

    ThreadOne threadOne;
    ThreadTwo threadTwo;

    ThreadThree(List<Integer> list, CountDownLatch latch, ThreadOne threadOne, ThreadTwo threadTwo) {
        super(ThreadThree.class.getSimpleName(), list, latch);
        this.threadOne = threadOne;
        this.threadTwo = threadTwo;
    }

    @Override
    public void run() {
        try {

            System.out.printf("%s - starts waiting for other threads to complete\n", getName());
            latch.await(); // wait for other threads to insert values

            int sum = list.get(0) + list.get(1);

            System.out.printf("%s - sum = %d\n", getName(), sum);

            System.out.printf("\nThread States\n");
            System.out.printf("%s - %s [%s], %s [%s]", getName(), threadOne.getName(), threadOne.getState(), threadTwo.getName(), threadTwo.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } // run

} // ThreadThree
