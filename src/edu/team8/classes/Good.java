package edu.team8.classes;

import java.math.BigDecimal;

/**
 * Created by 知昊 on 2016/1/6.
 * Modified by 知昊 on 2016/1/7 for 需求2
 */
public class Good {
    public static final int NORMAL = 0;
    public static final int DISCOUNT = 1;
    public static final int PROMOTION = 2;

    protected String barcode;
    protected String name;
    protected String unit;
    protected double price;
    /**
     * 因需求 2 添加字段 discount
     * 因需求 5 添加字段 vipDiscount
     * 进而增加商品优惠类型 preferType 判别位;
     */
    protected double discount;
    protected double vipDiscount;
    protected int preferType;

    /**
     * 用于查找的构造函数
     * @param barcode
     */
    public Good(String barcode)
    {
        this.barcode = barcode;
    }

    /**
     * 用于复制的构造函数
     * @param g
     */
    public Good(Good g) {
        this.barcode = g.barcode;
        this.name = g.name;
        this.unit = g.unit;
        this.price = g.price;
        this.discount = g.discount;
        this.vipDiscount = g.vipDiscount;
        this.preferType = g.preferType;
        fixData();
    }

    /**
     * 用于单元测试的全参数构造函数
     * @param barcode
     * @param name
     * @param unit
     * @param price
     * @param discount
     * @param vipDiscount
     * @param preferType
     */
    public Good(String barcode, String name, String unit, double price,
                double discount,double vipDiscount,int preferType) {
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.discount = discount;
        this.vipDiscount = vipDiscount;
        this.preferType = preferType;
        fixData();
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
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getVipDiscount() {
        return vipDiscount;
    }

    public void setVipDiscount(double vipDiscount) {
        this.vipDiscount = vipDiscount;
    }

    public int getPreferType() {
        return preferType;
    }

    public void setPreferType(int preferType) {
        this.preferType = preferType;
    }

    /**
     * 修正部分可能损坏的数据
     */
    private void fixData()
    {
        if(this.discount<=0 || this.discount==1) {
            this.discount = 1;
            if(this.vipDiscount<=0 || this.vipDiscount==1) {
                this.preferType = NORMAL;
                this.vipDiscount = 1;
            }else if(this.vipDiscount<1){
                if(this.preferType != PROMOTION)
                this.preferType=DISCOUNT;
            }
        }else if(this.discount>2){
            this.preferType=PROMOTION;
            this.discount=new BigDecimal(discount).setScale(0,BigDecimal.ROUND_FLOOR).doubleValue();
        }
    }

    /**
     * 重载 toString 函数
     * @return
     */
    @Override
    public String toString() {
        return "Good{" +
                "barcode='" + barcode + '\'' +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", vipDiscount=" + vipDiscount +
                ", preferType=" + preferType +
                '}';
    }

    /**
     * 重载等与函数
     * @param ge
     * @return
     */
    @Override
    public boolean equals(Object ge)
    {
        if(ge instanceof GoodExtends)
            return ((GoodExtends) ge).getBarcode().equals(this.barcode);
        else if(ge instanceof Good)
            return ((Good) ge).getBarcode().equals(this.barcode);
        return false;
    }
}
