/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stiw3054_assignment.quiz1xcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author abdullah
 */
public class ReadFromExcelFile {
    private String file_path;
    StudentList studentList;
    FileInputStream fis = null;
    Workbook workbook;
    int numberOfSheets;
    Sheet sheet;

    public ReadFromExcelFile(String file_path) throws IOException {
       this.file_path= file_path; 
       studentList = new StudentList();
       fis = new FileInputStream(file_path);
       workbook = new XSSFWorkbook(fis);
    }
    public ReadFromExcelFile() throws IOException {
        file_path = "/Users/abdullah/Documents/name.xlsx";
        studentList = new StudentList();
        fis = new FileInputStream(file_path);
        workbook = new XSSFWorkbook(fis);
    }
    public void setNumOfSheet(){
      numberOfSheets  = workbook.getNumberOfSheets();
     }
    public void setSheet(int i){
       
       sheet = workbook.getSheetAt(i);
     }
    public StudentList getlist(){
     return studentList;
    } 
    public void createList() throws IOException{
                    
                    setNumOfSheet();
                    
            for (int i = 0; i < numberOfSheets; i++) {
                 setSheet(i);
                 Student student;
                 Row row;
                 Iterator cellIterator;
                 String matric;
                 long value;
                 Iterator rowIterator = sheet.iterator();
                
                while (rowIterator.hasNext()) {
                student = new Student();
                row = (Row) rowIterator.next();
                cellIterator = row.cellIterator();
                      while (cellIterator.hasNext()) {
                            Cell cell = (Cell)cellIterator.next();
                         if ((Cell.CELL_TYPE_STRING == cell.getCellType())||(cell.CELL_TYPE_NUMERIC == cell. getCellType())){
                              if (cell.getColumnIndex() == 0) {
                                if (cell.CELL_TYPE_NUMERIC == cell. getCellType()){
//                               matric = String.valueOf(cell.getNumericCellValue()+"");
//                               value = Integer.parseInt(matric);
//                               student.setMatric(value+"");
                                 student.setMatric(String.valueOf(cell.getNumericCellValue()+""));
                                }
                                else
                                 student.setMatric(String.valueOf(cell.getRichStringCellValue()+""));

                            }

                            //Cell with index 1 contains name

                            else if (cell.getColumnIndex() == 1) {

                                student.setName(String.valueOf(cell.getRichStringCellValue()));

                            }

                            //Cell with index 2 contains email

                            else if (cell.getColumnIndex() == 2) {

                                student.setEmail(String.valueOf(cell.getRichStringCellValue()));

                            }

                        }

                    }
                    //end iterating a row, add all the elements of a row in list

                    studentList.setStudent(student);
                }
            fis.close();
        } 
        

}
}