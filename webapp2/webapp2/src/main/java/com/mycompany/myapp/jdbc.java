package com.mycompany.myapp;
import java.sql.*;
import java.sql.SQLException;

public class jdbc {

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;database=test;databaseName=test";
            
            Connection conn = DriverManager.getConnection(connectionUrl,"test","1234");
            Statement stmt = conn.createStatement();
            System.out.println("MS-SQL 서버 접속에 성공하였습니다.");
            ResultSet rs = stmt.executeQuery("SELECT * FROM USER_INFO");
            while( rs.next() ) {
                   String field1 = rs.getString("ID");
                   String field2 = rs.getString("PW");
                   System.out.print(field1 + "\t");
                   System.out.println(field2);
                  }
            rs.close();
            stmt.close();   
            conn.close();
        } catch (SQLException sqle) {
            System.out.println("SQLException : " + sqle);
        }
    }

}