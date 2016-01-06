package edu.team8.classes;


/**
 * Created by 知昊 on 2016/1/6.
 */
public class Good {
    protected String barcode;
    protected String name;
    protected String unit;
    protected double price;

    public Good(String barcode, String name, String unit, double price) {
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public String getBarcode()
    {
        return this.barcode;
    }
    public String getName()
    {
        return this.name;
    }
    public String getUnit()
    {
        return this.unit;
    }
    public double getPrice()
    {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public void setBarcode(String barcode) {

        this.barcode = barcode;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }


}
