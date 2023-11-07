package uz.pdp.appmultithreading.forkandjoin;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        thenRun();

//        exceptionally();

//        handle();



    }

    private static void handle() throws InterruptedException {
        CompletableFuture
                .supplyAsync(() -> {
                    if (new Random().nextBoolean())
                        throw new RuntimeException("supply async dan xatolik tushdi");
                    return "some text";
                })
                .handle((str, throwable) -> {
                    if (throwable != null) {
                        System.err.println(throwable.getMessage());
                        return "other text";
                    } else {
                        return str;
                    }
                });

        Thread.sleep(20);
    }

    private static void exceptionally() throws InterruptedException, ExecutionException {
        CompletableFuture<String> exceptionally = CompletableFuture
                .supplyAsync(() -> {
                    boolean nextBoolean = new Random().nextBoolean();
                    if (nextBoolean)
                        throw new RuntimeException("Supply da xatolik");
                    else
                        return "some Text";
                })
                .exceptionally(throwable -> {
                    System.err.println(throwable.getMessage());
                    throw new RuntimeException(throwable);
//                    return "exceptiondagi text";
                });

        String s = exceptionally.get();
        System.out.println(s);
    }

    private static void thenRun() {
        CompletableFuture
                .supplyAsync(() -> {
                    return "Text";
                })
                .thenRun(() -> {
                    System.out.println("then run ishladi");
                });
    }

    private static void thenAccept() throws InterruptedException, ExecutionException {
        CompletableFuture<Void> objectCompletableFuture = CompletableFuture.supplyAsync(() -> {
                    return "Text";
                })
                .thenAccept(str -> {
                    System.out.println(str);
                });

        objectCompletableFuture.get();
    }

    private static void thenApply() {
        //        CompletableFuture<String> completableFutureFirstName = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return "Ism";
//        });
//
//        CompletableFuture<String> completableFutureFullName = completableFutureFirstName.thenApply(str -> {
//            return str + " Familya";
//        });
//
//        CompletableFuture<String> completableFutureData = completableFutureFullName.thenApply(fullName -> {
//            return fullName + " 35";
//        });


        CompletableFuture
                .supplyAsync(() -> {
                    return "Ism";
                })
                .thenApply(firstName -> {
                    return firstName + " familya";
                })
                .thenApply(fullName -> {
                    return fullName + " 31";
                })
                .thenApply(data -> {
                    return data + " male";
                });
    }

    private static void supplyAsync() throws InterruptedException, ExecutionException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Ism";
        });

        CompletableFuture<Boolean> booleanCompletableFuture = CompletableFuture.supplyAsync(CompletableFutureExample::check);
        Boolean check = booleanCompletableFuture.get();
        System.out.println(check);

        for (int i = 0; i < 11; i++) {
            Thread.sleep(200);
            System.out.println(i);
        }

        String str = completableFuture.get();
        System.out.println(str);
    }

    public static boolean check() {
        return true;
    }

    private static void runAsync() throws InterruptedException {
        Runnable task = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("task completed");
        };

        //main ish bo'lyapti
        System.out.println("main thread is working");

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(task);

//        CompletableFuture.runAsync(task);

        for (int i = 1; i <= 5; i++) {
            Thread.sleep(200);
            System.out.println(i);
        }
    }

}
