package com.example.ain_stroy;

public class AllMaterials {
    public String MaterialsName;
    public String UOM;
    public Integer Quantity;
    public Integer Price;
    public String SupplierName;
    public String Description;

    public AllMaterials(String materialsName, String UOM, Integer quantity, Integer price, String supplierName, String description) {
        MaterialsName = materialsName;
        this.UOM = UOM;
        Quantity = quantity;
        Price = price;
        SupplierName = supplierName;
        Description = description;
    }

    public String getMaterialsName() {
        return MaterialsName;
    }

    public void setMaterialsName(String materialsName) {
        MaterialsName = materialsName;
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

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}