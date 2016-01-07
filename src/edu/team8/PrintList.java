package edu.team8;
import  edu.team8.classes.*;

import java.util.*;

/**
 * Created by wl on 2016/1/6.
 */
public interface PrintList {
    public static void PrintGoodList(ArrayList<GoodExtends> xiaoyu,BarcodeScanner bs){
        double sum=0;                          //总价
        bs.printReceipt("\t                     商店购物小票清单");                            //表头信息
        bs.printReceipt("=======================================================");
        bs.printReceipt("商品条码\t名称\t数量\t单价\t小计\t");
        for(GoodExtends ge:xiaoyu)
        {
            bs.printReceipt(ge.getBarcode() + "\t" + ge.getName() + "\t" + ge.getCount() + ge.getUnit() + "\t"
                    + ge.getPrice() + "\t" + ge.getCount()*ge.getPrice());                //打印信息
                  sum+=  ge.getCount()*ge.getPrice();
        }
        bs.printReceipt("------------------------------");
        bs.printReceipt("总计:" + sum);
        bs.printReceipt("*****************************************************************************");
    }
}
