package daos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import dao.DemandeDao;
import dao.TypeDao;
import modele.Clients;
import modele.Demande;
import modele.Type;

class DemandeDaoTest {

	@Test
	void testCreate() {
		// Bloc arrange
		Demande newDemande = new Demande();

		// ces id doivent exister pour tester le code attention
		Type newType = new Type();
		newType.setId_type(6);
		Clients newClient = new Clients();
		newClient.setId_personne(7);

		newDemande.setType(newType);
		newDemande.setClient(newClient);
		newDemande.setDate(null);
		newDemande.setHeure(null);
		newDemande.setDuree(null);

		// Bloc act
		DemandeDao newDemandeDao = new DemandeDao();

		// Bloc assert
		assertTrue(newDemandeDao.Create(newDemande));
	}

	@Test
	void testRead() {

		// Bloc arrange
		DemandeDao newDemandeDao = new DemandeDao();

		// Bloc act
		newDemandeDao.Read();

		// Bloc assert
		assertNotNull(newDemandeDao.Read());
	}

	@Test
	void testUpdate() {
		// Bloc arrange
		DemandeDao newDemandeDao = new DemandeDao();
		Demande newDemande = new Demande();

		// Bloc act
		newDemandeDao.Update(newDemande);

		// Bloc assert
		assertFalse(newDemandeDao.Update(newDemande));
	}

	@Test
	void testDelete() {
		// Bloc arrange
		DemandeDao newDemandeDao = new DemandeDao();
		//ne necessite pas forcément de donné ici on test juste la fonction
		Demande newDemande = new Demande();
		newDemande.setId_demande(35);

		// Bloc act
		newDemandeDao.Delete(newDemande);

		// Bloc assert
		assertTrue(newDemandeDao.Delete(newDemande));
	}

	@Test
	void testFindby() {
		// Bloc arrange
		DemandeDao newDemandeDao = new DemandeDao();
		Demande newDemande = new Demande();

		// Bloc act
		newDemandeDao.Findby(newDemande);

		// Bloc assert
		assertNull(newDemandeDao.Findby(newDemande));
	}

}
