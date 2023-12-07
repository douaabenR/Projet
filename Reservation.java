package projet;

public class Reservation {
	private String idreservation ;
	private String date_reservation;
	private String statut;
	public Reservation(String id,String date,String statut) {
		this.idreservation=id;
		this.date_reservation=date;
		this.statut=statut;
		
	}
	public String getIdreservation() {
		return idreservation;
	}
	public void setIdreservation(String idreservation) {
		this.idreservation = idreservation;
	}
	public String getDate_reservation() {
		return date_reservation;
	}
	public void setDate_reservation(String date_reservation) {
		this.date_reservation = date_reservation;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	

}
