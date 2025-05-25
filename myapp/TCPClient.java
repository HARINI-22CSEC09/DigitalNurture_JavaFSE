package myapp;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        String userInput;
        while ((userInput = stdin.readLine()) != null) {
            out.println(userInput);
            System.out.println("Server: " + in.readLine());
        }

        socket.close();
    }
}

