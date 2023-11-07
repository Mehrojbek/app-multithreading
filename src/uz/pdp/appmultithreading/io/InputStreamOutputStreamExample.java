package uz.pdp.appmultithreading.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class InputStreamOutputStreamExample {

    public static void main(String[] args) {

//        inputStream();

//        outputStream();

//        dataOutputStream();

//        dataInputStream();

    }

    private static void dataInputStream() {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("D/Test/Yangi/data.txt"))) {
            double v = dataInputStream.readDouble();
            System.out.println(v);
            long l = dataInputStream.readLong();
            System.out.println(l);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dataOutputStream() {

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("io/data.txt"))) {
            dataOutputStream.writeDouble(125.9);
            dataOutputStream.writeLong(56791);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void outputStream() {
        File file = new File("io/test1.txt");
        try (OutputStream out = new FileOutputStream(file)) {

            String str = "Bu faylga yoziladigan text";
            out.write(str.getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void inputStream() {
        File file = new File("io/test.txt");
        try (InputStream in = new FileInputStream(file)) {

            byte[] bytes = in.readAllBytes();

            String str = new String(bytes);
            System.out.println(str);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
