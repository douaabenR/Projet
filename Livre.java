package projet;

public class Livre {
	private String idlivre;
	private String titre ;
	private String auteur ;
	private String genre ;
	private String disponibilite ;
	
public Livre(String id, String tit , String aut,String gen ,String dispo) {
	this.idlivre=id;
	this.titre=tit;
	this.auteur=aut;
	this.genre=gen;
	this.disponibilite=dispo;

	
}

public String getIdlivre() {
	return idlivre;
}

public void setIdlivre(String idlivre) {
	this.idlivre = idlivre;
}

public String getTitre() {
	return titre;
}

public void setTitre(String titre) {
	this.titre = titre;
}

public String getAuteur() {
	return auteur;
}

public void setAuteur(String auteur) {
	this.auteur = auteur;
}

public String getGenre() {
	return genre;
}

public void setGenre(String genre) {
	this.genre = genre;
}

public String getDisponibilite() {
	return disponibilite;
}

public void setDisponibilite(String disponibilite) {
	this.disponibilite = disponibilite;
}

@Override
public String toString() {
	return "Livre [idlivre=" + idlivre + ", titre=" + titre + ", auteur=" + auteur + ", genre=" + genre
			+ ", disponibilite=" + disponibilite + "]";
}
}