package com.example.ain_stroy;

public class Revenues {
    int Apartments;
    int Projects;
    int Other;
    int Total;

    public Revenues(int apartments, int projects, int other, int total) {
        Apartments = apartments;
        Projects = projects;
        Other = other;
        Total = total;
    }

    public int getApartments() {
        return Apartments;
    }

    public void setApartments(int apartments) {
        Apartments = apartments;
    }

    public int getProjects() {
        return Projects;
    }

    public void setProjects(int projects) {
        Projects = projects;
    }

    public int getOther() {
        return Other;
    }

    public void setOther(int other) {
        Other = other;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }
}
