package com.example.ain_stroy;

public class ResumeConstructor {
    public String Lastname;
    public String Firstname;
    public String Number;
    public String Position;
    public String Info;

    public ResumeConstructor(String lastname, String firstname, String number, String position, String info) {
        Lastname = lastname;
        Firstname = firstname;
        Number = number;
        Position = position;
        Info = info;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }
}

