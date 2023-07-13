package service;

import dao.TeamDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TeamService {

    // TeamDao 와 연결하기
    Connection connection;
    TeamDao teamDao;

    public  TeamService(Connection connection , TeamDao teamDao){
        this.connection = connection;
        this.teamDao = teamDao;
    }

    public static void teamInsert() {
        String str= "팀등록?stadiumId=1&name=NC\n";
        String [] first= str.split("\\?");
        String t1=first[0];//팀등록
        String []t2=first[1].split("=");
        String t4=first[2];

    } // body
} // class









//    String str= "팀등록?stadiumId=1&name=NC\n";
//    String [] first= str.split("\\?"); // split("\\?") ? 기준으로 분리시킨다.
//    String t1=first[0];                        //팀등록
//    String []t2=first[1].split("=");
//    String t4=first[2];
//
//             System.out.println(t1);
//                     System.out.println(t2); //System.out.println(Arrays.toString(t2)); 문자열 배열이므로 toString 추가