/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stiw3054_assignment.quiz1xcel;

import java.io.IOException;

/**
 *
 * @author abdullah
 */
public class DriverClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException  {
        // TODO code application logic here
        ReadFromExcelFile names = new ReadFromExcelFile (); 
        names.createList();
        StudentList studnames = new StudentList();
        studnames = names.getlist();
        printNames(studnames);
        
    }
    public static void printNames (StudentList s){
          Student stud;
          for (int i=1; i<s.getSize(); i++){
            stud = s.getStudent(i);
            stud.toString();
          }
    
    
    }
    
}
