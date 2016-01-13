package edu.team8.classes;

import java.util.ArrayList;

/**
 * Created by 知昊 on 2016/1/13.
 */
public class TicketInfo {
    ArrayList<GoodExtends> paidList;
    ArrayList<GoodExtends> savedList;
    double paidPrice;
    double savedPrice;
    int creditPoint;

    public TicketInfo(){
        this.paidList=null;
        this.savedList=null;
        this.paidPrice=0;
        this.savedPrice=0;
        this.creditPoint=0;
    }
    /**
     * 全参数构造函数
     * @param paidList
     * @param savedList
     * @param paidPrice
     * @param savedPrice
     * @param creditPoint
     */
    public TicketInfo(ArrayList<GoodExtends> paidList, ArrayList<GoodExtends> savedList,
                      double paidPrice, double savedPrice, int creditPoint) {
        this.paidList = paidList;
        this.savedList = savedList;
        this.paidPrice = paidPrice;
        this.savedPrice = savedPrice;
        this.creditPoint = creditPoint;
    }

    public ArrayList<GoodExtends> getPaidList() {
        return paidList;
    }

    public void setPaidList(ArrayList<GoodExtends> paidList) {
        this.paidList = paidList;
    }

    public ArrayList<GoodExtends> getSavedList() {
        return savedList;
    }

    public void setSavedList(ArrayList<GoodExtends> savedList) {
        this.savedList = savedList;
    }

    public double getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(double paidPrice) {
        this.paidPrice = paidPrice;
    }

    public double getSavedPrice() {
        return savedPrice;
    }

    public void setSavedPrice(double savedPrice) {
        this.savedPrice = savedPrice;
    }

    public int getCreditPoint() {
        return creditPoint;
    }

    public void setCreditPoint(int creditPoint) {
        this.creditPoint = creditPoint;
    }

    @Override
    public String toString() {
        return "TicketInfo{" +
                "paidList=" + paidList +
                ", savedList=" + savedList +
                ", paidPrice=" + paidPrice +
                ", savedPrice=" + savedPrice +
                ", creditPoint=" + creditPoint +
                '}';
    }
}
