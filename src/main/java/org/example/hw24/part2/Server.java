package org.example.hw24.part2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final ExecutorService pool;
    private final int port;
    private boolean stopped;
    private final Set<Socket> activeClients;

    public Server(int port, int poolSize) {
        this.port = port;
        this.pool = Executors.newFixedThreadPool(poolSize);
        this.activeClients = new HashSet<>();
    }

    public void run() {
        try {
            var server = new ServerSocket(port);
            while (!stopped) {
                var socket = server.accept();
                System.out.println("socket accepted");
                activeClients.add(socket);
                pool.submit(() -> proseccSocket(socket));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void proseccSocket(Socket socket) {
        try (var dataOutputStream = new DataOutputStream(socket.getOutputStream());
             var dataInputStream = new DataInputStream(socket.getInputStream());
             var scanner = new Scanner(System.in)) {
            var request = dataInputStream.readUTF();
            do {
                System.out.println("Client request : " + request);
                var response = scanner.nextLine();
                dataOutputStream.writeUTF(response);
                request = dataInputStream.readUTF();
                if ("q".equals(request)) {
                    stop();
                    break;
                }
            } while (!"q".equals(request));

        } catch (IOException ex) {
            activeClients.remove(socket);
            System.out.println("Client disconnected: " + socket.getInetAddress());
            throw new RuntimeException(ex);
        }
    }

    public void stop() {
        System.out.println("Server stopping...");
        stopped = true;
        for (Socket client : activeClients) {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        pool.shutdownNow();
    }
}
