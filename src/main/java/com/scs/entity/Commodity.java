package com.scs.entity;

import java.util.Vector;

public class Commodity {
    private String Co_Name, Co_Price, Co_InPrice, Co_BarCode, Co_Date, Shelf_Life;
    private int Co_Surplus;

    public void setCo_Name(String Co_Name) {
        this.Co_Name = Co_Name;
    }

    public void setCo_Price(String Co_Price) {
        this.Co_Price = Co_Price;
    }

    public void setCo_InPrice(String Co_InPrice) {
        this.Co_InPrice = Co_InPrice;
    }

    public void setCo_BarCode(String Co_BarCode) {
        this.Co_BarCode = Co_BarCode;
    }

    public void setCo_Date(String Co_Date) {
        this.Co_Date = Co_Date;
    }

    public void setShelf_Life(String Shelf_Life) {
        this.Shelf_Life = Shelf_Life;
    }

    public void setCo_Surplus(int Co_Surplus) {
        this.Co_Surplus = Co_Surplus;
    }

    public String getCo_Name() {
        return this.Co_Name;
    }

    public String getCo_Price() {
        return this.Co_Price;
    }

    public String getCo_InPrice() {
        return this.Co_InPrice;
    }

    public String getCo_BarCode() {
        return this.Co_BarCode;
    }

    public String getCo_Date() {
        return this.Co_Date;
    }

    public String getShelf_Life() {
        return this.Shelf_Life;
    }

    public int getCo_Surplus() {
        return this.Co_Surplus;
    }

    public Vector<Object> getAllData() {
        Vector<Object> vo = new Vector<>();
        vo.add(this.Co_Name);
        vo.add(this.Co_Price);
        vo.add(this.Co_Date);
        vo.add(this.Co_BarCode);
        vo.add(this.Co_InPrice);
        vo.add(this.Co_Surplus);
        vo.add(this.Co_InPrice);
        return vo;
    }
}
