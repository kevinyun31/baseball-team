package service;

import dao.StadiumDao;
import db.DBConnection;
import model.Stadium;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StadiumService {

    StadiumDao stadiumDao;

    public StadiumService(StadiumDao stadiumDao) {
        this.stadiumDao = stadiumDao;
    }

    public void 야구장등록(String name){
        try {
            stadiumDao.insert(name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void 야구장목록보기(){
        List<Stadium> stadiums = null;

        try {
            stadiums = stadiumDao.select();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("스타디움 목록=================");
        for (Stadium s : stadiums){
            System.out.println("번호 : "+s.getStadiumId()+", 이름 : "+s.getName()+", 날짜 : "+s.getCreatedAt());
        }
    }
}
