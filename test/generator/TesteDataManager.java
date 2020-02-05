/**
 * 
 */
package generator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

import app.model.Equipement;
import app.model.enumeration.CategorieEnum;
import app.model.enumeration.attaque.TypeAttaqueEnum;
import app.model.enumeration.attribut.AttributsEnum;
import app.model.enumeration.element.ElementEnum;
import app.model.enumeration.objet.TypeRareteEnum;
import app.model.enumeration.objet.equipement.armure.TypeArmureEnum;
import app.model.enumeration.objet.equipement.armure.souscategorie.SousCategorieArmureEnum;
import app.model.enumeration.statistique.StatistiquesEnum;
import app.model.objet.Armure;
import util.DataManager;
import util.DateUtile;

/**
 * @author simon
 *
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TesteDataManager {

	final static Logger logger = Logger.getLogger(TesteDataManager.class);
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		// Set date for logging system
		DateUtile dateUtile = new DateUtile();
		// Set log-level for logging system
		System.setProperty("logLevel", "DEBUG");
		// Set Log4j properties
		String log4jConfPath = "./ressources/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		logger.info("Start test Class : DataManager");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		logger.info("End test Class : DataManager");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		logger.info("START NEW TEST :");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		logger.info("END TEST :");
	}

	@Test
	@Order(2) 
	void testSaveing() {
		
		Map<StatistiquesEnum, Integer> statistiques = new HashMap<StatistiquesEnum,Integer>();
		Map<TypeAttaqueEnum, Integer> typeDefense = new HashMap<TypeAttaqueEnum, Integer>();
		Map<ElementEnum, Integer> defenseElement = new HashMap<ElementEnum, Integer>();
		Map<AttributsEnum, Integer> defenseAttribue = new HashMap<AttributsEnum, Integer>();
		
		Armure tete = new Armure("Teste tete", "./test", "Description de teste", statistiques, 10, 10, TypeArmureEnum.TETE, typeDefense, defenseElement, defenseAttribue, SousCategorieArmureEnum.LOURDE, TypeRareteEnum.RARE, false, 10);
		
		try {
			DataManager.saveData(tete, "./ressources/Data/Object/Equipement/Armor/", "JuniteTest");	
			
			logger.debug("Object successful load : "+tete.getNom());
		} catch (Exception e) {
			fail("fail saveing");
		}
		
		
		
	}
	
	@Test
	@Order(3) 
	void testLoading() {
		
		Armure tete = null;
		
		tete = (Armure)DataManager.loadData(Armure.class, "./ressources/Data/Object/Equipement/Armor/", "JuniteTest");
		
		assertTrue(tete != null, "Erreur sur le chargement");
	}
	
	@Test
	@Order(1) 
	void testPath() {
		
		CategorieEnum categorieEnum = CategorieEnum.ARMURE;
		
		try {
			assertTrue(DataManager.pathConstructor(categorieEnum).equals("./ressources/Data/Object/Equipement/Armor/"), "Erreur sur le Path");
		} catch (Exception e) {
			fail("fail to find Path");
			e.printStackTrace();
		}
	}
	
	@Test
	@Order(4) 
	void testDelete() {
		
		try {
			DataManager.deleteFile("./ressources/Data/Object/Equipement/Armor/", "JuniteTest");
		} catch (Exception e) {
			fail("fail to delete file");
			e.printStackTrace();
		}
	}

}
