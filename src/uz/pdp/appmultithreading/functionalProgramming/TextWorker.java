package uz.pdp.appmultithreading.functionalProgramming;

@FunctionalInterface
public interface TextWorker {

    void print();

    default void test(){

    }

}
