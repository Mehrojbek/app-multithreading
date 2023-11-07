package uz.pdp.appmultithreading.threadPool;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalExample {

    public static ThreadLocal<Random> threadLocal = ThreadLocal.withInitial(() -> new Random());

    public static void main(String[] args) {

        Runnable task = () -> {
//            Random random = threadLocal.get();
            Random random = new Random();
            System.out.println(random.hashCode());
//            if (random == null)
//                threadLocal.set(new Random());
//            random = threadLocal.get();
//            System.out.println(random);
//            int number = random.nextInt(30);
//            System.out.println(number);
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 200; i++) {
            executorService.submit(task);
        }

        executorService.shutdown();


    }

}
