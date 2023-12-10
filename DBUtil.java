package projet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	    public static String URL = "jdbc:mysql://localhost:3306/biblio";
	    public static String login = "root";
	    public static String pwd= "";

	    public static Connection getConnection() {
	        // TODO Auto-generated method stub
	        Connection connection = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection(URL, login,
	                    pwd);
	            			System.out.println("conncter to database");
	            
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


