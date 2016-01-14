package edu.team8;
import edu.team8.classes.Good;
import edu.team8.classes.Vip;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by 知昊 on 2016/1/6.
 */
public class GetInfoInSQL {
    /**
     * 得到窗口对象以方便输出 成员变量访问
     */
    private static PosGUI window=null;

    //SQL地址 用户名 密码
    private static final String sqlUrl = "jdbc:mysql://qdm169548131.my3w.com:3306/qdm169548131_db"+
            "?useUnicode=true&characterEncoding=UTF8";
    private static final String sqlUser = "qdm169548131";
    private static final String sqlPassword = "ssXYZ379";

    private Connection sqlConnect;      //SQL链接

    //SQL命令发送器?
    private PreparedStatement findItemStat;
    private PreparedStatement findVipStat;
    private PreparedStatement updateVipStat;

    //SQL语句
    private static final String findItemSQL = "SELECT * FROM item WHERE barcode=?";
    private static final String findVipSQL = "SELECT * FROM vip WHERE vip_code=?";
    private static final String updateVipSQL = "UPDATE vip SET vip_credit=vip_credit+? WHERE vip_code=?";

    /**
     * 数据库连接函数
     */
    public GetInfoInSQL() {
        try {
            this.outputLog("正在连接数据库");
            Class.forName("com.mysql.jdbc.Driver");
            this.outputLog("成功加载MySQL驱动程序");

            sqlConnect = DriverManager.getConnection(sqlUrl,sqlUser,sqlPassword);
            this.outputLog("成功连接到数据库");

            findItemStat = sqlConnect.prepareStatement(findItemSQL);
            findVipStat = sqlConnect.prepareStatement(findVipSQL);
            updateVipStat = sqlConnect.prepareStatement(updateVipSQL);
        } catch (ClassNotFoundException e) {
            this.outputLog("加载MySQL驱动程序失败");
        } catch (SQLException e) {
            this.outputLog("连接到数据库失败");
        }
    }

    /**
     * 根据会员号查找会员信息
     * @param vipCode
     * @return
     */
    public Vip findVipByCode(String vipCode)
    {
        try {
            findVipStat.setString(1,vipCode);
            ResultSet resultList = findVipStat.executeQuery();

            if(resultList.next()) {
                String vipCode_1 = resultList.getString("vip_code");
                int vipCredit = resultList.getInt("vip_credit");
                Vip result = new Vip(vipCode_1,vipCredit);
                return result;
            }else {
                this.outputLog("不存在会员: "+vipCode);
            }
        } catch (SQLException e) {
            this.outputLog("查询数据失败, 请联系管理员");
        }
        return null;
    }

    /**
     * 为指定会员添加积分
     * @param vipCode
     * @param credit
     * @return -1为错误,0为添加失败,1为添加成功
     */
    public int addVipCredit(int credit,String vipCode)
    {
        try {
            if(credit<0) {
                this.outputLog("积分不能为负!");
                return -1;
            }
            updateVipStat.setInt(1,credit);
            updateVipStat.setString(2,vipCode);
            int result = updateVipStat.executeUpdate();

            if(0==result){
                this.outputLog("会员积分添加失败,可能该用户不存在");
            }else if(1!=result){
                this.outputLog("发生严重错误!请联系管理员!");
            }
            return result;
        } catch (SQLException e) {
            this.outputLog("修改数据失败, 请联系管理员");
        }
        return -1;
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
            ResultSet resultList = findItemStat.executeQuery();

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
            }else{
                this.outputLog("检索不到条码["+barcodeString+"]的信息, 请联系管理员");
            }
        } catch (SQLException e) {
            this.outputLog("查询数据失败, 请联系管理员");
        }
        return null;
    }

    /**
     * 根据条码列表生成商品列表
     * @param barcodeStrings
     * @return 含有重复的商品列表
     */
    public ArrayList<Good> getItemInfo(String[] barcodeStrings) {
        if (barcodeStrings.length == 0)
            return null;
        ArrayList<Good> goodArrayList = new ArrayList<Good>();
        for (String barcode : barcodeStrings) {
            Good finded = findByBarcode(barcode);
            if (finded != null)
                goodArrayList.add(finded);
        }
        return goodArrayList;
    }

    /**
     * 分配输出窗口
     * @param window
     */
    public static void setWindow(PosGUI window) {
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
