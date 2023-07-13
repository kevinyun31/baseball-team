package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter @AllArgsConstructor
public class Player {
    private  Integer playerId;//PK
    private  Integer teamId;
    private  String name;
    private  String position;
    private Timestamp createdAt;

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", teamId=" + teamId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
