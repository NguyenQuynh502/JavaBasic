/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socket2.Bai2;

/**
 *
 * @author Nguyen Quynh
 */


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public  String ten;
    public static void main(String[] args) throws Exception {
        new Client();
    }

    public Client() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        ten = scanner.nextLine();
        Socket socket = new Socket("localhost", 8088);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        new Thread(() -> {
            while (true) {
                try {
                    String message = in.readLine();
                    if (message != null) {
                        System.out.println(message);
                    } else {
                        System.out.println("Server disconnected");
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        while (true) {
            String message = scanner.nextLine();
            out.writeBytes(ten+ ": " + message + "\n");
            out.flush();
        }
    }
    
}