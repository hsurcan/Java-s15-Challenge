package com.library.entity;

import java.time.LocalDate;

public class Faculty extends Member{
    private final String facultyId;
    private String department;

    public Faculty(long id, String firstName, String lastName, LocalDate dateOfMembership, Contact contact, Address address, String facultyId, String department) {
        super(id, firstName, lastName, dateOfMembership, contact, address);
        this.facultyId = facultyId;
        this.department = department;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public String getDepartment() {
        return department;
    }

    public void changeDepartment(String department) {
        this.department = department;
    }

    @Override
    public int getBookLimit() {
        return 10;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Faculty{" +
                "id=" + getId() +
                ", fullName='" + getFullName() + '\'' +
                "facultyId='" + facultyId + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
