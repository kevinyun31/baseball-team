package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class OutPlayerDao {
    //create
    //read
    //update
    //delete

    private Connection connection;

    public OutPlayerDao(Connection connection) {
        this.connection = connection;
    }

    public void createPlayer(Integer playerId, Integer teamId, String name, String position, Timestamp createdAt) throws SQLException {
        String query = "INSERT INTO stadium (player_id, team_id, name, position, created_at) VALUES (?, ?,?,?, now())";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playerId);
            statement.setInt(2, teamId);
            statement.setString(3, name);
            statement.setString(4, position);
            statement.setTimestamp(5, createdAt);
            statement.executeUpdate();
            //자동 close 된다
        }
    }
}
