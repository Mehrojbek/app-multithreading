package uz.pdp.appmultithreading.functionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        //TextWorkerImpl
        TextWorker textWorker = () -> {
            System.out.println("text printing..");
            System.out.println("yangi text");
        };

        List<Integer> integers = getRandomInt();

        System.out.println(integers);

        //vazifa qiymati 7 dan katta sonlarni listga yig'ib berish

        List<Integer> greaterSeven = new ArrayList<>();
        for (Integer integer : integers) {
            if (integer > 7)
                greaterSeven.add(integer);
        }

//        MyConsumer<Integer> myConsumer = number -> System.out.println(number);

//        Consumer
        Predicate<Integer> greaterSevenPredicate = (number) -> number > 7;

        List<Integer> integerList = integers
                .stream()
                .filter(greaterSevenPredicate)
                .filter(number -> number < 14)
//                .map()
                .collect(Collectors.toList());


//        System.out.println(greaterSeven);
        System.out.println(integerList);
//        int nextInt = new Random().nextInt(20);

//        textWorker.print();

    }

    private static List<Integer> getRandomInt() {

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            integers.add(new Random().nextInt(30));
        }

        return integers;
    }

}
