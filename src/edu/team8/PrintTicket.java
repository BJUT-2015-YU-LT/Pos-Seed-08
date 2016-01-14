package edu.team8;

import edu.team8.classes.GoodExtends;
import edu.team8.classes.TicketInfo;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by 魏来 on 2016/1/13.
 */
public interface PrintTicket {
    public static void PrintTicketList(TicketInfo ti,PosGUI bs){
        int n = 0;
        Date d = new Date();                                                        //打印时间
        DecimalFormat df = new DecimalFormat("0.00");                              //保留两位小数格式
        DateFormat dft = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss ", Locale.CHINA);       // 时间格式

        bs.printReceipt("\t                商店购物小票清单");                            //表头信息
        bs.printReceipt("\t\t         打印时间：" + dft.format(d));                              //打印时间
        bs.printReceipt("=======================================================");
        bs.printReceipt("商品条码\t      名称\t 数量\t    单价(元)\t 小计(元)");
        for(GoodExtends ge:ti.getPaidList()) {
                bs.printReceipt(ge.getBarcode() + "      " + ge.getName() + "\t " + ge.getTotalCount() + ge.getUnit() + "\t    "
                        + df.format(ge.getPrice()) + "\t " + df.format(ge.getPaidCount() * ge.getPrice()));  //打印信息
                n += ge.getTotalCount();                                                      //计算商品总数
        }
        if(ti.getSavedList() !=null){                                                           //有赠送商品时才打印相关赠送信息
            bs.printReceipt("-------------------------------------------------------");                 //打印赠送商品
            bs.printReceipt("赠送商品：");
            for(GoodExtends ge:ti.getSavedList()) {
                bs.printReceipt("名称：" + ge.getName() + "    数量：" + (ge.getTotalCount()-ge.getPaidCount()));  //打印信息
                n += ge.getTotalCount();                                                      //计算商品总数
            }
        }

        bs.printReceipt("-------------------------------------------------------");                    //打印表尾
        bs.printReceipt("总计：" + df.format(ti.getPaidPrice()) + "(元)" + "  节省：" + df.format(ti.getSavedPrice()) + "(元)" +
                "  商品总数：" + n +"(件)");
        bs.printReceipt("*******************************************************");
    }
}
