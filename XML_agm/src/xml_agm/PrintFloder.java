/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_agm;

import java.io.File;

/**
 *
 * @author Nguyen Quynh
 */
public class PrintFloder {
    public File file;
    public PrintFloder(String NameFile){
        this.file = new File(NameFile);
    }

    private PrintFloder() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   public void PrintFoder(){
      this.InChiTietCayThuMuc(this.file, 1);
   }

    private void InChiTietCayThuMuc(File file, int cay) {
           for (int i = 0; i < cay; i++) {
			System.out.print("  ");
        }
           if (file.canRead() && file.isDirectory()) {
			File[] mangCon = file.listFiles();
			System.out.println("<" + file.getName() + ">");
			for (File fx : mangCon) {
				InChiTietCayThuMuc(fx, cay + 1);
			}
			for (int i = 0; i < cay; i++) {
				System.out.print("\t");
			}
			System.out.println("</" + file.getName() + ">");
		}else {
			System.out.println("<file>" + file.getName() + "</file>" );
		}
		
	}
    public static void main(String[] args) {
		File f = new File("D:\\Assignment_Java");
		PrintFloder floder= new PrintFloder();
                floder.PrintFoder();
    }}

