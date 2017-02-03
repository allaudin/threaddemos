package io.github.allaudin.clatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Qazi on 2017-02-01.
 *
 * @author M.Allaudin
 */
class ThreadOne extends NumberThread {

    ThreadOne(List<Integer> list, CountDownLatch latch) {
        super(ThreadOne.class.getSimpleName(), list, latch);
    } // ThreadOne

} // ThreadOne
