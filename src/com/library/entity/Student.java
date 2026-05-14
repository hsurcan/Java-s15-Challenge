package com.library.entity;

import java.time.LocalDate;

public class Student extends Member{
    private final String studentNumber;
    private String department;

    public Student(long id, String firstName, String lastName, LocalDate dateOfMembership, Contact contact, Address address, String studentNumber, String department) {
        super(id, firstName, lastName, dateOfMembership, contact, address);
        this.studentNumber = studentNumber;
        this.department = department;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void changeDepartment(String department) {
        this.department = department;
    }

    @Override
    public int getBookLimit() {
        return 5;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Student{" +
                "id=" + getId() +
                ", fullName='" + getFullName() + '\'' +
                "studentNumber='" + studentNumber + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
