/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;

import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Harlock
 */
public class MainBai1 {
   
    public static void main(String[] args) throws ClassNotFoundException {
        StudentDataAccess sda = new StudentDataAccess();
        StudentManager sm = new StudentManager();
        MainBai1 m = new MainBai1();
        Scanner sc = new Scanner(System.in,"UTF-8");
        int roll = 0;
        String id,name;
        int age;
        String pathDat ="C:\\Users\\Harlock\\Documents\\NetBeansProjects\\ActiveStudyJC\\src\\Day3\\Day3.dat";
        String pathTxt ="C:\\Users\\Harlock\\Documents\\NetBeansProjects\\ActiveStudyJC\\src\\Day3\\Day3.txt"; 
    try {
        do { 
//            
//            if(list!=null){
//                for (Student student : list) {
//                sm.addStudent(student);
//                } 
//            }
               
                m.Menu();
                roll=sc.nextInt();
                switch(roll){
                case 1:
                m.MenuStudent();
                int a=0;
                    do {
                        a=sc.nextInt();
                        switch(a){
                            
                            case 1:
                                
                                System.out.println("Nhap id :");
                                id=sc.next();
                                System.out.println("Nhap Name :");
                                name=sc.next();
                                System.out.println("Nhap tuoi :");
                                age=sc.nextInt();
                                Student st = new Student(id,name,age);
                                if(sm.addStudent(st)){
                                    System.out.println("Them thanh cong !");
                                } else {
                                    System.out.println("Them that bai !");
                                }
                                break;
                            case 2:
                                System.out.println("Nhap id can sua :");
                                id=sc.next();
                                if(sm.check(id)==false){
                                    System.out.println("Nhap Name :");
                                    name=sc.next();
                                    System.out.println("Nhap tuoi :");
                                    age=sc.nextInt();
                                    if(sm.editStudent(id, name, age)){
                                       System.out.println("Sua thanh cong !");
                                    }else{
                                    System.out.println("Sua khong thanh cong !"); 
                                    }  
                                }else{
                                   System.out.println("Khong tim thay Student !"); 
                                    }  
                                break;
                            case 3:
                                System.out.println("Nhap id can xoa :");
                                id=sc.next();
                                if(sm.removeStudent(id)){
                                   System.out.println("Xoa thanh cong !");
                                }
                                else{
                                    System.out.println("Xoa that bai !");
                                }
                               
                                break;
                            case 4:
                                System.out.println(sm.getString());
                                break;
                            case 5:
                                m.Menu();
                                break;
                        }
                        
                    } while (a!=0);
                break;
                case 2:
                sda.writeToBinaryFile(sm.getListStudent());
                break;
                case 4:
                List<Student> list= sda.readToBinaryFile(pathDat);
                if(list==null){
                    System.out.println(" Emty");
                }else{
                    for (Student student : list) {
                        System.out.println(student.toString());
                    }
                }
                break;
                case 3:
                sda.writeTextFile(sm.getListStudent());
                break;
                case 5:
                List<Student> listText= StudentDataAccess.readToTextFile(pathTxt);
                if(listText==null){
                    System.out.println(" Emty");
                }else{
                    for (Student student : listText) {
                        System.out.println(student.toString());
                    }
                }
                break;
            }
            
            
        } while (roll!=0);
    } catch (Exception e) {
                System.out.println(e.toString());
    } 
}
    public void Menu(){
        System.out.println("-----------------");
        System.out.println("-------Menu--------");
        System.out.println("1:Them Student");
        System.out.println("2:Ghi File Binary");
        System.out.println("3:Ghi File Text");
        System.out.println("4:Doc File Binary");
        System.out.println("5:Doc File Text");
        System.out.println("0:Thoat");
    }
     public void MenuStudent(){
        System.out.println("-----------------");
        System.out.println("-------Menu--------");
        System.out.println("1:Them ");
        System.out.println("2:Sua ");
        System.out.println("3:Xoa");
        System.out.println("4:Hien thi tat ca ");
        System.out.println("5:Quay lai Menu");
    }
   
}
