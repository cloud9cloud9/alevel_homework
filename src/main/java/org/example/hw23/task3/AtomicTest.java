package org.example.hw23.task3;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                atomicInteger.incrementAndGet();
            }
        };
        Thread firstThread = new Thread(runnable);
        Thread secondThread = new Thread(runnable);
        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Атомна змінна : " + atomicInteger);
    }
}
