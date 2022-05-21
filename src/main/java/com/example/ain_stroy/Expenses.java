package com.example.ain_stroy;

public class Expenses {
    int Salary;
    int Material;
    int Other;
    int Total;

    public Expenses(int salary, int material, int other, int total) {
        Salary = salary;
        Material = material;
        Other = other;
        Total = total;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public int getMaterial() {
        return Material;
    }

    public void setMaterial(int material) {
        Material = material;
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
