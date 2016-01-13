package edu.team8;

import edu.team8.classes.Good;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by 知昊 on 2016/1/6.
 */
public class GetGoodByBarcodeTest {

    @Test
    public void testMysqlConnect()
    {
        new GetInfoInSQL();
    }

    @Test
    public void testFind()
    {
        GetInfoInSQL e = new GetInfoInSQL();
        //如果输入条码正确
        System.out.println(e.findByBarcode("ITEM0011"));
        //如果输入条码有误
        System.out.println(e.findByBarcode("ITEM01"));
    }

    @Test
    public void testGetItemInfo() throws Exception {
        GetInfoInSQL e = new GetInfoInSQL();
        String s = "ITEM0001,ITEM0,ITEM0002,ITEM0008,ITEM0003,ITEM005,ITEM0001";
        ArrayList<Good> a = e.getItemInfo(s.split(","));
        for(Good g:a){
            System.out.println(g);
        }
    }

    @Test
    public void testTotal() throws Exception {
        String s = "ITEM0001,ITEM0,ITEM0002,ITEM0008,ITEM0003,ITEM005,ITEM0001";
        ArrayList<Good> a = GetInfoInSQL.makeGoodList(s);
        for(Good g:a){
            System.out.println(g);
        }
    }
}
