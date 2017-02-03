package io.github.allaudin.sem;

import java.util.concurrent.Semaphore;

/**
 * Created by Qazi on 2017-02-03.
 *
 * @author M.Allaudin
 */
public class SemApp {

    public static void run() throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);

        ThreadOne t1 = new ThreadOne(semaphore);
        ThreadTwo t2 = new ThreadTwo(semaphore);

        t1.start();
        t2.start();


        t1.join();
        t2.join();

        System.out.println("resource value = " + SharedResource.counter);
    } // main

}
