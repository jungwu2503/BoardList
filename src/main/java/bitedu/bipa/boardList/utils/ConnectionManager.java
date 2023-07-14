package bitedu.bipa.boardList.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
   private static ConnectionManager manager;
   private ConnectionManager() {
      
   }
   
   public static ConnectionManager getInstance() {
      if(manager==null) {
         manager = new ConnectionManager();
      }
      return manager;
   }
   
   public Connection getConnection() {
      Connection con = null;
      String jdbcURL = "jdbc:mysql://localhost:3306/boardlist?serverTimezone=UTC&allowPublicKeyRetrieval=true";
      String driver = "com.mysql.cj.jdbc.Driver";
      String id = "root";
      String pwd = "root";
      
      try {
         Class.forName(driver);
         con = DriverManager.getConnection(jdbcURL,id,pwd);
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return con;
   }
   
   public void closeConnection(ResultSet rs , Statement stmt, Connection con) {
      if(rs!=null) {
         try {
            rs.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      
      if(stmt!=null) {
         try {
            stmt.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      
      if(con!=null) {
         try {
            con.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      } else {
         con = null;
      }
   }
}