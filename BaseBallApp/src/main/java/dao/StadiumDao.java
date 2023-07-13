package dao;

import model.Stadium;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StadiumDao {
    //create
    //read
    //update
    //delete
    private Connection connection;
    public StadiumDao(Connection connection) {
        this.connection = connection;
    }

    // insert 실행문
    public void insert(String name) throws SQLException {
        String query = "INSERT INTO stadium (name, created_at) VALUES (?, now())";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.executeUpdate();
            //자동 close 된다
        }
    }

    //
    public List<Stadium> select() throws SQLException {
        List<Stadium> stadiums = new ArrayList<>();
        String query = "SELECT * FROM stadium";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // 오브젝트 매핑 (테이블 데이터 -> 자바 오브젝트)
                Stadium stadium = new Stadium
                        (
                        rs.getInt("stadium_id"),
                        rs.getString("name"),
                        rs.getTimestamp("created_at")

                        //디비에 있는 값을 모델이라는 그릇에 담아야하기 때문에
                        //rs에 담아서 get으로 찾아와라
                );
                stadiums.add(stadium);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stadiums;
    }
}