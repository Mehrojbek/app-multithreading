package uz.pdp.appmultithreading.threadPool;

import java.util.concurrent.*;

public class CallableAndFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String fromCard = "86001";
        String toCard = "86002";
        double amount = 400_000;

//        effectiveAproach(fromCard,toCard,amount);

        simpleWay(fromCard, toCard, amount);
    }

    private static void effectiveAproach(String fromCard, String toCard, double amount) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Boolean> callableCardFrom = () -> cardIsBlocked(fromCard);
        Callable<Boolean> callableCardTo = () -> cardIsBlocked(toCard);

        Future<Boolean> submitFromCard = executorService.submit(callableCardFrom);
        Future<Boolean> submitToCard = executorService.submit(callableCardTo);

        Boolean fromCardCheck = submitFromCard.get();
        Boolean toCardCheck = submitToCard.get();

        if (fromCardCheck || toCardCheck)
            throw new RuntimeException("Cards are blocked");

        boolean transfer = transfer(fromCard, toCard, amount);
        if (!transfer)
            throw new RuntimeException("Error occured while transfer");

        long end = System.currentTimeMillis();
        System.out.println("Transfer uchun ketgan vaqt -> " + (end - start));

        executorService.shutdown();
    }

    private static void simpleWay(String fromCard, String toCard, double amount) {
        long start = System.currentTimeMillis();
        boolean fromCardBlocked = cardIsBlocked(fromCard);
        if (fromCardBlocked)
            throw new RuntimeException("From card is blocked");

        boolean toCardBlocked = cardIsBlocked(toCard);
        if (toCardBlocked)
            throw new RuntimeException("To card is blocked");

        boolean transfer = transfer(fromCard, toCard, amount);
        if (!transfer)
            throw new RuntimeException("Error occured while transfer");

        long end = System.currentTimeMillis();
        System.out.println("Transfer uchun ketgan vaqt -> " + (end - start));
    }

    public static boolean cardIsBlocked(String cardNumber){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static boolean transfer(String fromCard, String toCard, double amount){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

}
