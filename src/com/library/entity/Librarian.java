package com.library.entity;

import com.library.util.PasswordUtil;

public class Librarian extends Person{
    private String password;

    public Librarian(long id, String firstName, String lastName, String password) {
        super(id, firstName, lastName);
        this.password = PasswordUtil.hashPassword(password);
    }

    public void changePassword(String newPassword){
        if(newPassword == null || newPassword.isBlank()){
            throw new IllegalArgumentException("Password cannot be blank");
        }
        this.password = PasswordUtil.hashPassword(newPassword);
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "id=" + getId() +
                ", fullName='" + getFullName() + '\'' +
                '}';
    }
}
