/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_agm;

/**
 *
 * @author Nguyen Quynh
 */
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class StudentXMLWriter {

    public static void main(String[] args) {
        // Tạo danh sách sinh viên
        List<Student> students = new ArrayList<>();
        students.add(new Student("Quynh", 20, 3.5));
        students.add(new Student("Huong", 22, 3.8));
        students.add(new Student("Duong", 21, 3.2));

        // Ghi danh sách sinh viên ra file XML
        try {
            writeStudentsToXML(students, "students.xml");
            System.out.println("Successfully wrote students to students.xml");
        } catch (Exception e) {
            System.err.println("Error writing students to XML: " + e.getMessage());
        }
    }

    public static void writeStudentsToXML(List<Student> students, String filePath) throws Exception {
        // Tạo một XMLStreamWriter để ghi XML
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(filePath));

        // Bắt đầu tài liệu XML
        writer.writeStartDocument("1.0");
        writer.writeCharacters("\n");

        // Bắt đầu phần tử gốc của danh sách sinh viên
        writer.writeStartElement("students");
        writer.writeCharacters("\n");

        // Viết thông tin cho mỗi sinh viên
        for (Student student : students) {
            writer.writeCharacters("  ");
            writer.writeStartElement("student");

            writer.writeStartElement("name");
            writer.writeCharacters(student.getName());
            writer.writeEndElement();

            writer.writeStartElement("age");
            writer.writeCharacters(String.valueOf(student.getAge()));
            writer.writeEndElement();

            writer.writeStartElement("gpa");
            writer.writeCharacters(String.valueOf(student.getGpa()));
            writer.writeEndElement();

            writer.writeEndElement();
            writer.writeCharacters("\n");
        }

        // Kết thúc phần tử gốc
        writer.writeEndElement();
        writer.writeCharacters("\n");

        // Kết thúc tài liệu XML
        writer.writeEndDocument();

        // Đóng XMLStreamWriter
        writer.close();
    }

    // Lớp Student đại diện cho thông tin của một sinh viên
    static class Student {
        private String name;
        private int age;
        private double gpa;

        public Student(String name, int age, double gpa) {
            this.name = name;
            this.age = age;
            this.gpa = gpa;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getGpa() {
            return gpa;
        }
    }
}
