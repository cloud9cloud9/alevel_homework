package org.example.hw23.task4;

import lombok.SneakyThrows;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue<Integer> blockingQueue;
    private final Object lock;

    public Consumer(BlockingQueue<Integer> blockingQueue, Object lock) {
        this.blockingQueue = blockingQueue;
        this.lock = lock;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (lock) {
            while (true) {
                while (blockingQueue.isEmpty()) {
                    lock.wait();
                }
                Integer poll = blockingQueue.poll();
                System.out.println("Concumer is take : " + poll);
                lock.notify();
                Thread.sleep(1000);
            }
        }
    }
}

