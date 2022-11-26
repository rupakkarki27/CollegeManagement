package com.collegemgmt;

import java.io.Serializable;

public class Student extends Person {
    private final int studentId;
    private String department;
    private String course;

    public Student(String name, String address, String dateOfBirth, int studentId, String department, String course) {
        super(name, address, dateOfBirth);
        this.studentId = studentId;
        this.department = department;
        this.course = course;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
