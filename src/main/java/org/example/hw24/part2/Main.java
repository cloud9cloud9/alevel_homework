package org.example.hw24.part2;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(7777, 5);
        server.run();
    }
}
