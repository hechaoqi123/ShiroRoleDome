package com.aaa.entity;



/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student  implements java.io.Serializable {


    // Fields    

     private Integer sid;
     private Classes classes;
     private String sname;


    // Constructors

    /** default constructor */
    public Student() {
    }

    
    /** full constructor */
    public Student(Classes classes, String sname) {
        this.classes = classes;
        this.sname = sname;
    }

   
    // Property accessors

    public Integer getSid() {
        return this.sid;
    }
    
    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Classes getClasses() {
        return this.classes;
    }
    
    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public String getSname() {
        return this.sname;
    }
    
    public void setSname(String sname) {
        this.sname = sname;
    }
   








}