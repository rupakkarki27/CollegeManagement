package com.collegemgmt;

import java.io.Serializable;

public class Teacher extends Person implements Serializable {
    private final int teacherId;
    private String department;

    public Teacher(String name, String address, String dateOfBirth, int teacherId, String department) {
        super(name, address, dateOfBirth);
        this.teacherId = teacherId;
        this.department = department;
    }

    public int getTeacherId() {
        return this.teacherId;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment() {
        this.department = department;
    }

}
