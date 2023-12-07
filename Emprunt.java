package projet;


public class Emprunt {
    private String idemprunt;
    private String date_emprunt;
    private String date_retour;
    private String statut;
    private String idLivre;

    public Emprunt(String id, String date, String dateretour, String statut, String idLivre) {
        this.idemprunt = id;
        this.date_emprunt = date;
        this.date_retour = dateretour;
        this.statut = statut;
        this.idLivre = idLivre ;
    }

    public String getDate_retour() {
		return date_retour;
	}

	public void setDate_retour(String date_retour) {
		this.date_retour = date_retour;
	}

	public String getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(String idLivre) {
		this.idLivre = idLivre;
	}

	public String getIdemprunt() {
        return idemprunt;
    }

    public void setIdemprunt(String idemprunt) {
        this.idemprunt = idemprunt;
    }

    public String getDate_emprunt() {
        return date_emprunt;
    }

    public void setDate_emprunt(String date_emprunt) {
        this.date_emprunt = date_emprunt;
    }

    public String getDateretour() {
        return date_retour;
    }

    public void setDateretour(String dateretour) {
        this.date_retour = dateretour;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Emprunt [idemprunt=" + idemprunt + ", date_emprunt=" + date_emprunt + ", dateretour=" + date_retour
                + ", statut=" + statut + "]";
    }
}