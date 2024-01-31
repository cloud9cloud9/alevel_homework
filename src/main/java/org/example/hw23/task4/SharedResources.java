package org.example.hw23.task4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


class SharedResources {
    static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);
}
