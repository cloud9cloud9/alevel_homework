package org.example.hw21.task3;

public class EmailLoggerFactory implements LoggerFactory{
    @Override
    public Logger createLogger() {
        return new EmailLogger();
    }
}
