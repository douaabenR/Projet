package projet;


import java.sql.Connection;

public class projet {

public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=DBUtil.getConnection();
			
		
		
		//Utilisateur utilisateur = new Utilisateur("1", "Ben fattoum", "Mahdi", "saif", "mahdi123", "admin");
		//Utilisateur utilisateur1 = new Utilisateur("10028191", "Ben Rejab", "Douaa", "douaabenrejab12345@gmail.com", "douaa2003","Etudiant"); 
		//Utilisateur utilisateur2= new Utilisateur("3", "Lassidi", "anas", "anas.@gmail", "anas123", "admin"); 
		Livre livre = new Livre("4050", "aa", "albert", "historique", "disponible");
		try { //Utilisateur_bd.insertUser(utilisateur1); 
			//	biblo.Authentifcation(utilisateur1);
			//biblo.consulter();
			//biblo.rechercherlivre("paris");
			//biblo.affichedetails("2");
			biblo.gestionemprunt(emprunt);
			//biblo.reservation(null, null);
			//biblo.consultationhistorisque();
			//biblo.envoyerRappelBibliothecaire();
			//biblo.genererRapportLivresPlusEmpruntes();
			
		}
		catch (Exception e) { 
			e.printStackTrace(); }}}
			
		

			
		
		
		  
	        //biblo.Authentifcation(null);
	        // Autentification de l'utilisateur
             // Classe gérant les opérations de la bibliothèque

					            // Demander les informations d'identification (login, mot de passe)
					            // Vérifier les informations dans la base de données et récupérer le rôle de l'utilisateur
					            // Selon le rôle, rediriger vers le menu correspondant (étudiant, enseignant, bibliothécaire)

