package com.example.ain_stroy;

public class CompanyMaterials {
    public String MaterialName;
    public int Amount;
    public int Price;
    public String Unit;
    public String Suppliername;

    public CompanyMaterials(String materialName, int amount, int price, String unit, String suppliername) {
        MaterialName = materialName;
        Amount = amount;
        Price = price;
        Unit = unit;
        Suppliername = suppliername;
    }

    public String getMaterialName() {
        return MaterialName;
    }

    public void setMaterialName(String materialName) {
        MaterialName = materialName;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String getSuppliername() {
        return Suppliername;
    }

    public void setSuppliername(String suppliername) {
        Suppliername = suppliername;
    }
}
