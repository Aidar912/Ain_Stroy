package com.example.ain_stroy;

public class SoldApartments {

    public String ProjectsName;
    public int LuxApartments;
    public int BusApartments;
    public int EcoApartments;

    public SoldApartments(String projectsName, int luxApartments, int busApartments, int ecoApartments) {
        ProjectsName = projectsName;
        LuxApartments = luxApartments;
        BusApartments = busApartments;
        EcoApartments = ecoApartments;
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
}
