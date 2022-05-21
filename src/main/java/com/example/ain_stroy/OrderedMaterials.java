package com.example.ain_stroy;

public class OrderedMaterials {
    public String MaterialsName;
    public Integer Quantity;
    public Integer Price;
    public String UOM;
    public String SupplierName;

    public OrderedMaterials(String materialsName, Integer quantity, Integer price, String UOM, String supplierName) {
        MaterialsName = materialsName;
        Quantity = quantity;
        Price = price;
        this.UOM = UOM;
        SupplierName = supplierName;
    }

    public String getMaterialsName() {
        return MaterialsName;
    }

    public void setMaterialsName(String materialsName) {
        MaterialsName = materialsName;
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

    public String getUOM() {
        return UOM;
    }

    public void setUOM(String UOM) {
        this.UOM = UOM;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }
}
