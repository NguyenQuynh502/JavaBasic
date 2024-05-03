/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socket_agm;

/**
 *                  BAI 1
 * @author Nguyen Quynh
 */
import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888); // Mở một server socket trên cổng 8888
            System.out.println("Server started. Waiting for clients...");

            Socket clientSocket = serverSocket.accept(); // Chấp nhận kết nối từ client
            System.out.println("Client connected: " + clientSocket);

            // Tạo luồng đọc từ client
            Thread readThread = new Thread(new ReadThread(clientSocket));
            readThread.start();

            // Tạo luồng ghi đến client
            Thread writeThread = new Thread(new WriteThread(clientSocket));
            writeThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReadThread implements Runnable {
    private Socket clientSocket;
    private BufferedReader in;

    public ReadThread(Socket socket) {
        try {
            clientSocket = socket;
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) { // Đọc tin nhắn từ client
                System.out.println("Client: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class WriteThread implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;

    public WriteThread(Socket socket) {
        try {
            clientSocket = socket;
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String message;
            while (true) {
                System.out.print(": ");
                message = userInput.readLine();
                out.println(message); // Gửi tin nhắn đến client
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
