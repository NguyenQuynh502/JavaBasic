/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iostream_agm;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Nguyen Quynh
 */
public class Lengtht {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String DataFile;
        System.out.println("Enter name: ");
        DataFile = sc.nextLine();
        File file = new File(DataFile);
        if (file.exists()) {
            double length = file.length();
            System.out.println("Lenght of file : " + length );
            
        } else { 
            System.out.println("error");
        }
        
    }
    
}
