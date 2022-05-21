package com.example.ain_stroy;

public class StockOfMaterials {
    public String MatName;
    public int Amount;
    public String Unit;

    public StockOfMaterials(String matName, int amount, String unit) {
        MatName = matName;
        Amount = amount;
        Unit = unit;
    }

    public String getMatName() {
        return MatName;
    }

    public void setMatName(String matName) {
        MatName = matName;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }
}
