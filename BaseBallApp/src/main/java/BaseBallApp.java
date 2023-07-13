import dao.PlayerDao;
import dao.StadiumDao;
import dao.TeamDao;
import db.DBConnection;
import model.Stadium;
import service.PlayerService;
import service.StadiumService;
import service.TeamService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class BaseBallApp {
    public static void main(String[] args)  {

        //1. DB연결
        Connection connection = DBConnection.getInstance();
//        StadiumDao stadiumDao = new StadiumDao(connection);
//        TeamDao teamDao= new TeamDao(connection);
        PlayerDao playerDao = new PlayerDao(connection);
//
//        Scanner sc = new Scanner(System.in);
//        String pn = sc.nextLine();
//
//        StadiumService stadiumService = new StadiumService(connection,stadiumDao);
//        TeamService teamService = new TeamService(connection,teamDao);
        PlayerService playerService = new PlayerService(connection, playerDao);

//        stadiumService.stadiumInsert();
//        stadiumService.stadiumSelect();
//          playerService.playerInsert();
          playerService.playerSelect();
    } // main
} // class


