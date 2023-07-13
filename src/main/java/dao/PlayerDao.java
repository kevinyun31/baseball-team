package dao;

import model.Player;
import model.Stadium;
import service.PlayerService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDao {
    //create
    //read
    //update
    //delete
    private Connection connection;

    public PlayerDao(Connection connection) {
        this.connection = connection;
    }

    public void insert(String name, String position) throws SQLException {
        String query = "INSERT INTO stadium ( name, position) VALUES (?,?, now())";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, position);
            statement.executeUpdate();
            //자동 close 된다
        }
    }
    public List<Player> select() throws SQLException {
        List<Player> players = new ArrayList<>();
        String query = "SELECT * FROM player";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // 오브젝트 매핑 (테이블 데이터 -> 자바 오브젝트)
                Player player = new Player
                        (
                                rs.getInt("player_id"),
                                rs.getInt("team_id"),
                                rs.getString("name"),
                                rs.getString("position"),
                                rs.getTimestamp("created_at")

                                //디비에 있는 값을 모델이라는 그릇에 담아야하기 때문에
                                //rs에 담아서 get으로 찾아와라
                        );
                players.add(player);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return players;
    }

    public List<Player> selectByTeamId(int teamId) throws SQLException {
        List<Player> players = new ArrayList<>();
        String query = "SELECT * FROM player where team_id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, teamId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // 오브젝트 매핑 (테이블 데이터 -> 자바 오브젝트)
                Player player = new Player
                        (
                                rs.getInt("player_id"),
                                rs.getInt("team_id"),
                                rs.getString("name"),
                                rs.getString("position"),
                                rs.getTimestamp("created_at")

                                //디비에 있는 값을 모델이라는 그릇에 담아야하기 때문에
                                //rs에 담아서 get으로 찾아와라
                        );
                players.add(player);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return players;
    }
}
