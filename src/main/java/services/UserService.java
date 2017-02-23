package services;

import common.exceptions.UserDaoException;
import models.dao.UserDAO;


public class UserService {
    public static boolean authorize(String login, String password) throws UserDaoException {
        if(UserDAO.getUserByLoginAndPassword(login, password)!=null){
            return true;
        }
        return false;
    }

    public static boolean registration(String login, String password){
        return UserDAO.registrationUser(login, password);
    }
}