package edu.team8;

import edu.team8.classes.Good;
import edu.team8.classes.GoodExtends;
import edu.team8.classes.Vip;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by 啸宇 on 2016/1/13.
 */
public class ChangeListTest {

    @Test
    public void testAccount() throws Exception {
        ArrayList<GoodExtends> list=new ArrayList<GoodExtends>();
        Vip vip=new Vip("VIP0001",6);
        GoodExtends good1 = new GoodExtends("ITEM000000","pear","斤",3.00,0.8,0.7,Good.NORMAL,3,2);
        /*String barcode, String name, String unit, double price ,
                       double discount ,double vipDiscount ,int preferType,
                       int totalCount ,int paidCount*/
        GoodExtends good2 = new GoodExtends("ITEM000001","apple","斤",4.00,0.8,0.7,Good.DISCOUNT,3,2);

        list.add(good1);
        list.add(good2);
        //vip=null;

        System.out.println(ChangeList.account(list,vip));
    }
}