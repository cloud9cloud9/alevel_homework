package org.example.hw23.task4;

import lombok.SneakyThrows;


public class Consumer implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        try {
            while (true) {
                Integer poll = SharedResources.queue.poll();
                if (poll != null) {
                    System.out.println("Consuming: " + poll);
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

