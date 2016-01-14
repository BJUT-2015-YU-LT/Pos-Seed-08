package edu.team8.classes;

import java.util.ArrayList;

/**
 * Created by 知昊 on 2016/1/13.
 */
public class TicketInfo {
    private ArrayList<GoodExtends> paidList;
    private ArrayList<GoodExtends> savedList;
    private double paidPrice;
    private double savedPrice;
    private Vip vipInfo;

    public TicketInfo(){
        this.paidList=null;
        this.savedList=null;
        this.paidPrice=0;
        this.savedPrice=0;
        this.vipInfo=null;
    }

    /**
     * 全参数构造函数
     * @param paidList
     * @param savedList
     * @param paidPrice
     * @param savedPrice
     * @param vipInfo
     */
    public TicketInfo(ArrayList<GoodExtends> paidList, ArrayList<GoodExtends> savedList,
                      double paidPrice, double savedPrice, Vip vipInfo) {
        this.paidList = paidList;
        this.savedList = savedList;
        this.paidPrice = paidPrice;
        this.savedPrice = savedPrice;
        this.vipInfo = vipInfo;
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

    public Vip getVipInfo() {
        return vipInfo;
    }

    public void setVipInfo(Vip vipInfo) {
        this.vipInfo = vipInfo;
    }

    @Override
    public String toString() {
        return "TicketInfo{" +
                "paidList=" + paidList +
                ", savedList=" + savedList +
                ", paidPrice=" + paidPrice +
                ", savedPrice=" + savedPrice +
                ", vipInfo=" + vipInfo +
                '}';
    }
}
