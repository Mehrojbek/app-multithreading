package uz.pdp.appmultithreading.synchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Homework {
    public static Lock lock = new ReentrantLock();
    public static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {

        List<Card> cards = generateCards();

        double sum = cards.stream().map(Card::getBalance).mapToDouble(Double::doubleValue).sum();

        System.out.println(sum);

        Random random = new Random();
        Runnable task = () -> {

            int from = random.nextInt(30);
            int to = random.nextInt(30);

            double amount = random.nextInt(30);

            Card toCard = cards.get(to);
            Card fromCard = cards.get(from);
            transfer(fromCard, toCard, amount);

        };

        long millis = System.currentTimeMillis();

        for (int i = 0; i < 40000; i++) {
            new Thread(task).start();
        }

        double sumAfter = cards.stream().map(Card::getBalance).mapToDouble(Double::doubleValue).sum();

        System.out.println("millisekundlar soni -> " + (System.currentTimeMillis() - millis));
        System.out.println(sumAfter);

    }

    private static void transfer(Card fromCard, Card toCard, double amount) {

        synchronized (object) {
//        try {
//            lock.lock();

            if (fromCard.getBalance() >= amount) {

                fromCard.setBalance(fromCard.getBalance() - amount);
                toCard.setBalance(toCard.getBalance() + amount);

            }
        }
//        } finally {
//            lock.unlock();
//        }
    }

    private static List<Card> generateCards() {

        Random random = new Random();
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 30; i++) {

            Card card = new Card(
                    random.nextInt(300, 800),
                    i
            );

            cards.add(card);
        }

        return cards;
    }


    static class Card {
        private Double balance;
        private long id;

        public Card(double balance, long id) {
            this.balance = balance;
            this.id = id;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "balance=" + balance +
                    ", id=" + id +
                    '}';
        }
    }

}
