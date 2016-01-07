package edu.team8;

import edu.team8.classes.Good;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by 啸宇 on 2016/1/7.
 */
public class ChangeListImplTest {

    @Test
    public void testChangeList1() throws Exception {
        /*ArrayList<Good> list=new ArrayList<Good>();
        Good good1 = new Good("ITEM000000","apple","斤",3.00,1);
        Good good2 = new Good("ITEM000001","pear","斤",4.00,1);
        Good good3 = new Good("ITEM000000","apple","斤",3.00,1);
        list.add(good1);
        list.add(good2);
        list.add(good3);*/
        //System.out.println(ChangeList.processChangeList(list));
        ArrayList<Good> itemlist=new ArrayList<Good>();
        ArrayList<String> barcodelist=new ArrayList<String>();
        Good good1 = new Good("ITEM000000","apple","斤",3.00,1);
        Good good2 = new Good("ITEM000001","pear","斤",4.00,1);
        Good good3 = new Good("ITEM000002","peach","斤",5.00,1);
        String barcode1=new String("ITEM000000");
        String barcode2=new String("ITEM000001");
        String barcode3=new String("ITEM000000");
        String barcode4=new String("ITEM000000");

        itemlist.add(good1);
        itemlist.add(good2);
        itemlist.add(good3);

        barcodelist.add(barcode1);
        barcodelist.add(barcode2);
        barcodelist.add(barcode3);
        barcodelist.add(barcode4);
        System.out.println(ChangeList.ConvertList(itemlist,barcodelist));
    }

}