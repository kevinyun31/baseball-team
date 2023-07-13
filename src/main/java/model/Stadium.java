package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter @AllArgsConstructor
public class Stadium extends Object{

    private  Integer stadiumId;//PK
    private  String name;
    private Timestamp createdAt;

    @Override
    public String toString() {
        return "Stadium{" +
                "stadiumId=" + stadiumId +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}




