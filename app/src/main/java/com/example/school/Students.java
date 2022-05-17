package com.example.school;

public class Students {


    String firstName;
    String lastname;
    String telephone;

    public Students(String firstName, String lastname, String telephone) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.telephone = telephone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public String getTelephone() {
        return telephone;
    }
}
