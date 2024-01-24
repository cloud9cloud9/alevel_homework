package org.example.hw23.task4;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    private final BlockingQueue<Integer> blockingQueue;
    private final  Object lock;

    public Producer(BlockingQueue<Integer> blockingQueue, Object lock) {
        this.blockingQueue = blockingQueue;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                for (int i = 0; i < 1_000_000; i++) {
                    while (blockingQueue.size() == 5) {
                        lock.wait();
                    }
                    System.out.println("Producing: " + i);
                    blockingQueue.offer(i);
                    lock.notify();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
