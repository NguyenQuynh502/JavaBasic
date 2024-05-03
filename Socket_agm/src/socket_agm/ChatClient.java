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

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888); // Kết nối đến server

            // Tạo luồng đọc từ server
            Thread readThread = new Thread(new ReadThread(socket));
            readThread.start();

            // Tạo luồng ghi đến server
            Thread writeThread = new Thread(new WriteThread(socket));
            writeThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReadThread implements Runnable {
    private Socket socket;
    private BufferedReader in;

    public ReadThread(Socket socket) {
        try {
            this.socket = socket;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) { // Đọc tin nhắn từ server
                System.out.println(" Server: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class WriteThread implements Runnable {
    private Socket socket;
    private PrintWriter out;

    public WriteThread(Socket socket) {
        try {
            this.socket = socket;
            out = new PrintWriter(socket.getOutputStream(), true);
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
                out.println(message); // Gửi tin nhắn đến server
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
