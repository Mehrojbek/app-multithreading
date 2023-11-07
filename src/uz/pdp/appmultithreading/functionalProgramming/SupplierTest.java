package uz.pdp.appmultithreading.functionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) {

        Supplier<Integer> supplier = () -> new Random().nextInt(40);

        List<String> strings = new ArrayList<>(
                List.of(
                        "java",
                        "scala",
                        "js",
                        "c#"
                )
        );


    }

}
