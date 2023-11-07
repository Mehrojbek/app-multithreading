package uz.pdp.appmultithreading.concurrency;

public class Main {

    public volatile static boolean active = true;


    public static void main(String[] args) throws InterruptedException {

        Runnable task1 = () -> {
            while (active) {

            }
            System.out.println("finished -> " + Thread.currentThread());
        };

        new Thread(task1).start();

        new Thread(task1).start();

        Thread.sleep(3);

        active = false;
    }
}
