package edu.team8;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import edu.team8.classes.Good;
import edu.team8.classes.GoodExtends;
import edu.team8.classes.TicketInfo;
import edu.team8.classes.Vip;

import java.io.SyncFailedException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 啸宇 on 2016/1/6.
 */
public class ChangeList
{
    /**
     * 第三轮迭代,根据商品清单进行结算
     * @param goodList
     * @param vipInfo
     * @return
     */
    public static TicketInfo account(ArrayList<GoodExtends> goodList,Vip vipInfo,GetInfoInSQL sqlVisitor)
    {
        TicketInfo ticket = new TicketInfo();
        ArrayList<GoodExtends> paidList = new ArrayList<GoodExtends>();
        ArrayList<GoodExtends> savedList = new ArrayList<GoodExtends>();
        double paidPrice=0,savedPrice=0;
        int creditPoint=0;

        for(GoodExtends oldGood:goodList)
        {
            GoodExtends good = new GoodExtends(oldGood);
            switch(good.getPreferType())
            {
                case Good.NORMAL:
                    break;
                case Good.DISCOUNT:
                    if(null!=vipInfo){
                        savedPrice+=good.getPrice()*(1-good.getDiscount()*good.getVipDiscount());
                        good.setPrice(good.getPrice()*good.getDiscount()*good.getVipDiscount());
                    }else{
                        savedPrice+=good.getPrice()*(1-good.getDiscount());
                        good.setPrice(good.getPrice()*good.getDiscount());
                    }
                    break;
                case Good.PROMOTION:
                    int decide = good.getTotalCount()-good.getPaidCount();
                    if(decide>0) {
                        GoodExtends savedGood = new GoodExtends(good);
                        //计算节省的商品个数
                        savedGood.setTotalCount(decide);
                        savedPrice += savedGood.getTotalCount() * savedGood.getPrice();
                        savedList.add(savedGood);
                    }
                    break;
            }
            paidList.add(new GoodExtends(oldGood));
            paidPrice+=good.getPrice()*good.getPaidCount();
        }
        paidPrice=new BigDecimal(paidPrice).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue();
        savedPrice=new BigDecimal(savedPrice).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue();
        if(vipInfo != null){
            sqlVisitor.addVipCredit(getCredit(paidPrice,vipInfo.getVipCredit()),vipInfo.getVipCode());
            vipInfo = sqlVisitor.findVipByCode(vipInfo.getVipCode());
        }

        ticket.setPaidList(paidList);
        ticket.setSavedList(savedList);
        ticket.setPaidPrice(paidPrice);
        ticket.setSavedPrice(savedPrice);
        ticket.setVipInfo(vipInfo);
        return ticket;
    }

    private static int getCredit(double paid,int oldCredit){
        int credit = 0;
        if(paid>0){
            if (oldCredit<=200){
                credit = (int) Math.floor(paid/5)*1;
            }else if(oldCredit<=500){
                credit = (int) Math.floor(paid/5)*3;
            }else{
                credit = (int) Math.floor(paid/5)*5;
            }
        }
        return credit;
    }

    /**
     * 第二轮迭代
     * 根据商品列表和索引文件生成购物清单
     * @param itemList
     * @param barcodeList
     * @return
     */
    public static ArrayList<GoodExtends> ConvertList(ArrayList<Good> itemList,ArrayList<String> barcodeList)
    {
        ArrayList<GoodExtends> list1 = new ArrayList<GoodExtends>();
        for (Good good:itemList)
            list1.add(new GoodExtends(good));
        int i=-1;
        for (String s:barcodeList)
        {
            Good tempGood = new Good(s);
            if((i=itemList.indexOf(tempGood))>=0)
            {
                list1.get(i).countUp();
            }
        }
        for (i=0;i<list1.size();i++)
        {
            if(list1.get(i).getTotalCount()==0)
                list1.remove(i);
        }
        return list1;
    }

    /**
     *  第一轮迭代
     * @param list
     * @return
     */
    public static ArrayList<GoodExtends> processChangeList(ArrayList<Good> list)
    {
        ArrayList<GoodExtends> list1 = new ArrayList<GoodExtends>();
        int i=-1;
        for (Good g:list)
        {
            if((i=list1.indexOf(g))>=0)
            {
                list1.get(i).countUp();
            }
            else
            {
                list1.add(new GoodExtends(g));
                i=list1.indexOf(g);
                list1.get(i).countUp();
            }
        }
        return list1;
    }
}
