package uz.pdp.appmultithreading.forkandjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkAndJoinExample {

    public static void main(String[] args) {

        List<Integer> integers = generateIntegers();

        long begin = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CounterTask counterTask = new CounterTask(integers,0,integers.size());
        forkJoinPool.invoke(counterTask);
        Integer join = counterTask.join();
        long end = System.currentTimeMillis();
        System.out.println(join + " vaqt -> " + (end - begin));

        simpleSolution(integers);

    }

    private static void simpleSolution(List<Integer> integers) {
        long begin = System.currentTimeMillis();
        Integer count = 0;
        for (Integer integer : integers) {
            if (integer > 2)
                count++;
        }
        long end = System.currentTimeMillis();

        System.out.println(count + " vaqt -> " + (end - begin));
    }

    private static List<Integer> generateIntegers() {
        Random random = new Random();
        List<Integer> integers = new ArrayList<>(510_000_000);
        for (int i = 0; i < 510_000_000; i++) {
            integers.add(random.nextInt(10));
        }
        return integers;
    }

}
