package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class OutPlayer {
    private  Integer outPlayerId;//PK
    private  Integer playerId;
    private  String reason;
    private Timestamp createdAt;


}
