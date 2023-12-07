package projet;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class livre_bd {
	   private static final String INSERT_livre_SQL = "INSERT INTO livre" + "  (idlivre,titre, auteur,genre,disponibilite ) VALUES "
				+ " (?, ?,?,?,?);";

		private static final String SELECT_livre_BY_ID = "select idlivre,titre,auteur,genre from livre where id =?";
		private static final String SELECT_ALL_livre = "select * from livre";
		//private static final String UPDATE_livre_SQL = "UPDATE livre SET idlivre = ?, titre = ? WHERE id = ?;";
		private static final String DELETE_livre_SQL = "delete from livre where id = ?;";

		public livre_bd() {
		}

		public void insertlivre(Livre livre) throws SQLException {
			System.out.println(INSERT_livre_SQL);
			try (Connection connection = DBUtil.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_livre_SQL)) {
				preparedStatement.setString(1, livre.getIdlivre());
				preparedStatement.setString(2, livre.getTitre());
				preparedStatement.setString(3, livre.getAuteur());
				preparedStatement.setString(4, livre.getGenre());
				preparedStatement.setString(5, livre.getDisponibilite());

				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
				System.out.print("Livre ajoutée avec succes");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		

		public static Livre selectlivre(String id) {
			Livre livre = null;
			try (Connection connection = DBUtil.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_livre_BY_ID);) {
				preparedStatement.setString(1, id);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					String idlivre=rs.getString("idlivre");
					String titre = rs.getString("titre");
					String auteur= rs.getString("auteur");
					String genre =rs.getString("genre);");
					String disponiblilite=rs.getString("disponiblite");
						
					livre = new Livre(idlivre , titre, auteur,genre,disponiblilite);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();;
			}
			return livre;
		}
		public static Livre selectByTitrelivre(String tit) {
			Livre livre = null;
			try (Connection connection = DBUtil.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_livre_BY_ID);) {
				preparedStatement.setString(1, tit);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					String idlivre=rs.getString("idlivre");
					String titre = rs.getString("titre");
					String auteur= rs.getString("auteur");
					String genre =rs.getString("genre);");
					String disponiblilite=rs.getString("disponiblite");
						
					livre = new Livre(idlivre , titre, auteur,genre,disponiblilite);
					
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();;
			}
			return livre;
		}

		public static List<Livre> selectAlllivre() {

			List<Livre> livres = new ArrayList<>();
			try (Connection connection = DBUtil.getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_livre);) {
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					String idlivre = rs.getString("idlivre");
					String auteur = rs.getString("auteur");
					String titre  = rs.getString("titre");
					livres.add(new Livre(idlivre, titre, auteur,null,null));
				}
			} catch (SQLException e) {
				e.printStackTrace();;
			}
			return livres;
		}

		public boolean deletelivre(String idLivre) throws SQLException {
			boolean rowDeleted;
			try (Connection connection = DBUtil.getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_livre_SQL);) {
				statement.setString(1, idLivre);
				rowDeleted = statement.executeUpdate() > 0;
			}
			return rowDeleted;
		}

		public static boolean updateLivre(Livre livre) throws SQLException {
			boolean rowUpdated;
			try (Connection connection = DBUtil.getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_livre_SQL);) {
				statement.setString(1, livre.getIdlivre());
				statement.setString(2, livre.getAuteur());
				statement.setString(3, livre.getGenre());
				statement.setString(4, livre.getTitre());
				statement.setString(5, livre.getDisponibilite());
				
				rowUpdated = statement.executeUpdate() > 0;
			}
			return rowUpdated;
		}

	}	