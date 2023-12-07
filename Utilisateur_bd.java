package projet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

	public class Utilisateur_bd {

		private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (idutilisateur,nom,prenom,login, pwd,role ) VALUES "
				+ " (?, ?,?,?,?,?);";

		private static final String SELECT_USER_BY_ID = "select idutlisaeur,nom,prenom,login,pwd,role from users where id =?";
		private static final String SELECT_ALL_USERS = "select * from users";
		private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
		private static final String UPDATE_USERS_SQL = "update users set login = ?,pwd= ? where id = ?;";

		public Utilisateur_bd() {
		}

		public void insertUser(Utilisateur user) throws SQLException {
			System.out.println(INSERT_USERS_SQL);
			try (Connection connection = DBUtil.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
				
				preparedStatement.setString(1, user.getIdutilisateur());
				preparedStatement.setString(2, user.getNom());
				preparedStatement.setString(3, user.getPrenom());
				preparedStatement.setString(4, user.getLogin());
				preparedStatement.setString(5, user.getPwd());
				preparedStatement.setString(6, user.getRole());
				
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				printSQLException(e);
			}
		}

		public Utilisateur selectUser(int id) {
			Utilisateur user = null;
			try (Connection connection = DBUtil.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
				preparedStatement.setInt(1, id);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					String idutilisateur = rs.getString("idutilisateur");
					String nom = rs.getString("nom");
					String prenom = rs.getString("prenom");
					String login = rs.getString("login");
					String pwd = rs.getString("pwd");
					String role = rs.getString("role");
					user = new Utilisateur(idutilisateur,nom,prenom, login, pwd,role);
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return user;
		}

		public List<Utilisateur> selectAllUsers() {

			List<Utilisateur> users = new ArrayList<>();
			try (Connection connection = DBUtil.getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					String idutilisateur = rs.getString("idutlisateur");
					String nom = rs.getString("nom");
					String prenom = rs.getString("prenom");
					String login = rs.getString("login");
					String pwd = rs.getString("pwd");
					String role = rs.getString("role");
					
					users.add(new Utilisateur(idutilisateur,nom,prenom,login,pwd,role));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return users;
		}

		public boolean deleteUser(int id) throws SQLException {
			boolean rowDeleted;
			try (Connection connection = DBUtil.getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
				statement.setInt(1, id);
				rowDeleted = statement.executeUpdate() > 0;
			}
			return rowDeleted;
		}

		public boolean updateUser(Utilisateur user) throws SQLException {
			boolean rowUpdated;
			try (Connection connection = DBUtil.getConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
				statement.setString(1, user.getIdutilisateur());
				statement.setString(2, user.getNom());
				statement.setString(3, user.getPrenom());
				statement.setString(3, user.getLogin());
				statement.setString(4, user.getPwd());
				statement.setString(5, user.getRole());

				rowUpdated = statement.executeUpdate() > 0;
			}
			return rowUpdated;
		}

		public static boolean validate(Utilisateur user)  {
			boolean status = false;

			//Class.forName("com.mysql.jdbc.Driver");

			try (Connection connection = DBUtil.getConnection();

					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection
							.prepareStatement("select * from users where login = ? and pwd = ? ")) {
				preparedStatement.setString(1, user.getLogin());
				preparedStatement.setString(2, user.getPwd());

				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				status = rs.next();

			} catch (SQLException e) {
				// process sql exception
				e.printStackTrace();
			}
			return status;
		}
		
		private void printSQLException(SQLException ex) {
			for (Throwable e : ex) {
				if (e instanceof SQLException) {
					e.printStackTrace(System.err);
					System.err.println("SQLState: " + ((SQLException) e).getSQLState());
					System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
					System.err.println("Message: " + e.getMessage());
					Throwable t = ex.getCause();
					while (t != null) {
						System.out.println("Cause: " + t);
						t = t.getCause();
					}
				}
			}
		}

	

	}

