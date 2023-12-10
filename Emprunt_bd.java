package projet;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class Emprunt_bd {
	   private static final String INSERT_emprunt_SQL = "INSERT INTO emprunts" + "  ((idemprunt,date_emprunt,date_retour,statut) VALUES "
				+ " (?,?,?,?,?,?);";

		private static final String SELECT_emprunt_BY_ID = "select idemprunt,date_emprunt,date_retour,statut from Emprunt where idemprunt =?";
		private static final String SELECT_ALL_Emprunt = "select * from Emprunt";
		private static final String DELETE_Emprunt_SQL = "delete from Emprunt where idemprunt = ?;";

		public Emprunt_bd() {
		}

		public static void insertemprunt(Emprunt emprunt) {
			System.out.println(INSERT_emprunt_SQL);
			try (Connection connection = DBUtil.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_emprunt_SQL)) {
				preparedStatement.setString(1, emprunt.getIdemprunt());
				preparedStatement.setString(2, emprunt.getDate_emprunt());
				preparedStatement.setString(3, emprunt.getDateretour());
				preparedStatement.setString(4, emprunt.getStatut());
				preparedStatement.setString(5, emprunt.getIdutilisateur());
				preparedStatement.setString(6, emprunt.getIdLivre());
				
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		public Emprunt selectemprunt(String idemprunt) {
			Emprunt emprunt = null;
			try (Connection connection = DBUtil.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_emprunt_BY_ID);) {
				preparedStatement.setString(1, idemprunt);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					String idemprunt1= rs.getString("idemprunt");
					String date_emprunt = rs.getString("date_emprunt");
					String date_retour= rs.getString("date_retour");
					String statut= rs.getString("statut");
					String idutilisateur= rs.getString("idutilisateur");
					String idlivre= rs.getString("idlivre");
					
					emprunt = new Emprunt(idemprunt1, date_emprunt,date_retour,statut,idutilisateur,idlivre );
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return emprunt;
		}

		public static List<Emprunt> selectAllemprunt() {

			List<Emprunt> emprunts = new ArrayList<>();
			try (Connection connection = DBUtil.getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Emprunt);) {
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				

				while (rs.next()) {
					String  idemprunt= rs.getString("id_emprunt");
					String date_emprunt = rs.getString("date_emprunt");
					String date_retour= rs.getString("date_retour");
					String statut= rs.getString("statut");
					String idutilisateur= rs.getString("idutilisateur");
					String idlivre= rs.getString("idlivre");
					
					emprunts.add(new Emprunt(idemprunt, date_emprunt,date_retour,statut,idutilisateur,idlivre));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return emprunts;
		}

		
		
	public boolean deleteemprunt(String idemprunt) throws SQLException {
			boolean rowDeleted;
			try (Connection connection = DBUtil.getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_Emprunt_SQL);) {
				statement.setString(1, idemprunt);
				rowDeleted = statement.executeUpdate() > 0;
			}
			return rowDeleted; }
	
}