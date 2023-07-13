package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class Team {
    private Integer teamId;//PK
    private Integer stadiumId;
    private  String name;
    private Timestamp createdAt;

    public Team(int stadiumId, String name, Timestamp createdAt) {
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", stadiumId=" + stadiumId +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
