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
public interface ChangeList
{
    /**
     * 第三轮迭代,根据商品清单进行结算
     * @param goodList
     * @param vipInfo
     * @return
     */
    public static TicketInfo account(ArrayList<GoodExtends> goodList,Vip vipInfo)
    {
        TicketInfo ticket = new TicketInfo();
        ArrayList<GoodExtends> paidList = new ArrayList<GoodExtends>();
        ArrayList<GoodExtends> savedList = new ArrayList<GoodExtends>();
        double paidPrice=0,savedPrice=0;
        int creditPoint=0;

        for(GoodExtends good:goodList)
        {
            switch(good.getPreferType())
            {
                case Good.NORMAL:
                    break;
                case Good.DISCOUNT:
                    if(null!=vipInfo){
                        good.setPrice(good.getPrice()*good.getVipDiscount());
                    }else{
                        good.setPrice(good.getPrice()*good.getDiscount());
                    }
                    break;
                case Good.PROMOTION:
                    GoodExtends savedGood = new GoodExtends(good);
                    //计算节省的商品个数
                    savedGood.setTotalCount(savedGood.getTotalCount()-savedGood.getPaidCount());
                    savedList.add(savedGood);
                    break;
            }
            paidList.add(new GoodExtends(good));
        }
        ticket.setPaidList(paidList);
        ticket.setSavedList(savedList);
        ticket.setPaidPrice(paidPrice);
        ticket.setSavedPrice(savedPrice);
        ticket.setVipInfo(vipInfo);
        return ticket;
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
