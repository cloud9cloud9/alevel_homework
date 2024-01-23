package org.example.hw21.task3;

public class DatabaseLogger implements Logger{
    @Override
    public void logMessage(String message) {
        System.out.println("log is writes to database : " + message);
    }
}
