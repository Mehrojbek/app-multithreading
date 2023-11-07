package uz.pdp.appmultithreading.concurrency;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicTest {

    public static AtomicLong number = new AtomicLong(0);
    public static AtomicReference<Double> atomicReference = new AtomicReference<>(0d);

    public static void main(String[] args) {

        m2();

//        m1();
    }

    private static void m2() {

//        AtomicReference<Integer> integerAtomicReference = new AtomicReference<>(0);
        var ref = new Object() {
            Integer integerAtomicReference = 0;
        };

        var obj = new Object() {
            String firstName;
            String lastName;
            String phoneNumber;
            LocalDate birthDate;
        };

        obj.firstName = "gsdvgu";
        obj.lastName = "hdscgh";


        Runnable task = () -> {
//            integerAtomicReference.getAndUpdate(integer -> integer + 1);
            ref.integerAtomicReference = ref.integerAtomicReference +1;
        };

        for (int i = 0; i < 10000; i++) {
            new Thread(task).start();
        }

//        Integer integer = integerAtomicReference.get();
        System.out.println(ref.integerAtomicReference);

    }

    private static void m1() {
        Runnable task = () -> {

//            number = number + 1;
            number.incrementAndGet();
        };

        for (int i = 0; i <= 10000; i++) {

            new Thread(task).start();

        }

        System.out.println(number.get());
    }

}
