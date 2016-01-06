package edu.team8;
import edu.team8.classes.Good;

import java.sql.*;
/**
 * Created by 知昊 on 2016/1/6.
 */
public class GetGoodByBarcode {
    private static final String sqlUrl = "jdbc:mysql://qdm169548131.my3w.com:3306/qdm169548131_db"+
            "?user=qdm169548131&password=ssXYZ379&useUnicode=true&characterEncoding=UTF8";

    private ResultSet resultList;
    private static String sql;
    private Connection sqlConnect;
    private Statement sqlStatement;

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

    public Good findByBarcode(String barcodeString)
    {
        try {
            sql="SELECT * FROM item WHERE barcode='"+barcodeString+"'";
            resultList = sqlStatement.executeQuery(sql);

            if(resultList.next()) {
                String barcode = resultList.getString("barcode");
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
}
