package edu.team8;
import edu.team8.classes.Good;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by 知昊 on 2016/1/6.
 */
public class GetInfoInSQL {
    /**
     * 得到窗口对象以方便输出 成员变量访问
     */
    private static BarcodeScanner window=null;

    //SQL地址 用户名 密码
    private static final String sqlUrl = "jdbc:mysql://qdm169548131.my3w.com:3306/qdm169548131_db"+
            "?useUnicode=true&characterEncoding=UTF8";
    private static final String sqlUser = "qdm169548131";
    private static final String sqlPassword = "ssXYZ379";

    private ResultSet resultList;       //结果列表
    private Connection sqlConnect;      //SQL链接

    //SQL命令发送器?
    private PreparedStatement findItemStat;
    private PreparedStatement findVipStat;

    //SQL语句
    private static final String findItemSQL = "SELECT * FROM item WHERE barcode=?";
    private static final String findVipSQL = "SELECT * FROM vip WHERE vip_code=?";

    /**
     * 数据库连接函数
     */
    public GetInfoInSQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.outputLog("成功加载MySQL驱动程序");

            sqlConnect = DriverManager.getConnection(sqlUrl,sqlUser,sqlPassword);
            this.outputLog("成功连接到数据库");

            findItemStat = sqlConnect.prepareStatement(findItemSQL);
            findVipStat = sqlConnect.prepareStatement(findVipSQL);
        } catch (ClassNotFoundException e) {
            this.outputLog("加载MySQL驱动程序失败");
        } catch (SQLException e) {
            this.outputLog("连接到数据库失败");
        }
    }

    /**
     * 根据条码找商品
     * @param barcodeString
     * @return
     */
    public Good findByBarcode(String barcodeString)
    {
        try {
            findItemStat.setString(1,barcodeString);
            resultList = findItemStat.executeQuery();

            if(resultList.next()) {
                String barcode = resultList.getString("barcode");           //从数据库查信息
                String name = resultList.getString("name");
                String unit = resultList.getString("unit");
                double price = resultList.getDouble("price");
                /**
                 * 需求 2 添加 discount
                 * 需求 5 添加 vipDiscount
                 * 进而添加 preferType
                 */
                int preferType = resultList.getInt("prefer_type");
                double discount = resultList.getDouble("discount");
                double vipDiscount = resultList.getDouble("vip_discount");
                Good result = new Good(barcode, name, unit, price ,discount,vipDiscount,preferType);
                return result;
            }
        } catch (SQLException e) {
            this.outputLog("查询数据失败, 请于管理员联系");
        }
        return null;
    }

    /**
     * 根据条码列表生成商品列表
     * @param barcodeStrings
     * @return 含有重复的商品列表
     */
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
                this.outputLog("检索不到条码["+barcode+"]的信息, 请于管理员联系");
        }
        return goodArrayList;
    }

    /**
     * 分配输出窗口
     * @param window
     */
    public static void setWindow(BarcodeScanner window) {
        GetInfoInSQL.window = window;
    }

    /**
     * 生成商品列表
     * @param barcodes
     * @return
     */
    public static ArrayList<Good> makeGoodList(String barcodes)
    {
        GetInfoInSQL getGoodConnect = new GetInfoInSQL();
        ArrayList<Good> result = getGoodConnect.getItemInfo(processBarcodeSting(barcodes));
        return  result;
    }

    /**
     * 处理条码字符串
     * @param barcodeText
     * @return
     */
    private static String[] processBarcodeSting(String barcodeText)
    {
        String processing = barcodeText.replace("\n","");
        String[] result= processing.split(",");
        return result;
    }

    /**
     * 输出log信息
     * @param str
     */
    private void outputLog(String str)
    {
        if(window!=null)
            window.printLog(str);
        else
            System.out.println(str);
    }
}
