package dao;

import dto.OutPlayerRespDTO;
import model.OutPlayer;
import model.Team;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OutPlayerDao {
    //create
    //read
    //update
    //delete

    private Connection connection;

    public OutPlayerDao(Connection connection) {
        this.connection = connection;
    }

    public void insert(String name, String position, Timestamp createdAt) throws SQLException {
        String query = "INSERT INTO stadium (name, position, created_at) VALUES (?,?, now())";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, position);
            statement.setTimestamp(3, createdAt);
            statement.executeUpdate();
            //자동 close 된다
        }
    }

    public List<OutPlayer> select() throws SQLException {
        List<OutPlayer> outPlayers = new ArrayList<>();
        String query = "SELECT * FROM out_player";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // 오브젝트 매핑 (테이블 데이터 -> 자바 오브젝트)
                OutPlayer outPlayer = new OutPlayer
                        (
                                rs.getInt("out_player_id"),
                                rs.getInt("player_id"),
                                rs.getString("reason"),
                                rs.getTimestamp("created_at")

                        );
                outPlayers.add(outPlayer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return outPlayers;
    }

    public List<OutPlayerRespDTO> selectJoin() throws SQLException {
        List<OutPlayerRespDTO> dtos = new ArrayList<>();
        String query = "SELECT p.player_id, p.name, p.position, op.reason, op.created_at  " +
                "FROM player p " +
                "left outer join out_player op on p.player_id = op.player_id";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // 오브젝트 매핑 (테이블 데이터 -> 자바 오브젝트)
                OutPlayerRespDTO dto = new OutPlayerRespDTO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getTimestamp(5)
                );
                dtos.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dtos;
    }


}
