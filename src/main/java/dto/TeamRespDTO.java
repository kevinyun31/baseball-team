package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter @AllArgsConstructor
public class TeamRespDTO {
    private  Integer teamId;
    private  String teamName;
    private  String stadiumName;
    private Timestamp createdAt;

}
