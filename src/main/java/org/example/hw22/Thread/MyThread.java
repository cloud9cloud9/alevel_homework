package org.example.hw22.Thread;

public class MyThread extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("Hello, A-Level");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
