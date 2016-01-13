package edu.team8.classes;

/**
 * Created by 知昊 on 2016/1/13. 16:15
 */
public class Vip {
    private String vipCode;
    private int vipCredit;

    public Vip(String vipCode, int vipCredit) {
        this.vipCode = vipCode;
        this.vipCredit = vipCredit;
    }

    public String getVipCode() {
        return vipCode;
    }

    public void setVipCode(String vipCode) {
        this.vipCode = vipCode;
    }

    public int getVipCredit() {
        return vipCredit;
    }

    public void setVipCredit(int vipCredit) {
        this.vipCredit = vipCredit;
    }

    @Override
    public String toString() {
        return "Vip{" +
                "vipCode='" + vipCode + '\'' +
                ", vipCredit=" + vipCredit +
                '}';
    }
}
