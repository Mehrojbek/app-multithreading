package uz.pdp.appmultithreading.multiThread;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //joriy thread
        Thread thread = Thread.currentThread();
        System.out.println(thread);
//
//        int activeCount = Thread.activeCount();
//        System.out.println(activeCount);
//
//        Thread[] threads = new Thread[activeCount];
//        Thread.enumerate(threads);
//
//        for (Thread thread1 : threads) {
//            System.out.println(thread1);
//        }

//        MyThread myThread = new MyThread();
//        myThread.start();


//        //vazifa
//        MyRunnable myRunnable = new MyRunnable();
//
//        //ishchi
//        Thread worker = new Thread(myRunnable,"bu mening yangi ishchim");
//
//        worker.start();
//
//        System.out.println("ishladi");

        Runnable task1 = ()-> {

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("task 1 is completed");
        };

        Runnable task2 = ()-> {

            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("task 2 is completed");
        };


        //thread 1 ni kutadi bajarilishini

        Thread thread2 = new Thread(task2);
        thread2.start();

        //
        thread2.join(3000);

        Thread thread1 = new Thread(task1);
        thread1.start();




        throw new RuntimeException("Main thread tugayapti");
    }

    public static boolean pay(double amount){

        //check-> tekshiruv
        Runnable afterPaymentTask = () -> taskAfterPay(amount);

        new Thread(afterPaymentTask).start();

        return true;
    }

    private static void taskAfterPay(double amount) {
        // TODO: 19/10/23 Qanaqadir ishlar bu 5 sekund vaqt oladi
    }

    static class MyThread extends Thread{
        @Override
        public synchronized void start() {
            System.out.println("my thread ishladi ->  " + Thread.currentThread().getName());
        }
    }

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("my runnable is working -> " + Thread.currentThread().getName());
        }
    }

}
