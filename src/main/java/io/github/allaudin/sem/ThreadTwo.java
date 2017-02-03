package io.github.allaudin.sem;

import java.util.concurrent.Semaphore;

/**
 * Created by Qazi on 2017-02-03.
 *
 * @author M.Allaudin
 */
 class ThreadTwo extends Thread {

    private Semaphore semaphore;

    ThreadTwo(Semaphore semaphore) {
        super("thread-2");
        this.semaphore = semaphore;
    } // ThreadOne

    @Override
    public void run() {
        System.out.println(getName() + " acquiring lock.");
        try {
            semaphore.acquire();
            System.out.println(getName() + " lock acquired. incrementing resource");

            for (int i = 0; i < 3; i++) {
                SharedResource.counter++;
                Thread.sleep(200);
            }

            System.out.println(getName() + " releasing lock.");
            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } //

}
