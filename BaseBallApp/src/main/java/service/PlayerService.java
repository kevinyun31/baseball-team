package service;

import dao.PlayerDao;
import dao.StadiumDao;
import model.Player;

import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;

public class PlayerService {

    Connection connection;
    PlayerDao playerDao;


    public PlayerService(Connection connection, PlayerDao playerDao) {
        this.connection = connection;
        this.playerDao = playerDao;
    }

    //1.팀별 선수 등록
    public void playerInsert() {
//        선수등록?teamId=1&name=이대호&position=1루수
        String str = "선수등록?teamId=1&name=이대호&position=1루수";
        String[] first = str.split("\\?");
        String f1 = first[0];

        String[] f2 = first[1].split("&");
        String[] ret1 = f2[0].split("=");
        String[] ret2 = f2[1].split("=");
        String[] ret3 = f2[2].split("=");

        String name = ret2[1];
        String position = ret3[1];


        try {
            playerDao.insert(name, position);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


//    2.팀별 선수 목록 보기
    public void playerSelect() {
        List<Player> players = null;

        String str = "선수목록?teamId=1";
        String[] first = str.split("\\?");
        String f1 = first[0];

        String [] f2=first[1].split("=");
        String ret1= f2[0];
        String ret2= f2[1];

       String teamId = ret1;
        try {
            players = playerDao.select();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // 출력에서 teamId를 제외하고 원하는 내용만 출력
        for (Player player : players) {
            System.out.println("선수번호:" + player.getPlayerId() +",  선수이름:" + player.getName() +
                    ",  포지션:" + player.getPosition() + ",  입단일:" + player.getCreatedAt());
        }
    } // body
} // class

// System.out.println(players);