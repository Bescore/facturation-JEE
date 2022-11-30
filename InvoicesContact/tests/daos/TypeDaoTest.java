package daos;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.TypeDao;
import modele.Type;

class TypeDaoTest {

	@Test
	void testCreate() {
		//fail("Not yet implemented");
		
		// Bloc arrange
		Type newType=new Type();
		
		newType.setType_mission("jury afpa");
				
		// Bloc act
		TypeDao newTypeDao = new TypeDao();
				
		//Bloc assert
		assertTrue(	newTypeDao.Create(newType));
		
	}

	@Test
	void testRead() {
		//fail("Not yet implemented");
		
		// Bloc arrange
		TypeDao newTypeDao= new TypeDao();
		
		// Bloc act
		newTypeDao.Read();
		
		//Bloc assert
		assertNotNull(newTypeDao.Read());
	}

	@Test
	void testUpdate() {
		//fail("Not yet implemented");
		
		// Bloc arrange
		Type newType=new Type();
		
		newType.setId_type(0);
		newType.setType_mission("jury ");
						
		// Bloc act
		TypeDao newTypeDao = new TypeDao();
						
		//Bloc assert
		assertTrue(	newTypeDao.Create(newType));
	
		
	}

	@Test
	void testDelete() {
		//fail("Not yet implemented");
		
		// Bloc arrange
		Type newType=new Type();
		newType.setId_type(10);
				
		// Bloc act
		TypeDao newTypeDao= new TypeDao();
		
				
		//Bloc assert
		assertTrue(newTypeDao.Delete(newType));
	}

	@Test
	void testFindby() {
		//fail("Not yet implemented");
		
		// Bloc arrange
		Type newType=new Type();
			
		// Bloc act
		TypeDao newTypeDao= new TypeDao();
		newTypeDao.Findby(newType);
				
		//Bloc assert
		assertNull(newTypeDao.Findby(newType));
	}

}
