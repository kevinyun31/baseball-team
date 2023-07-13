package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getInstance(){
        //MySQL 연결 정보
        String url = "jdbc:mysql://localhost:3306/kbo";
        String username = "root";
        String password = "root1234";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("DB 연결 성공");
            return connection;
        } catch (Exception e) {
            System.out.println("DB 연결 실패 : "+ e.getMessage());
        }

        return null;
    }

    public static void main(String[] args) {
        getInstance();
    }
}

