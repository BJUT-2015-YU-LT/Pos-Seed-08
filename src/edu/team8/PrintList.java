package edu.team8;
import  edu.team8.classes.*;

import java.util.*;

/**
 * Created by wl on 2016/1/6.
 */
public interface PrintList {
    public static void PrintGoodList(ArrayList<GoodExtends> xiaoyu){
        double sum=0;                          //总价
        System.out.println("\t\t\t\t商店购物小票清单");                                        //表头信息
        System.out.println("=========================================================");
        System.out.println("商品条码\t\t名称\t\t数量\t\t单价\t\t小计\t\t");
        for(GoodExtends ge:xiaoyu)
        {
            System.out.println(ge.getBarcode() + "\t\t" + ge.getName() + "\t\t" + ge.getCount() + ge.getUnit() + "\t\t\t"
                    + ge.getPrice() + "\t\t\t" + ge.getCount()*ge.getPrice());                //打印信息
                  sum+=  ge.getCount()*ge.getPrice();
        }
        System.out.println("---------------");
        System.out.println("总计:" + sum);
        System.out.println("*******************");
    }
}
