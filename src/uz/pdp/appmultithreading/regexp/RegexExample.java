package uz.pdp.appmultithreading.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

    public static void main(String[] args) {

        String text = "36263627367";

        System.out.println(text.matches("\\d+"));

        Pattern pattern = Pattern.compile("\\d+");

        Matcher matcher = pattern.matcher(text);

//        System.out.println(matcher.matches());
//        boolean find = matcher.find();
//        System.out.println(find);

//        String group = matcher.group();
//        System.out.println(group);

//        while (matcher.find()){
//            String group = matcher.group();
//            System.out.println(group);
//        }
//


    }

}
