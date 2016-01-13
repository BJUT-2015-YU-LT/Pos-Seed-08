package edu.team8.classes;

/**
 * Created by 知昊 on 2016/1/6.
 */
public class GoodExtends extends Good {
    //购物车中的商品数
    private int totalCount;
    //需要付费的商品数
    private int paidCount;

    /**
     * 用于从商品类继承属性的构造函数
     * @param g
     */
    public GoodExtends(Good g) {
        super(g);
        totalCount = 0;
        paidCount = 0;
    }

    /**
     * 复制构造函数
     * @param ge
     */
    public GoodExtends(GoodExtends ge){
        super(ge.barcode,ge.name,ge.unit,ge.price,ge.discount,ge.vipDiscount,ge.preferType);
        this.totalCount=ge.totalCount;
        this.paidCount=ge.paidCount;
    }

    /**
     * 全参数的测试构造函数
     * @param barcode
     * @param name
     * @param unit
     * @param price
     * @param discount
     * @param vipDiscount
     * @param preferType
     * @param totalCount
     * @param paidCount
     */
    public GoodExtends(String barcode, String name, String unit, double price ,
                       double discount ,double vipDiscount ,int preferType,
                       int totalCount ,int paidCount) {
        super(barcode, name, unit, price,discount,vipDiscount,preferType);
        this.totalCount = totalCount;
        this.paidCount = paidCount;
    }

    /**
     * 数量增加
     */
    public void countUp(){
        this.totalCount++;
        switch (this.preferType)
        {
            case Good.DISCOUNT:
                paidCount++;
                break;
            case Good.PROMOTION:
                if(totalCount%(discount+1)!=0)
                    paidCount++;
                break;
        }
    }

    /**
     * 数量减少
     */
    public void countDown()
    {
        if(this.totalCount==0)return;
        switch (this.preferType)
        {
            case Good.DISCOUNT:
                paidCount--;
                break;
            case Good.PROMOTION:
                if(totalCount%(discount+1)==0)
                    paidCount--;
                break;
        }
        this.totalCount--;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPaidCount() {
        return paidCount;
    }

    public void setPaidCount(int paidCount) {
        this.paidCount = paidCount;
    }

    /**
     * 重写 toString 函数
     * @return
     */
    @Override
    public String toString() {
        return "GoodExtends{" +
                "totalCount=" + totalCount +
                ", paidCount=" + paidCount +
                '}';
    }
}
