package service;

import dao.OutPlayerDao;
import dao.StadiumDao;
import dao.TeamDao;
import model.OutPlayer;
import model.Player;
import model.Stadium;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OutPlayerService {
    OutPlayerDao outPlayerDao;

    public OutPlayerService(OutPlayerDao outPlayerDao) {
        this.outPlayerDao = outPlayerDao;
    }


    public void 선수퇴출등록(){}

    public void 선수퇴출목록(){}


}
