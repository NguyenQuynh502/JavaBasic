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

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String number;
            while ((number = in.readLine()) != null) {
                System.out.println("Send: " + number);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
