package org.example.hw23.task4;

import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);
        Object lock = new Object();
        Thread producer = new Thread(new Producer(blockingQueue, lock));
        Thread consumer = new Thread(new Consumer(blockingQueue, lock));
        producer.start();
        consumer.start();
    }
}
