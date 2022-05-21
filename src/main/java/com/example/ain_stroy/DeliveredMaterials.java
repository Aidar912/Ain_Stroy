package com.example.ain_stroy;

public class DeliveredMaterials {
    public String MaterialsName;
    public Integer Price;
    public String UOM;
    public Integer Quantity;
    public String SupplierName;
    public String Time;

    public DeliveredMaterials(String materialsName, Integer price, String UOM, Integer quantity, String supplierName, String time) {
        MaterialsName = materialsName;
        Price = price;
        this.UOM = UOM;
        Quantity = quantity;
        SupplierName = supplierName;
        Time = time;
    }

    public String getMaterialsName() {
        return MaterialsName;
    }

    public void setMaterialsName(String materialsName) {
        MaterialsName = materialsName;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public String getUOM() {
        return UOM;
    }

    public void setUOM(String UOM) {
        this.UOM = UOM;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}