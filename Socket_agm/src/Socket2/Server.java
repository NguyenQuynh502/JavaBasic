/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socket2;

/**                 BAI 1
 *
 * @author Nguyen Quynh
 */
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is running...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);

                Runnable clientHandler = new ClientHandler(clientSocket);
                executor.execute(clientHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            for (int i = 1; i <= 1000; i++) {
                out.println(i);
                Thread.sleep(1000); // Mỗi giây
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

