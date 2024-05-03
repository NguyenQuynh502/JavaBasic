/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iostream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Quynh
 */
public class Write_Read {
    public static void main(String[] args) {
//        //Write
//        String txt = "Nguyen Quynh";
//        // ghi mảng
//        String arr[] = {"Nguyen","Thi","Diem","Quynh"};
    Write_Read2 wr = new Write_Read2("Nguyen Quynh",19,9.5);
     Write_Read2 wr1 = new Write_Read2("Nguyen Quynh",19,9.0);
      Write_Read2 wr2 = new Write_Read2("Nguyen Quynh",19,10.0);
        List<Write_Read2> list = new ArrayList<>();
        list.add(wr);
        list.add(wr1);
        list.add(wr2);
        try {
           FileWriter fw = new FileWriter("data.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
//            for (String s : arr) {
//                bw.write(s);
//                //moi ten mot dong
//                bw.newLine();
//                
//            }
//               
//            
//            bw.write(wr.toString()); GHI MOT LOAT CU PHAP
                    
                
            for (Write_Read2 wRead : list) {
                bw.write(wRead.toString());
                bw.newLine();
                
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
        
    }
    
}
