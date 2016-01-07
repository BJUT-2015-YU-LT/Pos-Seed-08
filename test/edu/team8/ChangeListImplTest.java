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
        ArrayList<Good> list=new ArrayList<Good>();
        Good good1 = new Good("ITEM000000","apple","斤",3.00,1);
        Good good2 = new Good("ITEM000001","pear","斤",4.00,1);
        Good good3 = new Good("ITEM000000","apple","斤",3.00,1);
        list.add(good1);
        list.add(good2);
        list.add(good3);
        System.out.println(ChangeList.processChangeList(list));
    }

}