/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socket_agm;

/**
 *
 * @author Nguyen Quynh
 */
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test extends JFrame implements Runnable
{
	private Socket socket;
	private JLabel lable;
	private JPanel pn;

	public Test(Socket socket) {
		this.socket = socket;
	}
	public Test(){
		this.setTitle("MyProcess");
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		pn = new JPanel();
		pn.setLayout(new BorderLayout());
		lable = new JLabel("kim huong");
		pn.add(lable, BorderLayout.CENTER);
		this.add(pn);
		this.setVisible(true);
	}


	@Override
	public void run() {
			try {
				// doc du lieu tu socket
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				// ghi du lieu tu socket
				PrintWriter writer = new PrintWriter(socket.getOutputStream());
				Scanner sc = new Scanner(System.in);
			while(true) {
					// nhan tin nhan
					String message ;
					message= reader.readLine();
				//	System.out.println("Ghi: " + message );
					System.out.println(java.time.LocalTime.now());
					
					lable.setText(java.time.LocalTime.now()+"");
					
			     	
			     
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

