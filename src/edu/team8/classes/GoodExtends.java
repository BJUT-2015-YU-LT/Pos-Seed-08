package edu.team8.classes;

/**
 * Created by 知昊 on 2016/1/6.
 */
public class GoodExtends extends Good {
    private int count;                             //商品数

    public GoodExtends(String barcode, String name, String unit, float price , int count) {
        super(barcode, name, unit, price);
        this.count = count;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
