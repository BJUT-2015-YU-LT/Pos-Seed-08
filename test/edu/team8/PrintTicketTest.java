package edu.team8;

import edu.team8.classes.GoodExtends;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by wl on 2016/1/13.
 */
public class PrintTicketTest {

    @Test
    public void testPrintTicketList() throws Exception {
        int sum = 0;
        ArrayList<GoodExtends> t=new ArrayList<GoodExtends>();
        GoodExtends ge_1 =new GoodExtends("ITEM000001","红牛","罐",6.5,1,1,0,4,4);  //正确
        t.add(ge_1);

        GoodExtends ge_2 =new GoodExtends("ITEM000002","黑牛","头",100,0.8,0.95,0,2,2);  //正确
        t.add(ge_2);

        GoodExtends ge_3 =new GoodExtends("ITEM000002","黑牛","头",100,0.9,0.95,0,3,3);  //重复
        t.add(ge_3);

        GoodExtends ge_4 =new GoodExtends("本应是条码","321","233",-10,-15,-5,1,2,3);  //错误
        t.add(ge_4);
        for(GoodExtends ge:t)
        {
            System.out.println("商品BarCode:   " + ge.getBarcode() + "   " + "名称:   " + ge.getName() + "   " +  //打印信息
                    "数量:   " + ge.getTotalCount() + ge.getUnit() + ",   " + "单价:   " + ge.getPrice() + "   " + "小计:   " + ge.getTotalCount()*ge.getPrice());
            sum+=  ge.getTotalCount()*ge.getPrice();
        }
        System.out.println("总计:" + sum);
    }
    }
