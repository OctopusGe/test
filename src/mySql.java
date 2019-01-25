
import java.sql.*;
public class mySql 
{
    public static void main(String[] args) 
    {
        try 
        {  
              Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序      
              System.out.println("Success loading Mysql Driver!");  
         }  
         catch (Exception e) 
        {  
              System.out.print("Error loading Mysql Driver!");  
              e.printStackTrace();  
        }  
        try 
        {  
               System.out.println("start connecting");

                Connection connect = DriverManager.getConnection( 
                  "jdbc:mysql://127.0.0.1:3306/mySql?useUnicode=true&characterEncoding=utf-8&useSSL=false",
                  "root","zhangyu123"); 
                   //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码  
          
               System.out.println("Success connect Mysql server!");  
              
               Statement stmt = connect.createStatement();  
               
               //ResultSet rs = stmt.executeQuery("select * from abc.DORMITORIES");  
               ResultSet rs = stmt.executeQuery("select * from abc.DORMITORIES where DormitoryId='26#307'");  
                                                                      //user 为你表的名称  
               System.out.println("宿舍编号\t姓名\t性别\t成员类型\t床位号");
               while (rs.next()) 
               {  
                   
                   String dormotoryId = rs.getString("DormitoryId");
                   String name 		  = rs.getString("Name");
                   String sex 		  = rs.getString("Sex");
                   String memberType  = rs.getString("MemberType");
                   String bedNumber   = rs.getString("BedNumber");
                   
                   System.out.println(dormotoryId+"\t"+name+"\t"+sex+"\t"+memberType+"\t"+bedNumber);
               }   
               rs.close(); 
               connect.close(); // 关闭连接  
         }  
         catch (Exception e) 
         {  
              System.out.print("get data error!");  
              e.printStackTrace();  
          }  
    }  
}
