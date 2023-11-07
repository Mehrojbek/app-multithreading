package uz.pdp.appmultithreading.functionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionTest {

    public static void main(String[] args) {

        //FUNCTION bir element qabul qilib boshqa elementga o'zgartirib qaytaradi
        Function<String,Integer> function = str -> str.length();

        List<String> strings = new ArrayList<>(
                List.of(
                        "java",
                        "scala",
                        "js",
                        "c#"
                )
        );

        List<Long> collect = strings
                .stream()
                .map(str -> 4L)
//                .map(function)
                .collect(Collectors.toList());

        System.out.println(collect);

    }

}
