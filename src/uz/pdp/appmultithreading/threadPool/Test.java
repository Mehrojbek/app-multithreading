package uz.pdp.appmultithreading.threadPool;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
//            System.out.println("Test::" + Thread.currentThread());
//        }, executorService);
//
//        completableFuture.get();
//
//        executorService.shutdown();


        CompletableFuture<Object> handle = CompletableFuture
                .supplyAsync(() -> {
                    return "Test";
                }, executorService)
                .thenApply(s -> {
                    return "rr";
//                    throw new RuntimeException("bu xato");
                })
//                .thenAccept(System.out::println)
                .exceptionally(throwable -> {
                    System.out.println("exceptionallyga tushti");
                    throw new RuntimeException("bu exceptionallyniki");
                })
                .handle((unused, throwable) -> {
                    if (Objects.nonNull(throwable)) {
                        System.out.println(unused);
                        throw new RuntimeException("bu handle niki");
                    }else {
                        return unused + " yy";
                    }
                });

        System.out.println(handle.get());
        executorService.shutdown();


    }

}
