package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.security.crypto.bcrypt.BCrypt;

import modele.ConnectionBDD;
import modele.Utilisateur;

public class UtilisateurDao implements Interface <Utilisateur> {
	Connection connect = new ConnectionBDD().getConnection();

	@SuppressWarnings("static-access")
	@Override
	public boolean Create(Utilisateur object) {
		// TODO Auto-generated method stub
		
		//encoder le mot de passe avant l'entré en BDD
				BCrypt encoder = new BCrypt();
				object.setPassword(encoder.hashpw(object.getPassword(), BCrypt.gensalt()));
				
				try {
					PreparedStatement sql = connect.prepareStatement("INSERT INTO utilisateur(nom,prenom,email,password) VALUES(?,?,?,?)");
					
					sql.setString(1, object.getNom());
					sql.setString(2, object.getPrenom());
					sql.setString(3, object.getEmail());
					sql.setString(4, object.getPassword());

					sql.executeUpdate();
					System.out.println("utilisateur créé");
					return true;
				} catch (Exception e) {
					// TODO: handle exception
					e.getMessage();
				}
				return false;
	}

	@Override
	public ArrayList<Utilisateur> Read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Update(Utilisateur object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(Utilisateur object) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("static-access")
	@Override
	public ArrayList<Utilisateur> Findby(Utilisateur object) {
		// TODO Auto-generated method stub
BCrypt encoder = new BCrypt();
		
		ArrayList<Utilisateur> userstab= new ArrayList<Utilisateur>();
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM utilisateur where email=? AND isActive_personne=?");
			
			sql.setString(1, object.getEmail());
			sql.setInt(2,1);
			
		
			ResultSet rs=sql.executeQuery();
			if(rs.next()) {
				
				//tester (si il correspond ou pas à ce qui est en BDD) le hash avec checkpw
				if(encoder.checkpw(object.getPassword(),rs.getString("password"))) {
					
				// Créer un user
				Utilisateur user= new Utilisateur();
				user.setId_personne(rs.getInt("id_utilisateur"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setIsActive_personne(rs.getInt("isActive_personne"));
				
				//ajouter le user au tableau
				userstab.add(user);
				}
			}	
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return userstab;
	}

}
