package service;

import dao.TeamDao;
import dto.TeamRespDTO;
import model.Team;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TeamService {

    TeamDao teamDao;

    public  TeamService(TeamDao teamDao){
        this.teamDao = teamDao;
    }

    public void 팀등록(int stadiumId, String name){
        try {
            teamDao.insert(stadiumId, name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void 팀목록(){
        try {
            List<TeamRespDTO> teamList = teamDao.selectJoin();
            for(TeamRespDTO t : teamList){
                System.out.println("팀번호 : "+t.getTeamId()+", 팀이름 : "+t.getTeamName()+", 경기장이름 : "+t.getStadiumName()+", 팀창단일 : "+t.getCreatedAt());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
