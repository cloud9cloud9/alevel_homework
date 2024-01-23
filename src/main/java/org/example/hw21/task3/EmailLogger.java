package org.example.hw21.task3;

public class EmailLogger implements Logger{
    @Override
    public void logMessage(String message) {
        System.out.println("log is writes to email : " + message);
    }
}
