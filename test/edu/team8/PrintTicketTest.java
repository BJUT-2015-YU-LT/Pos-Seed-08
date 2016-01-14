package edu.team8;

import edu.team8.classes.Good;
import edu.team8.classes.GoodExtends;
import edu.team8.classes.TicketInfo;
import edu.team8.classes.Vip;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by wl on 2016/1/13.
 */
public class PrintTicketTest {

    @Test
    public void testPrintTicketList() throws Exception {
        TicketInfo info1 = new TicketInfo();
        TicketInfo info2 = new TicketInfo();

        ArrayList<GoodExtends> p1=new ArrayList<GoodExtends>();
        ArrayList<GoodExtends> p2=new ArrayList<GoodExtends>();
        ArrayList<GoodExtends> s1=new ArrayList<GoodExtends>();
        ArrayList<GoodExtends> s2=new ArrayList<GoodExtends>();

        Vip v1= new Vip("vip01",50);
        Vip v2= new Vip("vip02",-10);


        GoodExtends ge_1 =new GoodExtends("ITEM000001","红牛","罐",6.5,1,1, Good.NORMAL,4,4);  //正确
        p1.add(ge_1);

        GoodExtends ge_2 =new GoodExtends("ITEM000002","黑牛","头",100,0.8,0.95 , Good.NORMAL,2,2);  //正确
        p2.add(ge_2);

        GoodExtends ge_3 =new GoodExtends("ITEM000002","黑牛","头",100,2,0.95, Good.PROMOTION,3,2);  //重复
        s1.add(ge_3);

        GoodExtends ge_4 =new GoodExtends("本应是条码","321","233",-10,-15,-5, Good.DISCOUNT,2,3);  //错误
        s2.add(ge_4);

        info1.setPaidList(p1);
        info1.setSavedList(s1);
        info1.setPaidPrice(6);
        info1.setSavedPrice(2);
        info1.setVipInfo(v1);


        info2.setPaidList(p2);
        info2.setSavedList(s2);

        /*for(GoodExtends ge:t)
        {
            System.out.println("商品BarCode:   " + ge.getBarcode() + "   " + "名称:   " + ge.getName() + "   " +  //打印信息
                    "数量:   " + ge.getTotalCount() + ge.getUnit() + ",   " + "单价:   " + ge.getPrice() + "   "
                    + "小计:   " + ge.getTotalCount()*ge.getPrice());
            sum+=  ge.getTotalCount()*ge.getPrice();
        }
        System.out.println("总计:" + sum);*/
        PosGUI pg = new PosGUI("test");
        PrintTicket.PrintTicketList(info1,pg);

    }
}
