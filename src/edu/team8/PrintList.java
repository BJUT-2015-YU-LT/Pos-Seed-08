package edu.team8;
import com.sun.org.apache.xpath.internal.operations.String;
import  edu.team8.classes.*;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by 魏来 on 2016/1/6.
 */
public interface PrintList {
    public static void PrintGoodList(ArrayList<GoodExtends> xiaoyu,BarcodeScanner bs){
        double sum = 0;                                                           //总价
        double save = 0;                                                              //节省
        int n=0;                                                                  //商品总数

        DecimalFormat df = new DecimalFormat("0.00");                              //保留两位小数格式
        bs.printReceipt("\t                     商店购物小票清单");                            //表头信息
        bs.printReceipt("==========================================================");
        bs.printReceipt("商品条码\t名称\t数量\t单价（元）\t小计（元）");
        for(GoodExtends ge:xiaoyu)
        {
            if(ge.getDiscount() <= 1) {             //原价或打折
                bs.printReceipt(ge.getBarcode() + "\t" + ge.getName() + "\t" + ge.getCount() + ge.getUnit() + "\t"
                        + df.format(ge.getPrice()) + "\t" + df.format(ge.getDiscount() * ge.getCount() * ge.getPrice()));  //打印信息

                sum += ge.getDiscount() * ge.getCount() * ge.getPrice();
                save += (1 - ge.getDiscount()) * ge.getCount() * ge.getPrice();                            //打折
                n += ge.getCount();                                                                     //计算商品总数
            }
            else if(ge.getDiscount() > 1){                                   //买赠 第二轮迭代
                if(ge.getCount()<=ge.getDiscount()){                        //商品本身买赠 但是购买数目不符合要求
                    bs.printReceipt(ge.getBarcode() + "\t" + ge.getName() + "\t" + ge.getCount() + ge.getUnit() + "\t"
                            + df.format(ge.getPrice()) + "\t" + df.format(ge.getCount() * ge.getPrice()));  //打印信息

                    sum += ge.getDiscount() * ge.getCount() * ge.getPrice();
                    n += ge.getCount();                                                                     //计算商品总数
                }
                else if
                bs.printReceipt(ge.getBarcode() + "\t" + ge.getName() + "\t" + ge.getCount() + ge.getUnit() + "\t"
                        + df.format(ge.getPrice()) + "\t" + df.format((ge.getDiscount())/(ge.getDiscount()+1) * ge.getCount() * ge.getPrice()));  //打印信息

                sum += (ge.getDiscount())/(ge.getDiscount()+1) * ge.getCount() * ge.getPrice();
                save += ge.getCount() * ge.getPrice()-sum;
                n += ge.getCount();                                                                  //计算商品总数
                /*bs.printReceipt("-------------------------------------------");
                bs.printReceipt("赠送商品：");
                bs.printReceipt("名称：" + ge.getName() + "数量：" + n );*/

            }
        }
        bs.printReceipt("-------------------------------------------");
        bs.printReceipt("总计：" + df.format(sum) + "（元）" + "  节省：" + df.format(save) + "（元）" +
                "  商品总数：" + n +"（件）");
        bs.printReceipt("**********************************************************************************");
    }
}
