package projet;

public class Reservation {
	private String idreservation ;
	private String date_reservation;
	private String statut;
	private String idutilisateur ;
	private String idlivre;
	public Reservation(String id,String date,String statut,String idutilisateur,String idlivre) {
		this.idreservation=id;
		this.date_reservation=date;
		this.statut=statut;
		this.idutilisateur=idutilisateur ;
		this.idlivre=idlivre;
		
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
	public String getIdutilisateur() {
		return idutilisateur;
	}
	public void setIdutilisateur(String idutilisateur) {
		this.idutilisateur = idutilisateur;
	}
	public String getIdlivre() {
		return idlivre;
	}
	public void setIdlivre(String idlivre) {
		this.idlivre = idlivre;
	}
	

}
