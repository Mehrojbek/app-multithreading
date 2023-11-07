package uz.pdp.appmultithreading.functionalProgramming;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AllTest {

    public static void main(String[] args) {

        List<Student> students = getStudents();

        System.out.println(students);

        List<String> collect = students
                .stream()

                //consumer
                .peek(student -> {
                    int age = (int) Duration.between(student.getBirthDate(),LocalDateTime.now()).toDays() / 365;
                    student.setAge(age);
                })

                //predicate
                .filter(student -> student.getAge() > 22)

                //function
                .map(student -> {
                    return student.getFullName() + " -> " + student.getPhoneNumber();
                })

                .collect(Collectors.toList());

        //1. 30 ta integerni random generate qilib ichidan
        //juft larini alohida listga yig'ib olinsin

        //2. 40 ta ingeterni random generate qilib ichidan
        //tub son bo'lganlarini 2 ga ko'paytirib listga yig'ib olinsin

        //3. 10 ta integer olinsin va ularni har birini stream qilib
        //agar son manfiy bo'lsa "manfiy->son" ko'rinishida string
        //listiga yig'ib olinsin.


        System.out.println("========");
        System.out.println(collect);
    }

    private static List<Student> getStudents() {
        return new ArrayList<>(
                List.of(
                        new Student(
                                "Ali Aliyev",
                                "998901234567",
                                null,
                                LocalDateTime.of(1999,5,7,0,0),
                                GenderEnum.MALE
                        ),
                        new Student(
                                "Ali Aliyev",
                                "998901234567",
                                null,
                                LocalDateTime.of(1999,5,7,0,0),
                                GenderEnum.MALE
                        ),
                        new Student(
                                "Ozoda Ozodov",
                                "998901234587",
                                null,
                                LocalDateTime.of(2001,5,9,0,0),
                                GenderEnum.FEMALE
                        ),
                        new Student(
                                "Ahmad Bozorov",
                                "998901734567",
                                null,
                                LocalDateTime.of(1999,5,7,0,0),
                                GenderEnum.MALE
                        ),
                        new Student(
                                "Vali Valiyev",
                                "998901238867",
                                null,
                                LocalDateTime.of(1994,5,7,0,0),
                                GenderEnum.MALE
                        ),
                        new Student(
                                "Shoxsanam Valiyev",
                                "998906664567",
                                null,
                                LocalDateTime.of(1987,5,7,0,0),
                                GenderEnum.FEMALE
                        ),
                        new Student(
                                "Ali Aliyev",
                                "998901234567",
                                null,
                                LocalDateTime.of(1999,5,7,0,0),
                                GenderEnum.MALE
                        ),
                        new Student(
                                "Ali Aliyev",
                                "998901234567",
                                null,
                                LocalDateTime.of(1999,5,7,0,0),
                                GenderEnum.MALE
                        ),
                        new Student(
                                "Ali Aliyev",
                                "998901234567",
                                null,
                                LocalDateTime.of(1999,5,7,0,0),
                                GenderEnum.MALE
                        ),
                        new Student(
                                "Ali Aliyev",
                                "998901234567",
                                null,
                                LocalDateTime.of(1999,5,7,0,0),
                                GenderEnum.MALE
                        ),
                        new Student(
                                "Ali Aliyev",
                                "998901234567",
                                null,
                                LocalDateTime.of(1999,5,7,0,0),
                                GenderEnum.MALE
                        ),
                        new Student(
                                "Ali Aliyev",
                                "998901234567",
                                null,
                                LocalDateTime.of(1999,5,7,0,0),
                                GenderEnum.MALE
                        ),
                        new Student(
                                "Ali Aliyev",
                                "998901234567",
                                null,
                                LocalDateTime.of(1999,5,7,0,0),
                                GenderEnum.MALE
                        ),
                        new Student(
                                "Ali Aliyev",
                                "998901234567",
                                null,
                                LocalDateTime.of(1999,5,7,0,0),
                                GenderEnum.MALE
                        )
                )
        );
    }

}
