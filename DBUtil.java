package projet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	    public static String URL = "jdbc:mysql://localhost:3306/votre_base_de_donnees";
	    public static String login = "";
	    public static String pwd= "";

	    public static Connection getConnection() {
	        // TODO Auto-generated method stub
	        Connection connection = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            connection = DriverManager.getConnection(URL, login,
	                    pwd);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return connection;
	    }
	}


