package uz.pdp.appmultithreading.threadPool;

import java.util.concurrent.*;

public class ExecuterExample {

    public static void main(String[] args) throws InterruptedException {

        executor();

//        scheduledExecutor();

    }

    private static void scheduledExecutor() throws InterruptedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        Runnable task = () -> {

            System.out.println("task completed :: " + Thread.currentThread());
//            try {
//                Thread.sleep(8000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

        };
        //2 sekunddan keyin vazifani bajaradi
//        scheduledExecutorService.schedule(task, 2, TimeUnit.SECONDS);

        //period da berilgan vaqtda qaytatdan vazifani ishga tushiradi va qayta priodni hisoblaydi
        scheduledExecutorService.scheduleAtFixedRate(task, 2, 1,TimeUnit.SECONDS);

        scheduledExecutorService.awaitTermination(3,TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();

        //vazifani bajarilgandan peyin period hisoblaydi
//        scheduledExecutorService.scheduleWithFixedDelay(task,0, 1, TimeUnit.SECONDS);
//        Thread.sleep(1000);
//        scheduledExecutorService.shutdown();

    }

    private static void executor() throws InterruptedException {
        //        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newFixedThreadPool(35);
        ExecutorService executorService = Executors.newCachedThreadPool();


//        scheduledExecutorService.

        Runnable task1 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Task1 completed :: " + Thread.currentThread() + " ");
        };
        Runnable task2 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Task2 completed :: " + Thread.currentThread() + " ");
        };
        Thread.sleep(2000);

        long start = System.currentTimeMillis();


        for (int i = 0; i < 200; i++) {
            executorService.execute(task1);
            executorService.execute(task2);
        }

//        executorService.shutdown();
//        executorService.shutdownNow();

        long end = System.currentTimeMillis();

        System.out.println(Thread.activeCount());

//        System.out.println(end - start);
    }

}
