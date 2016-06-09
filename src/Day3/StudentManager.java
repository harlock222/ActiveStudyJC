/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;
import java.util.ArrayList;
/**
 *
 * @author Harlock
 */
public class StudentManager {
   private static final ArrayList<Student> listStudent = new ArrayList<>() ;
    String path ="C:\\Users\\Harlock\\Documents\\NetBeansProjects\\ActiveStudyJC\\src\\Day3\\Day3.dat";
    public StudentManager() {
    }

    public  ArrayList<Student> getListStudent() throws ClassNotFoundException {
        return listStudent;
    }
   /*
   *
   */
   public boolean check(String id){
       for (Student student : listStudent) {
           if(student.getId().equals(id)){
               return false;
           }
       }
       return true;
   }
   public String getString(){
       String str = "";
       for( int i = 0;i<listStudent.size();i++){
           str+=listStudent.get(i).toString()+"\n";
       }
       return str;
   }
   public boolean addStudent(Student str) {
       if(check(str.getId())){
           listStudent.add(str);
           return true;
       }
       return false;
    }
   public boolean removeStudent(String id){
       for (Student student : listStudent) {
           if(check(id)){
            return false;
       }else{
            listStudent.remove(student);
            return true;
           }
       }
       return false;
   }
   public boolean editStudent(String id,String name,int age){
       for (Student student : listStudent) {
           if(!check(id)){
            student.setName(name);
            student.setAge(age);
            return true; 
           }
       }
       return false;
   }
}
