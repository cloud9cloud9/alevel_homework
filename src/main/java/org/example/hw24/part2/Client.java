package org.example.hw24.part2;

import lombok.SneakyThrows;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    @SneakyThrows
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 7777);
            var outputStream = new DataOutputStream(socket.getOutputStream());
            var inputStream = new DataInputStream(socket.getInputStream());
            var scanner = new Scanner(System.in)){
            while(scanner.hasNext()){
                var request = scanner.nextLine();
                outputStream.writeUTF(request);
                System.out.println("response from server : " + inputStream.readUTF());
            }
        }
    }
}
