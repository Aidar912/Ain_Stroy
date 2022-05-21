package com.example.ain_stroy;

public class Apartments {
    public String ProjectsName;
    public int LuxApartments;
    public int BusApartments;
    public int EcoApartments;
    public int LuxPrice;
    public int BusPrice;
    public int EcoPrice;
    public int Profit;
    public int SoldApartments;
    public String Status;

    public Apartments(String projectsName, int luxApartments, int busApartments,
                            int ecoApartments, int luxPrice, int busPrice, int ecoPrice,
                            int profit, int soldApartments, String status) {
        ProjectsName = projectsName;
        LuxApartments = luxApartments;
        BusApartments = busApartments;
        EcoApartments = ecoApartments;
        LuxPrice = luxPrice;
        BusPrice = busPrice;
        EcoPrice = ecoPrice;
        Profit = profit;
        SoldApartments = soldApartments;
        Status = status;
    }

    public String getProjectsName() {
        return ProjectsName;
    }

    public void setProjectsName(String projectsName) {
        ProjectsName = projectsName;
    }

    public int getLuxApartments() {
        return LuxApartments;
    }

    public void setLuxApartments(int luxApartments) {
        LuxApartments = luxApartments;
    }

    public int getBusApartments() {
        return BusApartments;
    }

    public void setBusApartments(int busApartments) {
        BusApartments = busApartments;
    }

    public int getEcoApartments() {
        return EcoApartments;
    }

    public void setEcoApartments(int ecoApartments) {
        EcoApartments = ecoApartments;
    }

    public int getLuxPrice() {
        return LuxPrice;
    }

    public void setLuxPrice(int luxPrice) {
        LuxPrice = luxPrice;
    }

    public int getBusPrice() {
        return BusPrice;
    }

    public void setBusPrice(int busPrice) {
        BusPrice = busPrice;
    }

    public int getEcoPrice() {
        return EcoPrice;
    }

    public void setEcoPrice(int ecoPrice) {
        EcoPrice = ecoPrice;
    }

    public int getProfit() {
        return Profit;
    }

    public void setProfit(int profit) {
        Profit = profit;
    }

    public int getSoldApartments() {
        return SoldApartments;
    }

    public void setSoldApartments(int soldApartments) {
        SoldApartments = soldApartments;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
