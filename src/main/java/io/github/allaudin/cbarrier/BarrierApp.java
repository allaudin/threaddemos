package io.github.allaudin.cbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Qazi on 2017-02-03.
 *
 * @author M.Allaudin
 */

public class BarrierApp {

    public static void run(){
        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("reached"));

        new MyThread("A", barrier).start();
        new MyThread("B", barrier).start();
        new MyThread("C", barrier).start();

    } // main

} // BarrierApp
