package projet;

	
	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	public class Reservation_bd {

	    private static final String INSERT_RESERVATION_SQL = "INSERT INTO reservation" +
	            "  (idreservation ,date_reservation , statut) VALUES " +
	            " (?,?,?);";

	    private static final String SELECT_RESERVATION_BY_ID = "SELECT date_reservation,statut FROM reservation WHERE id = ?";
	    private static final String SELECT_ALL_RESERVATION = "SELECT * FROM reservation";
	    private static final String DELETE_RESERVATION_SQL = "DELETE FROM reservation WHERE id = ?";
	    private static final String UPDATE_RESERVATION_SQL = "UPDATE reservation SET  date_reservation=? statut =? WHERE id = ?";

	    public Reservation_bd() {
	    }

	    public void insertReservation(Reservation resv) throws SQLException {
	        System.out.println(INSERT_RESERVATION_SQL);
	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RESERVATION_SQL)) {
	            preparedStatement.setString(1, resv.getDate_reservation());
	            preparedStatement.setString(2, resv.getIdreservation());
	            preparedStatement.setString(3, resv.getStatut());


	            
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	    }

	    public Reservation selectReservation(int id) {
	        Reservation resv = null;
	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RESERVATION_BY_ID)) {
	            preparedStatement.setInt(1, id);
	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	                String idreservation = rs.getString("idreservation");
	                String date_reservation = rs.getString("date_reservation");
	                String statut = rs.getString("statut");

	                resv = new Reservation(idreservation, date_reservation, statut);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return resv;
	    }

	    public List<Reservation> selectAllReservations() {
	        List<Reservation> reservations = new ArrayList<>();
	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RESERVATION)) {
	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	                String idreservation= rs.getString("idreservation");
	            	String date_reservation = rs.getString("date_reservation");
	            	String statut = rs.getString("statut");

	                reservations.add(new Reservation(idreservation, date_reservation,statut));
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return reservations;
	    }

	    public boolean deleteReservation(int id) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement statement = connection.prepareStatement(DELETE_RESERVATION_SQL)) {
	            statement.setInt(1, id);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }

	    public boolean updateReservation(Reservation resv) throws SQLException {
	        boolean rowUpdated;
	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement statement = connection.prepareStatement(UPDATE_RESERVATION_SQL)) {
	            statement.setString(1, resv.getDate_reservation());
	            statement.setString(2, resv.getIdreservation());
	            statement.setString(3, resv.getStatut());


	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }

	   

	    private void printSQLException(SQLException e) {
	        // Implementation for printing SQL exceptions
	    }
	}
	