package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class Employee {
    int id;
    String fullname, gender, position, phoneNumber;
    int age;
    
    public Employee() {
    }

    public Employee(int id, String fullname, String gender, String position, String phoneNumber, int age) {
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public Employee(String fullname, String gender, String position, String phoneNumber, int age) {
        this.fullname = fullname;
        this.gender = gender;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
