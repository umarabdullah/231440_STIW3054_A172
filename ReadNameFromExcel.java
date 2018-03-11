/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stiw3054_assignment.quiz1xcel;

/**
 *
 * @author abdullah
 */
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ReadNameFromExcel {

 

   static final String FILE_PATH = "/Users/abdullah/Documents/name.xlsx";
    public static void main(String args[]) {
 
       List studentList1 = getStudentsListFromExcel();
        System.out.println(studentList1);
        
    }
 
    private static List getStudentsListFromExcel() {
//    private static void getStudentsListFromExcel() {
        List studentList = new ArrayList();
        FileInputStream fis = null;
        try {

            fis = new FileInputStream(FILE_PATH);

         // Using XSSF for xlsx format, for xls use HSSF

            Workbook workbook = new XSSFWorkbook(fis);
            int numberOfSheets = workbook.getNumberOfSheets();
 
     //looping over each workbook sheet

     
            for (int i = 0; i < numberOfSheets; i++) {

                Sheet sheet = workbook.getSheetAt(i);

                Iterator rowIterator = sheet.iterator();
//                Row r =  sheet.getRow(0);
//                 Cell c = r.getCell(0);
//                 String test = c.getStringCellValue();
//                 System.out.println(test +"");
 

                //iterating over each row
                 Student student;
                 Row row;
                 Iterator cellIterator;
                 String matric;
                 long value;

                while (rowIterator.hasNext()) {

                     student = new Student();

                     row = (Row) rowIterator.next();

                     cellIterator = row.cellIterator();

 


                    while (cellIterator.hasNext()) {

 

                        Cell cell = (Cell)cellIterator.next();

                        

     if ((Cell.CELL_TYPE_STRING == cell.getCellType())||(cell.CELL_TYPE_NUMERIC == cell. getCellType())){

 

                            //Cell with index 1 contains marks in Maths

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

                            //Cell with index 2 contains marks in Science

                            else if (cell.getColumnIndex() == 1) {

                                student.setName(String.valueOf(cell.getRichStringCellValue()));

                            }

                            //Cell with index 3 contains marks in English

                            else if (cell.getColumnIndex() == 2) {

                                student.setEmail(String.valueOf(cell.getRichStringCellValue()));

                            }

                        }

                    }
                    //end iterating a row, add all the elements of a row in list

                    studentList.add(student);

                }
          }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
