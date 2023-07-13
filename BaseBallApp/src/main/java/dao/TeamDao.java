package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TeamDao {

    //create
    //read
    //update
    //delete

    private Connection connection;

    public TeamDao(Connection connection) {
        this.connection = connection;
    }

    public void createTeam(Integer stadiumId, String name) throws SQLException {
        String query = "INSERT INTO team (stadium_id, name, created_at) VALUES (?,?,now())";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, stadiumId);
            statement.setString(2, name);
            statement.executeUpdate();
            //자동 close 된다
        }


    }

}
