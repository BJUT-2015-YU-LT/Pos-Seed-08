package edu.team8.classes;


/**
 * Created by 知昊 on 2016/1/6.
 * Modified by 知昊 on 2016/1/7 for 需求2
 */
public class Good {
    protected String barcode;
    protected String name;
    protected String unit;
    protected double price;
    /**
     * 因需求 2 添加字段 discount
     */
    protected double discount;

    //构造函数
    public Good()
    {

    }
    public Good(Good g) {
        this.barcode = g.barcode;
        this.name = g.name;
        this.unit = g.unit;
        this.price = g.price;
    }
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
    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        /**
         * 因需求 2 添加字段,为测试所需, 故增加 [discount:]
         */
        return "Good{[barcode:"+barcode+"][name:"+name+"][unit:"+unit
                    +"][price:"+price+"][discount:"+discount+"]}";
    }
    public boolean equals(GoodExtends ge)
    {
        if(ge.getBarcode().equals(this.barcode))
            return true;
        return false;
    }
}
