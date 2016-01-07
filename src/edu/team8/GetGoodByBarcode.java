package edu.team8;
import edu.team8.classes.Good;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by 知昊 on 2016/1/6.
 */
public class GetGoodByBarcode {
    /**
     * 得到窗口对象以方便输出 成员变量访问
     */
    private static BarcodeScanner window;

    //SQL地址
    private static final String sqlUrl = "jdbc:mysql://qdm169548131.my3w.com:3306/qdm169548131_db"+
            "?user=qdm169548131&password=ssXYZ379&useUnicode=true&characterEncoding=UTF8";

    //SQL语句
    private String sql;
    private ResultSet resultList;       //结果列表
    private Connection sqlConnect;      //SQL链接
    private Statement sqlStatement;     //SQL命令发送器?


    //数据库连接函数
    public GetGoodByBarcode() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动程序");

            sqlConnect = DriverManager.getConnection(sqlUrl);
            System.out.println("成功连接到数据库");

            sqlStatement = sqlConnect.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("加载MySQL驱动程序失败");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("连接到数据库失败");
        }
    }

    //根据条码找商品
    public Good findByBarcode(String barcodeString)
    {
        try {
            sql="SELECT * FROM item WHERE barcode='"+barcodeString+"'";
            resultList = sqlStatement.executeQuery(sql);

            if(resultList.next()) {
                String barcode = resultList.getString("barcode");           //从数据库查信息
                String name = resultList.getString("name");
                String unit = resultList.getString("unit");
                double price = resultList.getDouble("price");
                Good result = new Good(barcode, name, unit, price);
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //根据条码列表生成商品列表
    public ArrayList<Good> getItemInfo(String[] barcodeStrings)
    {
        if(barcodeStrings.length==0)
            return null;
        ArrayList<Good> goodArrayList = new ArrayList<Good>();
        for(String barcode:barcodeStrings)
        {
            Good finded=findByBarcode(barcode);
            if(finded!=null)
                goodArrayList.add(finded);
            else
            {
                System.out.println("检索不到条码["+barcode+"]的信息, 请于管理员联系");
            }
        }
        return goodArrayList;
    }

    public static void setWindow(BarcodeScanner window) {
        GetGoodByBarcode.window = window;
    }

    public static ArrayList<Good> makeGoodList(String barcodes)
    {
        GetGoodByBarcode getGoodConnect = new GetGoodByBarcode();
        ArrayList<Good> result = getGoodConnect.getItemInfo(barcodes.split(","));
        return  result;
    }

    private String processBarcodeSting(String barcodes)
    {
        String result = new String(barcodes);
        result.replace("\n","");
        return result;
    }
}
