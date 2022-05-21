package com.example.ain_stroy;

public class User {
    private String firstname;
    private String lastname;
    private String user_login;
    private String user_password;
    private String type_account;
    private int salary;
    private String email;

    public User(String firstname, String lastname, String user_login, String user_password, String type_account, int salary, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.user_login = user_login;
        this.user_password = user_password;
        this.type_account = type_account;
        this.salary = salary;
        this.email = email;
    }

    public User() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getType_account() {
        return type_account;
    }

    public void setType_account(String type_account) {
        this.type_account = type_account;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}