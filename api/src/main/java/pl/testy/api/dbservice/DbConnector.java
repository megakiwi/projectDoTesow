package pl.testy.api.dbservice;

import pl.testy.api.configuration.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnector {

    private static Connection connection = null;

    private static void initConnection() {
        try{
            Class.forName(Configuration.DB_CLASS);
            String url = Configuration.DB_URL;
            String user = Configuration.DB_USER;
            String password = Configuration.DB_PASSWORD;
            connection = DriverManager.getConnection(url, user, password);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (null == connection)
            initConnection();
        return connection;
    }

}
