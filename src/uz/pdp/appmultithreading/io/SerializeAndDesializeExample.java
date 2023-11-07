package uz.pdp.appmultithreading.io;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;

public class SerializeAndDesializeExample {

    public static void main(String[] args) {

        write();
        read();
    }

    private static void read() {

        try {
            ObjectInputStream objectOutputStream = new ObjectInputStream(new FileInputStream("serialize/object.txt"));
            Student student = (Student) objectOutputStream.readObject();
            System.out.println(student);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static void write() {
        Student student = new Student(
                "Ali Olimov",
                2,
                LocalDate.of(1999, Month.OCTOBER, 13),
                false
        );

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("serialize/object.txt"));
            objectOutputStream.writeObject(student);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static class Student implements Serializable, Externalizable {
        private String fullName;
        private int course;
        private LocalDate birthDate;
        private boolean married;

        public Student(){

        }

        public Student(String fullName, int course, LocalDate birthDate, boolean married) {
            this.fullName = fullName;
            this.course = course;
            this.birthDate = birthDate;
            this.married = married;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public int getCourse() {
            return course;
        }

        public void setCourse(int course) {
            this.course = course;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
        }

        public boolean isMarried() {
            return married;
        }

        public void setMarried(boolean married) {
            this.married = married;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "fullName='" + fullName + '\'' +
                    ", course=" + course +
                    ", birthDate=" + birthDate +
                    ", married=" + married +
                    '}';
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(fullName);
            out.writeObject(course);
//            out.writeObject(birthDate);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.fullName = (String) in.readObject();
            this.course = (int) in.readObject();
            this.birthDate = (LocalDate) in.readObject();
        }
    }

}
