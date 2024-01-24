package org.example.hw24.part1;

import lombok.SneakyThrows;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.util.Scanner;

public class SockerServerRunner {
    @SneakyThrows
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(7777);
             var socket = serverSocket.accept();
             var dataOutputStream = new DataOutputStream(socket.getOutputStream());
             var dataInputStream = new DataInputStream(socket.getInputStream());
             var scanner = new Scanner(System.in)) {
            var request = dataInputStream.readUTF();
            while(!"q".equals(request)) {
                System.out.println("Client request : " + request);
                var response = scanner.nextLine();
                dataOutputStream.writeUTF(response);
                request = dataInputStream.readUTF();
            }
        }
    }
}
