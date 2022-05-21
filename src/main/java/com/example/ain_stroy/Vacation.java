package com.example.ain_stroy;

public class Vacation {
    public int IdVacation;
    public String NameUser;
    public String LastVacation;
    public int PaidVacation;
    public int VacationDays;
    public String Status;


    public int getIdVacation() {
        return IdVacation;
    }

    public void setIdVacation(int idVacation) {
        IdVacation = idVacation;
    }

    public Vacation(String nameUser, String lastVacation, int paidVacation, int vacationDays, String status) {

        NameUser = nameUser;
        LastVacation = lastVacation;
        PaidVacation = paidVacation;
        VacationDays = vacationDays;
        Status = status;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getVacationDays() {
        return VacationDays;
    }

    public void setVacationDays(int vacationDays) {
        VacationDays = vacationDays;
    }


    public String getNameUser() {
        return NameUser;
    }

    public void setNameUser(String nameUser) {
        NameUser = nameUser;
    }

    public String getLastVacation() {
        return LastVacation;
    }

    public void setLastVacation(String lastVacation) {
        LastVacation = lastVacation;
    }

    public int getPaidVacation() {
        return PaidVacation;
    }

    public void setPaidVacation(int paidVacation) {
        PaidVacation = paidVacation;
    }
}
