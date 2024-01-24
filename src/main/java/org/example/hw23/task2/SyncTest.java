package org.example.hw23.task2;

public class SyncTest {
    public static void main(String[] args) {
        SyncExample syncExample = new SyncExample();
        syncExample.increment();
        System.out.println(syncExample.getCounter());
        SyncExample syncExample1 = new SyncExample();
        syncExample1.increment();
        System.out.println(syncExample.getCounter());
        System.out.println(syncExample1.getCounter());
    }
}
