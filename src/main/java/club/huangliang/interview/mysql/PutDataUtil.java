package club.huangliang.interview.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class PutDataUtil extends  Thread  {
     @Override
    public void run()   {

         try {//加载驱动
             Class.forName("com.mysql.jdbc.Driver");

         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
         Connection connection=null;
         try {
             connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javabaseoffcer?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false&serverTimezone=UTC","root","178290");
             for (int i=0;i<2000000;i++) {
                 String sql = "insert into shop_info_small(shop_name,person_id,shop_profile) values(?,?,?);";
                 //获取链接
                 PreparedStatement pst = null;

                 pst = connection.prepareStatement(sql);
                 pst.setString(1, UUID.randomUUID().toString());
                 pst.setString(2,String.valueOf(Math.random()*10000));
                 pst.setString(3, "成都市金堂县");

                 int execute = pst.executeUpdate();
                 System.out.println("线程中的程序添加" + execute);
             }
             connection.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }

             //"+"123,"+"小明,"+"成都市,"+"小明的家乡,"
             //                +"motto"+")";

//        for (int i=0;i<10000;i++){
         }
     }

