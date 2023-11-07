package uz.pdp.appmultithreading.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.stream.Collectors;

public class NIOExample {

    public static void main(String[] args) {

        File file = new File("io/test3.txt");
//        File parentFile = file.getParentFile();
//
//        System.out.println(file.exists());
//
//        System.out.println(file.getAbsolutePath());
//
////        System.out.println(file.canExecute());
//
//        System.out.println(file.isFile());
//        System.out.println(file.isDirectory());
//
//        System.out.println(file.delete());
//
//        try {
//            System.out.println(file.createNewFile());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        file.renameTo(new File("io/test6666.txt"));

//        System.out.println(file.getParent());
//        System.out.println(file.getParentFile());

//        boolean delete = file.delete();

//        System.out.println(delete);

//        Path path = Paths.get("io/test45.txt");
//        try {
//            Files.delete(path);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Path path = Paths.get("io","zero","first","second","third");
//        try {
//            Path directories = Files.createDirectories(path);
//            System.out.println(directories);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        Path path = Paths.get("io2","first","second","third");
//
//        try {
//            Path directory = Files.createDirectory(path);
//            System.out.println(directory);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//

        Path path = Paths.get("io/test01.txt");

//        File file1 = path.toFile();

//        Path source = Paths.get("io/data.txt");
//        Path target = Paths.get("io2/data.txt");
//        try {
//            Files.copy(source,target);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        boolean exists = Files.exists(path);
//        System.out.println(exists);

//        try {
//            Files.createFile(path);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        try {
//            FileStore fileStore = Files.getFileStore(path);
//            long totalSpace = fileStore.getTotalSpace();
//
//            System.out.println(totalSpace);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        try {
//            UserPrincipal owner = Files.getOwner(path);
//            System.out.println(owner);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        try {
//            FileTime lastModifiedTime = Files.getLastModifiedTime(path);
//            System.out.println(lastModifiedTime);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            List<String> collect = Files.lines(path).collect(Collectors.toList());
//            System.out.println(collect);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }





    }

}
