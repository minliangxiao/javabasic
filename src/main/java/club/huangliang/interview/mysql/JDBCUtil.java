package club.huangliang.interview.mysql;

import java.sql.*;
import java.util.Properties;
import java.util.UUID;

public class JDBCUtil {
    public static void main(String[] args) throws SQLException {
        for (int i=0;i<15;i++){
            new PutDataUtil().start();
        }
//        try {//加载驱动
//            Class.forName("com.mysql.jdbc.Driver");
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Connection connection=null;
//        connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javabaseoffcer?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false&serverTimezone=UTC","root","178290");
//        new PutDataUtil().start();
//        for (int i=0;i<2000000;i++){
//            String  sql="insert into person_info_large(account,name,area,title,motto) values(?,?,?,?,?);";
//            //获取链接
//            PreparedStatement pst=connection.prepareStatement(sql);
//            //"+"123,"+"小明,"+"成都市,"+"小明的家乡,"
//            //                +"motto"+")";
//            pst.setString(1, UUID.randomUUID().toString());
//            pst.setString(2,"小明");
//            pst.setString(3,"成都市金堂县");
//            pst.setString(4,"小明的家乡");
//            pst.setString(5,"motto");
////        for (int i=0;i<10000;i++){
//            int execute = pst.executeUpdate();
//            System.out.println("非线程执行"+execute);
//        }
//
//        connection.close();

    }
}
