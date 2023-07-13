package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter @AllArgsConstructor
public class OutPlayerRespDTO {
    private Integer id;
    private String name;
    private String position;
    private String reason;
    private Timestamp day;
}
