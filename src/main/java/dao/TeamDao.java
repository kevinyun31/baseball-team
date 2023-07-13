package dao;


import dto.TeamRespDTO;
import model.Team;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamDao {

    //create
    //read
    //update
    //delete

    private Connection connection;

    public TeamDao(Connection connection) {
        this.connection = connection;
    }

    public void insert(int stadiumId, String name) throws SQLException {
        String query = "INSERT INTO team (stadium_id, name, created_at) VALUES (?, ?,now())";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, stadiumId);
            statement.setString(2, name);
            statement.executeUpdate();
            //자동 close 된다
        }
    }

    public List<TeamRespDTO> selectJoin() throws SQLException {
        List<TeamRespDTO> teams = new ArrayList<>();
        String query = "select t.team_id, t.name, st.name, st.created_at " +
                "from team t inner join stadium st " +
                "on t.stadium_id = st.stadium_id";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // 오브젝트 매핑 (테이블 데이터 -> 자바 오브젝트)
                TeamRespDTO team = new TeamRespDTO
                        (
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getTimestamp(4)
                        );
                teams.add(team);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return teams;
    }

    public List<Team> select() throws SQLException {
        List<Team> teams = new ArrayList<>();
        String query = "SELECT * FROM team";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // 오브젝트 매핑 (테이블 데이터 -> 자바 오브젝트)
                Team team = new Team
                        (
                                rs.getInt("stadium_id"),
                                rs.getString("name"),
                                rs.getTimestamp("created_at")

                                //디비에 있는 값을 모델이라는 그릇에 담아야하기 때문에
                                //rs에 담아서 get으로 찾아와라
                        );
                teams.add(team);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return teams;
    }
}



