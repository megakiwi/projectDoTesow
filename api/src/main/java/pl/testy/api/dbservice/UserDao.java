package pl.testy.api.dbservice;

import pl.testy.api.model.UserDb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDao {

    public static UserDb getfindById(int id){
        String sql = " select * from usertest where id =1";
        UserDb user = new UserDb();
        Statement stat = null;
        try {
            stat = DbConnector.getConnection().createStatement();
            ResultSet res = stat.executeQuery(sql);

            while(res.next()){
                user.setId(res.getInt(1));
                user.setName(res.getString(2));
                user.setSurname(res.getString(3));
            }
            res.close();
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return user;






    }

    public static List<UserDb> getAll() {
        List<UserDb> testUsers = new ArrayList<>();
        try {
            Statement statement = DbConnector.getConnection().createStatement();
            String sql = "select * from usertest";
            ResultSet wynik = statement.executeQuery(sql);
//            testUsers = ladujDane(wynik);
            while (wynik.next()) {
                UserDb testUser = new UserDb();
                testUser.setId(wynik.getInt(1));
                testUser.setName(wynik.getString(2));
                testUser.setSurname(wynik.getString(3));
                testUsers.add(testUser);
            }
            wynik.close();
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return testUsers;
    }

    public static void saveOne(UserDb testUser) {
        String sql = "insert into usertest (id, name, surname) values (" + testUser.getId() + ", '" + testUser.getName() + "', '" + testUser.getSurname() + "')";
        try {
            DbConnector.getConnection().createStatement().executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void update(UserDb testUser, int id) {
        String sql = "update usertest set id = " + testUser.getId() + ", name = '"
                + testUser.getName() + "', surname = '" + testUser.getSurname() + "' where id = " + id;
        try {
            DbConnector.getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        String sql = "delete usertest where id = " + id;
        try {
            DbConnector.getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getOneAdamNumber(int number) {
        return "Adam ma numer " + number;
    }

    public static List<UserDb> getAllMock() {
        return Arrays.asList(new UserDb(1, "Adam", "Kowalski"),
                new UserDb(2, "Iwona", "Jasielska"),
                new UserDb(3, "iron", "Pływak"));
    }

    public static UserDb getOneUserDb(Long user) {
        return new UserDb(4, "Irek", "Dran");
    }

}
