package uz.pdp.appmultithreading.test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {

    private double[] numbers;
    private int from;
    private int to;
    private int limit = 1000;

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        double[] arr = new double[2];
        MyRecursiveTask myRecursiveTask = new MyRecursiveTask(arr,0,arr.length);
        forkJoinPool.invoke(myRecursiveTask);
        Integer count = myRecursiveTask.join();
        System.out.println(count);
    }

    public MyRecursiveTask(double[] numbers, int from, int to) {
        this.numbers = numbers;
        this.from = from;
        this.to = to;
    }

    @Override
    protected Integer compute() {

        if (to - from < limit) {
            int count = 0;
            for (int i = from; i < to; i++) {
                if (numbers[i] < 0.2)
                    count++;
            }
            return count;
        } else {
            int mid = from + (to - from) / 2;
            MyRecursiveTask first = new MyRecursiveTask(numbers, from, mid);
            MyRecursiveTask second = new MyRecursiveTask(numbers, mid, to);
            invokeAll(first, second);
            return first.join() + second.join();
        }
    }
}
