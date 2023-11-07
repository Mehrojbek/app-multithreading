package uz.pdp.appmultithreading.functionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {

    public static void main(String[] args) {

        //predicate bitta element qabul qiladi va boolean qaytaradi
        Predicate<String> predicate = str -> str.length() > 2;

        List<String> strings = new ArrayList<>(
                List.of(
                        "java",
                        "scala",
                        "js",
                        "c#"
                )
        );

        List<String> collect = strings
                .stream()
//                .filter(predicate)
                .filter(str -> str.length() > 3)
                .collect(Collectors.toList());

        System.out.println(collect);

    }

}
