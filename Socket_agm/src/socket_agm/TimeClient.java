/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socket_agm;

/**
 *
 * @author Nguyen Quynh
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TimeClient  {
	public static void main(String[] args) {
		int port = 99;
		try {
			Socket socket = new Socket("localhost" , port);
			// doc du lieu tu socket
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			// ghi du lieu tu socket
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			Scanner sc = new Scanner(System.in);
			String message ;
			while(true) {
				// gui tin nhan
				message = "time";
				writer.println(message);
				writer.flush();
				System.out.println(message);
				Thread.sleep(1000);
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ket noi khong thanh cong");
			e.printStackTrace();
		}
	}

}