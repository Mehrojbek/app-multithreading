package uz.pdp.appmultithreading.io;

import java.io.*;

public class ReaderWriterExample {

    public static void main(String[] args) {

//        fileReader();

//        fileWriter();

        bufferedReader();

    }

    private static void bufferedReader() {

        try (BufferedReader reader = new BufferedReader(new FileReader("io/test.txt"))){

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){
                stringBuilder.append(line).append("\n");
            }

            System.out.println(stringBuilder);

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private static void fileWriter() {

        try(Writer writer = new FileWriter("D:/Test/Yangi/data.txt",true)) {

            String str = "Bu text file writer tomonidan yozildi";
            writer.append(str);

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private static void fileReader() {

        try(Reader reader = new FileReader("io/test.txt")) {

            StringBuilder stringBuilder = new StringBuilder();
            int symbol;
            while ((symbol = reader.read()) != -1){
                stringBuilder.append((char)symbol);
            }

            System.out.println(stringBuilder);

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
