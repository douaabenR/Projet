package projet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class biblo {
	public void Authentifcation (Utilisateur user) {
		 Boolean authentifier =Utilisateur_bd.validate(user); 
		 if (authentifier)
			 System.out.println("connecter avec succes");
		 else 
			 System.out.println("username ou mot de passe incorrect");
			
	}
	public void consulter() {
		List<Livre> livres = livre_bd.selectAlllivre();
        for (Livre livre : livres) {
        	System.out.println("ID Livre: " + livre.getIdlivre());
            System.out.println("Titre: " + livre.getTitre());
        }

	}
	public void rechercherlivre(String titre) {
		Livre livre = livre_bd.selectByTitrelivre(titre);
		System.out.println("ID Livre: " + livre.getIdlivre());
        System.out.println("Titre: " + livre.getTitre());

	}
	public void affichedetails(String id) {
		Livre livre = livre_bd.selectlivre(id);
		System.out.println("ID Livre: " + livre.getIdlivre());
        System.out.println("Titre: " + livre.getTitre());
        System.out.println("Auteur: " + livre.getAuteur());
        System.out.println("Genre: " + livre.getGenre());
        System.out.println("Disponibilité: " + livre.getDisponibilite());
        System.out.println("--------------");
    }

	
	public void gestionemprunt(Emprunt emprunt) {

		Livre livre = livre_bd.selectlivre(emprunt.getIdLivre());
		if (livre.getDisponibilite().equals("disponible")) {
			Emprunt_bd.insertemprunt(emprunt);
			livre.setDisponibilite("Reserver");
			try {
				livre_bd.updateLivre(livre);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println("Livre réservée avec succès!");
		}
		
		
		
		
        //String query = "SELECT * FROM Emprunt WHERE id_utilisateur = ?";
        List<Emprunt> emprunts = Emprunt_bd.selectAllemprunt();
        for (Emprunt empr : emprunts) {
        	System.out.println("ID emprunt " + empr.getIdemprunt());
            System.out.println("date de retour : " + empr.getDateretour());
            System.out.println("date de emprunt " + empr. getDate_emprunt());
    		System.out.println("ID Livre: " + empr.getIdLivre());
            System.out.println("--------------");
        }
       // System.out.println("ID utlisateur: " +Utilisateur.getIdutilisateur());
        System.out.println("ID emprunt " + emprunt.getIdemprunt());
        System.out.println("date de retour : " + emprunt.getDateretour());
        System.out.println("date de emprunt " + emprunt. getDate_emprunt());
		System.out.println("ID Livre: " + livre.getIdlivre());
        System.out.println("--------------");
	}

	public void reservation() {
		if (!Livre.isDisponible()) {
            
		//String reservationQuery = "INSERT INTO Reservation (id_utilisateur, id_livre, date_reservation, statut) VALUES (?, ?, ?, 'en attente')";
			
			Reservation reservation=Reservation_bd.insertReservation(reservation);
			
			System.out.println("Livre réservé avec succès!");}
	
        else {
                System.out.println("Le livre est déjà disponible. Aucune réservation nécessaire.");
            }
		 //String query = "SELECT * FROM Reservation WHERE id_utilisateur=?";
				Reservation reservation1=Reservation_bd.selectReservation(id);
	}
	public void consultationhistorisque() {
		String query = "SELECT livre.titre, Emprunt.date_emprunt, Emprunt.date_retour, Emprunt.statut " +
                "FROM emprunt " +
                "INNER JOIN Livre ON Emprunt.id_livre = Livre.id_livre " +
                "WHERE Emprunt.id_utilisateur = ?";	
		try (Connection connection = DBUtil.getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				

				while (rs.next()) {
					System.out.print("|"+rs.getString("titre")+"|");
					System.out.print(rs.getString("date_emprunt"));
					System.out.print(rs.getString("date_retour"));
					System.out.print(rs.getString("statut"));
					System.out.print("/n");
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	 public static void envoyerRappelBibliothecaire() {
	        System.out.println("Rappel : Les retours de livres sont attendus. Veuillez vérifier l'état de la bibliothèque.");
	    }
	 
	 
	 
	 
	 public static void genererRapportLivresPlusEmpruntes() {
	        String query = "SELECT Livre.id_livre, Livre.titre, COUNT(Emprunt.id_emprunt) AS nombre_emprunts " +
	                       "FROM Livre " +
	                       "LEFT JOIN Emprunt ON Livre.id_livre = Emprunt.id_livre " +
	                       "GROUP BY Livre.id_livre " +
	                       "ORDER BY nombre_emprunts DESC " +
	                       "LIMIT 10"; 
	        
	        
	        try (Connection connection = DBUtil.getConnection();

					PreparedStatement preparedStatement = connection.prepareStatement(query);) {
					System.out.println(preparedStatement);
					ResultSet rs = preparedStatement.executeQuery();
					

					while (rs.next()) {
						System.out.print("|"+rs.getString("id_livre")+"|");
						System.out.print(rs.getString("titre"));
						System.out.print(rs.getString("nombre_emprunts"));
						System.out.print("/n");
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	 
	 }
	 

	
	
	
}
