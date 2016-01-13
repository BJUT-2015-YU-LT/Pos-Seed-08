package edu.team8;

import edu.team8.classes.Good;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by 知昊 on 2016/1/13.
 */
public class GetInfoInSQLTest {

    @Test
    public void testFindVipByCode() throws Exception {
        GetInfoInSQL e = new GetInfoInSQL();
        //输入正确的会员号
        System.out.println(e.findVipByCode("VIP001"));
        //输入错误的会员号
        System.out.println(e.findVipByCode("KONAN"));
    }

    @Test
    public void testFindByBarcode() throws Exception {
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
    public void testMakeGoodList() throws Exception {

    }

    @Test
    public void testTotal() throws Exception {
        String s = "ITEM0001,APTX4869,ITEM0002,ITEM0008,ITEM0003,ITEM005,ITEM0001";
        ArrayList<Good> a = GetInfoInSQL.makeGoodList(s);
        for(Good g:a){
            System.out.println(g);
        }
    }

    @Test
    public void testAddVipCredit() throws Exception {
        GetInfoInSQL e = new GetInfoInSQL();
        //输入正确的会员号
        System.out.println(e.addVipCredit(20,"VIP001"));
        System.out.println(e.findVipByCode("VIP001"));
        System.out.println();
        //输入错误的会员号
        System.out.println(e.addVipCredit(20,"KONAN"));
        System.out.println(e.findVipByCode("KONAN"));
        System.out.println();
        //输入错误的积分
        System.out.println(e.addVipCredit(-20,"VIP001"));
        System.out.println(e.findVipByCode("VIP001"));
        System.out.println();
        //输入错误的积分和错误的会员号
        System.out.println(e.addVipCredit(-10,"KONAN"));
        System.out.println(e.findVipByCode("KONAN"));
        System.out.println();
    }
}