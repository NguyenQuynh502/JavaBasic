/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iostream;

/**
 *
 * @author Nguyen Quynh
 */
public class Write_Read2 {
     private String name;
     private int age;
     private double max;
     public Write_Read2(){
         }

    public Write_Read2(String name, int age, double max) {
        this.name = name;
        this.age = age;
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMax() {
        return max;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMax(double max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return  "name=" + name + ", age=" + age + ", max=" + max ;
    }
     
     
     
     
}
