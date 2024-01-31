package org.example.hw23.task4;


public class Producer implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            try {
                SharedResources.queue.put(i);
                System.out.println("Producing: " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
