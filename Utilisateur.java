package projet;

public class Utilisateur {
	private String idutilisateur;
	private String nom ;
	private String prenom ;
	private String login;
	private String pwd;
	public static String role;
public Utilisateur (String idutilisateur,String nom,String prenom,String login, String pwd,String role) {
    this.idutilisateur=idutilisateur ;
	this.nom=nom ;
	this.prenom=prenom ;
	this.login=login;
	this.pwd=pwd ;
	Utilisateur.role=role;
	
}
public String getIdutilisateur() {
	return idutilisateur;
}
public void setIdutilisateur(String idutilisateur) {
	this.idutilisateur = idutilisateur;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	Utilisateur.role = role;
}
@Override
public String toString() {
	return "Utilisateur [idutilisateur=" + idutilisateur + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login
			+ ", pwd=" + pwd + ", role=" + role + "]";
}
}