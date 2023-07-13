package service;
import dao.StadiumDao;
import db.DBConnection;
import model.Stadium;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StadiumService {
    Connection connection;
    StadiumDao stadiumDao;
    private String str;

    public StadiumService(Connection connection, StadiumDao stadiumDao) {
        this.connection = connection;
        this.stadiumDao = stadiumDao;
    }

    //1.야구장 등록
    public  void stadiumInsert(){

        String str= "야구장 등록?name=잠실야구장";
        String [] first= str.split("\\?");

        String f1=first[0];

        String [] f2=first[1].split("=");
        String ret1= f2[0];
        String ret2= f2[1];

        try {
            stadiumDao.insert(ret2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //2.야구장 목록 보기

    public void stadiumSelect(){
        List<Stadium> stadiums = null;

        try {
            stadiums = stadiumDao.select();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(stadiums);
    }
}