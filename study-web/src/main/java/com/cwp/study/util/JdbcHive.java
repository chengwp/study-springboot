package com.cwp.study.util;

import java.sql.*;

public class JdbcHive {

    private static Connection conn;

    private static Statement st;

    public static void main(String[] args) throws Exception {
        Connection connection = getConnection();
        System.out.println("connection:"+connection);
        String sql = "show tables";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        ResultSet rs = prepareStatement.executeQuery();
        while(rs.next()){
            String db = rs.getString(1);
            System.out.println(db);
        }
    }
    /* 获取数据库连接的函数 */
    private static Connection getConnection() {
        Connection con = null; // 创建用于连接数据库的Connection对象
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");// 加载hive2数据驱动

            con = DriverManager.getConnection(
                    "jdbc:hive2://192.168.101.12:10000/default", "hive", null);// 创建数据连接

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("hive数据库连接失败" + e.getMessage());
        }
        return con; // 返回所建立的数据库连接
    }

}
