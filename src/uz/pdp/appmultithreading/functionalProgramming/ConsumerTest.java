package uz.pdp.appmultithreading.functionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerTest {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>(
                List.of(
                        "java",
                        "scala",
                        "js",
                        "c#"
                )
        );

        //hech narsa qaytarmaydigan va element qabul qiluvchi
        //accept methodi ishlaydi
//        Consumer

        List<String> collect = strings
                .stream()
                .peek(s -> System.out.println(s))
                .collect(Collectors.toList());

        System.out.println(collect.size());

    }

}
