package edu.team8;

import edu.team8.classes.GoodExtends;
import edu.team8.classes.TicketInfo;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by 魏来 on 2016/1/13.
 */
public class PrintTicket {
    private static int paperRest = 20;
    private static PosGUI bs;

    public static int PrintTicket(TicketInfo ti){
        int n = 0;
        Date d = new Date();                                                                       //打印时间
        DecimalFormat df = new DecimalFormat("0.00");                                             //保留两位小数格式
        DateFormat dft = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss ", Locale.CHINA);      //时间格式

        ArrayList<String> receipt = new ArrayList<String>();

        receipt.add("");
        receipt.add("\t                商店购物小票清单");                            //表头信息
        if(ti.getVipInfo() != null){
            receipt.add("会员编号： " + ti.getVipInfo().getVipCode() + "   会员积分： " + ti.getVipInfo().getVipCredit() + "分");  //迭代三
            receipt.add("-------------------------------------------------------");
        }
        receipt.add("打印时间：" + dft.format(d));                              //打印时间
        receipt.add("=======================================================");
        receipt.add("商品条码\t      名称\t 数量\t    单价(元)\t 小计(元)");
        for(GoodExtends ge:ti.getPaidList()) {
                receipt.add(ge.getBarcode() + "      " + ge.getName() + "\t " + ge.getTotalCount() + ge.getUnit() + "\t    "
                        + df.format(ge.getPrice()) + "\t " + df.format(ge.getPaidCount() * ge.getPrice()));  //打印信息
                n += ge.getTotalCount();                                                      //计算商品总数
        }
        if(ti.getSavedList().size() != 0){                                                           //有赠送商品时才打印相关赠送信息 迭代二
            receipt.add("-------------------------------------------------------");                 //打印赠送商品
            receipt.add("赠送商品：");
            for(GoodExtends ge:ti.getSavedList()) {
                receipt.add("名称：" + ge.getName() + "    数量：" + (ge.getTotalCount()));  //打印信息
            }
        }

        receipt.add("-------------------------------------------------------");                    //打印表尾
        receipt.add("总计：" + df.format(ti.getPaidPrice()) + "(元)" + ((ti.getSavedPrice()!=0)?"  节省：" + df.format(ti.getSavedPrice()) + "(元)":"") +
                "  商品总数：" + n +"(件)");
        receipt.add("*******************************************************");
        receipt.add("");

        return print(receipt);
    }

    private static int print(ArrayList<String> ticketStr){                              //打印
        for (String s:ticketStr){
            if(paperRest>0){
                bs.printReceipt(s);
                paperRest--;                                                            //每打一行 纸张余量减一
            }else{
                return -1;
            }
        }
        return 0;
    }

    public static void setBs(PosGUI bs) {
        PrintTicket.bs = bs;
    }

    public static void fullPaper() {                        //补纸
        PrintTicket.paperRest = 500;
    }
}
