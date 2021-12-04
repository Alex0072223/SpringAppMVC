package dbHandler;
import java.sql.*;

public class DbHandler extends Config {
    Connection connection;

    public Connection getConnection() throws ClassNotFoundException,SQLException{
        String connectionString = "jdbc:mysql://" + localhost + ":"  + port + "/" + dbname; //jdbc:mysql://localhost:3306/mydbtest
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(connectionString, user, pass);
        System.out.println("getConnection is started");
        return connection;
    }

}
