import dao.OutPlayerDao;
import dao.PlayerDao;
import dao.StadiumDao;
import dao.TeamDao;
import db.DBConnection;
import model.Stadium;
import service.OutPlayerService;
import service.PlayerService;
import service.StadiumService;
import service.TeamService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class BaseBallApp {

    public static void main(String[] args) {
        // 1. DB연결
        Connection connection = DBConnection.getInstance();
        
        // 2. DAO 생성
        StadiumDao stadiumDao = new StadiumDao(connection);
        TeamDao teamDao= new TeamDao(connection);
        PlayerDao playerDao = new PlayerDao(connection);
        OutPlayerDao outPlayerDao = new OutPlayerDao(connection);
        
        // 3. Service 생성
        StadiumService stadiumService = new StadiumService(stadiumDao);
        TeamService teamService = new TeamService(teamDao);
        PlayerService playerService = new PlayerService(playerDao);
        OutPlayerService outPlayerService = new OutPlayerService(outPlayerDao);

        // 4. 요청방법 설명
        System.out.println("요청 방법을 알려드려요=========");
        System.out.println("1. 야구장등록?name=잠실야구장");
        System.out.println("2. 야구장목록");
        System.out.println("3. 팀등록?stadiumId=1&name=NC");
        System.out.println("4. 팀목록");
        System.out.println("5. 선수등록?teamId=1&name=이대호&position=1루수");
        System.out.println("6. 선수목록?teamId=1");
        System.out.println("7. 퇴출등록?playerId=1&reason=도박");
        System.out.println("8. 퇴출목록");
        System.out.println("9. 포지션별목록");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String action = input.split("\\?")[0];

        if(action.equals("야구장등록")){
            String queryString = input.split("\\?")[1];
            String name = queryString.split("=")[1];
            stadiumService.야구장등록(name);
        }else if(action.equals("야구장목록")) {
            stadiumService.야구장목록보기();
        }else if(action.equals("팀등록")){
            String queryString = input.split("\\?")[1];
            int stadiumId = Integer.parseInt(queryString.split("&")[0].split("=")[1]);
            String name = queryString.split("&")[1].split("=")[1];
            teamService.팀등록(stadiumId, name);
        }else if(action.equals("팀목록")){
            teamService.팀목록();
        }else if(action.equals("선수등록")){
            playerService.선수등록();
        }else if(action.equals("선수목록")){
            playerService.팀별선수목록();
        }else if(action.equals("퇴출등록")){
            outPlayerService.선수퇴출등록();
        }else if(action.equals("퇴출목록")){
            outPlayerService.선수퇴출목록();
        }else if(action.equals("포지션별목록")){
            playerService.포지션별목록();
        }else{
            System.out.println("잘못된 입력을 하셨습니다.");
            System.out.println("====================");
        }

    }
}
