package org.example.hw21.task3;

import lombok.extern.java.Log;

public class Main {
    public static void main(String[] args) {
        LoggerFactory loggerFactory = new FileLoggerFactory();
        Logger logger = loggerFactory.createLogger();
        logger.logMessage("some text");
    }
}
