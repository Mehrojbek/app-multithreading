package uz.pdp.appmultithreading.forkandjoin;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CounterTask extends RecursiveTask<Integer> {

    private List<Integer> numbers;
    private int from;
    private int to;
    private int limit = 1000;

    public CounterTask(List<Integer> numbers, int from, int to) {
        this.numbers = numbers;
        this.from = from;
        this.to = to;
    }

    @Override
    protected Integer compute() {

        //limitgacha bo'lingan subtask da bitta thread bajarishi kerak bo'lgan vazifa
        if (to - from <= limit) {

            int counter = 0;
            for (int i = from; i < to; i++) {
                if (numbers.get(i) > 2) {
                    counter++;
                }
            }

            return counter;

            //bo'linishi kerak bo'lgan limitdan katta bo'lish kerak
        } else {

            int mid = from + (to - from)/2;

            if (from > mid || mid > to)
                System.err.println("error");

            CounterTask first = new CounterTask(numbers, from, mid);
            CounterTask second = new CounterTask(numbers, mid, to);
            invokeAll(first, second);
            return first.join() + second.join();
        }
    }
}
