package uz.pdp.appmultithreading.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable task = () -> {
            ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
//            System.out.println(threadLocalRandom.hashCode() + " :: " + Thread.currentThread());
            int number = threadLocalRandom.nextInt(30);
            System.out.println(number);
        };

        for (int i = 0; i < 2000; i++) {
            executorService.submit(task);
        }


        executorService.shutdown();
    }

}
