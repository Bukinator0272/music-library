package model.dbservice.connection;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseService {
    private static DataBaseService service;
    private Connection connection;

    private DataBaseService() {
    }

    public static DataBaseService getInstance() {
        if (service == null) {
            service = new DataBaseService();
        }
        return service;
    }

    public Connection getConnection() {
        if (connection == null) {
            connection = getMysqlConnection();
        }
        return connection;
    }

    private static Connection getMysqlConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            StringBuilder url = new StringBuilder();
            url.append("jdbc:mysql://")     //db type
                    .append("localhost:")         //host name
                    .append("3306/")                //port
                    .append("musiclib?")             //db name
                    .append("user=root")        //login
                    .append("&password=root")
                    .append("&serverTimezone=Europe/Samara");       //password
            System.out.println("URL: " + url + "\n");
            return DriverManager.getConnection(url.toString());
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException |NoSuchMethodException| InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
