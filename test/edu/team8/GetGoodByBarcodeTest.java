package edu.team8;

import org.junit.Test;

/**
 * Created by 知昊 on 2016/1/6.
 */
public class GetGoodByBarcodeTest {

    @Test
    public void testMysqlConnect()
    {
        new GetGoodByBarcode();
    }

    @Test
    public void testFind()
    {
        GetGoodByBarcode e = new GetGoodByBarcode();
        e.findByBarcode("ITEM0001");
    }
}
