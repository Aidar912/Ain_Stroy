package com.example.ain_stroy;

public class StatusMaterials {
    public int Id;
    public String SupplierName;
    public String MaterialsName;
    public int Amount;
    public int Price;
    public String Unit;
    public String Status;

    public StatusMaterials(int id, String supplierName, String materialsName, int amount, int price, String unit, String status) {
        Id = id;
        SupplierName = supplierName;
        MaterialsName = materialsName;
        Amount = amount;
        Price = price;
        Unit = unit;
        Status = status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public String getMaterialsName() {
        return MaterialsName;
    }

    public void setMaterialsName(String materialsName) {
        MaterialsName = materialsName;
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}