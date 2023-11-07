package uz.pdp.appmultithreading.concurrency;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CollectionTest {
    public static Lock lock = new ReentrantLock();

    public static Set<Integer> integers = new HashSet<>();

    public static void main(String[] args) throws InterruptedException {


        //synchrondan ko'ra tezroq ishlaydi
        var syncIntegers = ConcurrentHashMap.newKeySet();

//        Set<Integer> syncIntegers = Collections.synchronizedSet(integers);

        Runnable task1 = () -> {
            for (int i = 0; i < 5000; i++) {
                syncIntegers.add(i);
            }
        };

        Runnable task2 = () -> {
            for (int i = 5000; i < 10000; i++) {
                syncIntegers.add(i);
            }
        };

        new Thread(task1).start();

        new Thread(task2).start();

        TimeUnit.SECONDS.sleep(1);

        System.out.println(syncIntegers.size());

    }

}
