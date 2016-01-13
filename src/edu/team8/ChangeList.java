package edu.team8;

import edu.team8.classes.Good;
import edu.team8.classes.GoodExtends;
import edu.team8.classes.TicketInfo;
import edu.team8.classes.Vip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 啸宇 on 2016/1/6.
 */
public interface ChangeList {

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
     * 第三轮迭代
     */
    public static TicketInfo account(ArrayList<GoodExtends> goodList,ArrayList<Vip> vipInfo)
    {/*(ArrayList<GoodExtends> paidList, ArrayList<GoodExtends> savedList,
                      double paidPrice, double savedPrice, int creditPoint)*/
        TicketInfo ticket = null;
        ArrayList<GoodExtends> paidList = new ArrayList<GoodExtends>();
        ArrayList<GoodExtends> savedList = new ArrayList<GoodExtends>();
        double paidPrice=0,savedPrice=0;
        int creditPoint=0;

        int i=0;
        for(GoodExtends good:goodList)
        {
            if(good.getPreferType()==Good.NORMAL)
            {
                paidList.get(i).setPrice(good.getPrice());
            }
            else if(good.getPreferType()==Good.DISCOUNT)
            {
                if(vipInfo==null)
                    paidList.get(i).setPrice(good.getPrice()*good.getDiscount());
                else
                    paidList.get(i).setPrice(good.getPrice()*good.getVipDiscount());
            }
            else if(good.getPreferType()==Good.PROMOTION)
            {

            }
            i++;
        }
        ticket.setPaidList(paidList);
        ticket.setSavedList(savedList);
        ticket.setPaidPrice(paidPrice);
        ticket.setSavedPrice(savedPrice);
        ticket.setCreditPoint(creditPoint);
        return ticket;
    }


}
