package io.github.allaudin.clatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Qazi on 2017-02-01.
 *
 * @author M.Allaudin
 */
class ThreadTwo extends NumberThread {

    ThreadTwo(List<Integer> list, CountDownLatch latch) {
        super(ThreadTwo.class.getSimpleName(), list, latch);
    } // ThreadTwo

} // ThreadTwo
