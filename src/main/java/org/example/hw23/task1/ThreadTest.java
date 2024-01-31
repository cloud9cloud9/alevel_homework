package org.example.hw23.task1;

public class ThreadTest {
    private static int sharedVariable = 0;
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                sharedVariable++;
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
        System.out.println("Value of static type Of Class : " + sharedVariable);
    }
}
