package org.example.hw23.task2;

public class SyncExample {
    private Object lock = new Object();
    private static int counter = 0;

    public void increment() {
        synchronized (lock) {
            for (int i = 0; i < 1_000_000; i++) {
                counter++;
            }
        }
    }
    public int getCounter(){
        synchronized (lock){
            return counter;
        }
    }
}
