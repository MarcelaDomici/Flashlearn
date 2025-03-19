package ConnectSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDatabase {

    private final static String url = "jdbc:mysql://localhost:3306/dbflashlearn";
    private final static String user = "root";
    //private final static String pass = "";

    private static Connection conm = null;

    public static Connection getConnection() {
        try {

            if (conm == null) {
                conm = DriverManager.getConnection(url, user, null);
            } else {
                return conm;
            }
        } catch (SQLException ie) {
        }
        return conm;
    }

}
