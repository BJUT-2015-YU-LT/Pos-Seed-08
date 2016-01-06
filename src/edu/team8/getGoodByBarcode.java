package edu.team8;
import java.sql.*;
/**
 * Created by 知昊 on 2016/1/6.
 */
public class getGoodByBarcode {
    private Connection sqlConnect;
    private String sqlUrl;
    private static String sql;

    public getGoodByBarcode() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动程序");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
