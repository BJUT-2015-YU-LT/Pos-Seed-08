package edu.team8;
import  edu.team8.classes.*;

import java.util.*;

/**
 * Created by wl on 2016/1/6.
 */
public class PrintList {
    public PrintList() {
    }
    public void PrintGoodList(){
        double sum=0;                          //总价
        System.out.println("***商店购物小票清单***");
        ArrayList<GoodExtends> xiaoyu=new ArrayList<GoodExtends>();
        for(GoodExtends ge:xiaoyu)
        {
            System.out.println("商品BarCode:   " + ge.getBarcode() + "   " + "名称:   " + ge.getName() + "   " +  //打印信息
                    "数量:   " + ge.getCount() + ge.getUnit() + ",   " + "单价:   " + ge.getPrice() + "   " + "小计:   " + ge.getCount()*ge.getPrice());
                  sum+=  ge.getCount()*ge.getPrice();
        }
        System.out.println("---------------");
        System.out.println("总计:" + sum);
        System.out.println("*******************");
    }

}
