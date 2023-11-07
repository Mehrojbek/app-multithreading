package uz.pdp.appmultithreading.forkandjoin;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SingletonInMultiThreading {

    public static void main(String[] args) {

        Runnable task = () -> {
            SingleTon instance = SingleTon.getInstance();
            System.out.println(instance.hashCode());
        };

        for (int i = 0; i < 200; i++) {
            new Thread(task).start();
        }

    }

    public static class SingleTon {
        public static Lock lock = new ReentrantLock();

        private static SingleTon instance;

        private SingleTon() {

        }

        public static SingleTon getInstance() {
            if (instance == null) {
                //thread 2 va thread 3
                lock.lock();
                if (instance == null) {
                    try {
                        instance = new SingleTon();
                    } finally {
                        lock.unlock();
                    }
                }
            }
            return instance;
        }


    }

}
