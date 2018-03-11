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
public class Student {
    private String matric;
    private String name;
    private String email;
    
    public Student(){}

    public Student(String matric, String name, String email) {
        this.matric= matric;
        this.name = name;
        this.email = email;

    }

    public String getMatric() {
        return matric;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setMatric(String matric) {
        this.matric = matric;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String toString() {
        return "Matric : " + matric + "\n Name : " + name + "\nE-mail : " + email + "\n\n";
     
    }

}
