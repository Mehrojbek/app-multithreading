package uz.pdp.appmultithreading.test;

import java.io.*;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

//        System.out.println("Hello world");

        regex();

    }

    public static void regex(){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher("623876");
        System.out.println(matcher.matches());

        if (matcher.matches()) {
            System.out.println(matcher.start());
            System.out.println(matcher.end());
//            String group = matcher.group();
//            System.out.println(group);
        }
    }

    private static void serialize() throws IOException, ClassNotFoundException {

//        write();
//
        read();

    }

    private static void read() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("serialize/obj.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Employee employee = (Employee) objectInputStream.readObject();
        System.out.println(employee);
    }

    private static void write() throws IOException {
        Employee employee = new Employee("Mehroj","Mavlonov","+998994840597",LocalDate.of(1997,5,4));

        FileOutputStream fileOutputStream = new FileOutputStream("serialize/obj.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(employee);
    }

    public static class Employee implements Serializable{
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private LocalDate birthDate;

        public Employee(String firstName, String lastName, String phoneNumber, LocalDate birthDate) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.birthDate = birthDate;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", birthDate='" + birthDate + '\'' +
                    '}';
        }
    }

}
