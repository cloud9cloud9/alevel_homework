package org.example.hw22.Thread;

import org.example.hw22.Thread.MyThread;
import org.example.hw22.ThreadPartTwo.SomeThread;

public class Main {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();

        Thread runnableThread = new Thread(() -> {
            while(true){
                System.out.println("Hello, A-Level2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        runnableThread.start();

    }
}
