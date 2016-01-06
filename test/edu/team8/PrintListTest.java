package edu.team8;

import edu.team8.classes.GoodExtends;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by wl on 2016/1/6.
 */
public class PrintListTest {
    double sum = 0;
    @Test
    public void testPrintGoodList() throws Exception {
        ArrayList<GoodExtends> t=new ArrayList<GoodExtends>();
        GoodExtends ge_1 =new GoodExtends("ITEM000001","红牛","罐",6.5,3);  //正确
        t.add(ge_1);

        GoodExtends ge_2 =new GoodExtends("ITEM000002","黑牛","头",10,2);  //正确
        t.add(ge_2);

        for(GoodExtends ge:t)
        {
            System.out.println("商品BarCode:   " + ge.getBarcode() + "   " + "名称:   " + ge.getName() + "   " +  //打印信息
                    "数量:   " + ge.getCount() + ge.getUnit() + ",   " + "单价:   " + ge.getPrice() + "   " + "小计:   " + ge.getCount()*ge.getPrice());
            sum+=  ge.getCount()*ge.getPrice();
        }
        System.out.println("总计:" + sum);
    }
}