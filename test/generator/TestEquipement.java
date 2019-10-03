//package generator;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import app.model.Equipement;
//import app.model.enumeration.attaque.TypeAttaqueEnum;
//import app.model.enumeration.attribut.AttributsEnum;
//import app.model.enumeration.element.ElementEnum;
//import app.model.enumeration.objet.TypeRareteEnum;
//import app.model.enumeration.objet.equipement.arme.TypeArmeEnum;
//import app.model.enumeration.objet.equipement.arme.souscategorie.SousCategorieArmeEnum;
//import app.model.enumeration.objet.equipement.armure.TypeArmureEnum;
//import app.model.enumeration.objet.equipement.armure.souscategorie.SousCategorieArmureEnum;
//import app.model.enumeration.statistique.StatistiquesEnum;
//import app.model.objet.Arme;
//import app.model.objet.Armure;
//import util.DateUtile;
//
///**
// * @author Simon Strzelecki
// *
// */
//class TestEquipement {
//
//	private Equipement equipement = null;
//
//	final static Logger logger = Logger.getLogger(TestEquipement.class);
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//		// Set date for logging system
//		DateUtile dateUtile = new DateUtile();
//		// Set log-level for logging system
//		System.setProperty("logLevel", "DEBUG");
//		// Set Log4j properties
//		String log4jConfPath = "./ressources/log4j.properties";
//		PropertyConfigurator.configure(log4jConfPath);
//		logger.info("Start test Class : Equipement");
//	}
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//		logger.info("End test Class : Equipement");
//	}
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@BeforeEach
//	void setUp() throws Exception {
//
//		logger.info("START NEW TEST :");
//
//		Map<StatistiquesEnum, Integer> statistiques = new HashMap<StatistiquesEnum,Integer>();
//		Map<TypeAttaqueEnum, Integer> typeDefense = new HashMap<TypeAttaqueEnum, Integer>();
//		Map<ElementEnum, Integer> defenseElement = new HashMap<ElementEnum, Integer>();
//		Map<AttributsEnum, Integer> defenseAttribue = new HashMap<AttributsEnum, Integer>();
//
//		List<ElementEnum> element = new ArrayList<ElementEnum>();
//		List<AttributsEnum> attributs = new ArrayList<AttributsEnum>();
//		List<TypeAttaqueEnum> typeAttaque = new ArrayList<TypeAttaqueEnum>();
//
//		Armure tete = null;
//		Armure corps = null;
//		Armure mains = null;
//		Armure jambes = null;
//		Armure pieds = null;
//		Armure amulette = null;
//		Armure anneau = null;
//
//		Arme arme = null;
//
//		Armure[] anneaux = null;
//
//		Arme[] armes = null;
//
//		try {
//			tete = new Armure("Teste tete", "./test", "Description de teste", statistiques, 10, 10, TypeArmureEnum.TETE, typeDefense, defenseElement, defenseAttribue, SousCategorieArmureEnum.LOURDE, TypeRareteEnum.RARE, false, 10);
//		} catch (Exception e) {
//			logger.error("Erreur setUp : new Armure (tete)");
//		}
//		try {
//			corps = new Armure("Teste corps", "./test", "Description de teste", statistiques, 10, 10, TypeArmureEnum.CORPS, typeDefense, defenseElement, defenseAttribue, SousCategorieArmureEnum.LOURDE, TypeRareteEnum.RARE, false, 10);
//		} catch (Exception e) {
//			logger.error("Erreur setUp : new Armure (corps)");
//		}
//		try {
//			mains = new Armure("Teste mains", "./test", "Description de teste", statistiques, 10, 10, TypeArmureEnum.MAINS, typeDefense, defenseElement, defenseAttribue, SousCategorieArmureEnum.LOURDE, TypeRareteEnum.RARE, false, 10); 
//		} catch (Exception e) {
//			logger.error("Erreur setUp : new Armure (mains)");
//		} 
//		try {
//			jambes = new Armure("Teste jambes", "./test", "Description de teste", statistiques, 10, 10, TypeArmureEnum.JAMBES, typeDefense, defenseElement, defenseAttribue, SousCategorieArmureEnum.LOURDE, TypeRareteEnum.RARE, false, 10); 
//		} catch (Exception e) {
//			logger.error("Erreur setUp : new Armure (jambes)");
//		} 
//		try {
//			pieds = new Armure("Teste pieds", "./test", "Description de teste", statistiques, 10, 10, TypeArmureEnum.PIEDS, typeDefense, defenseElement, defenseAttribue, SousCategorieArmureEnum.LOURDE, TypeRareteEnum.RARE, false, 10);
//		} catch (Exception e) {
//			logger.error("Erreur setUp : new Armure (pieds)");
//		} 
//		try {
//			amulette = new Armure("Teste amulette", "./test", "Description de teste", statistiques, 10, 10, TypeArmureEnum.ACCESSOIRE, typeDefense, defenseElement, defenseAttribue, SousCategorieArmureEnum.AMULETTE, TypeRareteEnum.RARE, false, 10);
//		} catch (Exception e) {
//			logger.error("Erreur setUp : new Armure (amulette)");
//		} 
//		try {
//			anneau = new Armure("Teste anneau1", "./test", "Description de teste", statistiques, 10, 10, TypeArmureEnum.ACCESSOIRE, typeDefense, defenseElement, defenseAttribue, SousCategorieArmureEnum.ANNEAU, TypeRareteEnum.RARE, false, 10);
//		} catch (Exception e) {
//			logger.error("Erreur setUp : new Armure (anneau)");
//		} 
//		try {
//			arme = new Arme("Teste arme1", "./test", "Description de teste", statistiques, element, attributs, 10, 15, TypeArmeEnum.DAGUE, typeAttaque, SousCategorieArmeEnum.LEGER, TypeRareteEnum.RARE, false, 10);
//		} catch (Exception e) {
//			logger.error("Erreur setUp : new Arme (arme)");
//		} 
//
//		try {
//			anneaux = new Armure[Equipement.getMaxAnneaux()]; 
//			anneaux[0]=anneau;
//			anneaux[1]=anneau;
//		} catch (Exception e) {
//			logger.error("Erreur setUp : new Armure[equipement.getMaxAnneaux()]");
//		}
//		try {
//			armes = new Arme[Equipement.getMaxArmes()];
//			armes[0]=arme;
//			armes[1]=arme;
//		} catch (Exception e) {
//			logger.error("Erreur setUp : new Arme[equipement.getMaxArmes()]");
//		} 
//
//		try {
//			equipement = new Equipement(tete, corps, mains, jambes, pieds, anneaux, amulette, armes);
//		} catch (Exception e) {
//			logger.error("Erreur setUp : new Equipement(tete, corps, mains, jambes, pieds, anneaux, amulette, armes)");
//		}
//	}
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@AfterEach
//	void tearDown() throws Exception {
//		equipement = null;
//		logger.info("END TEST :");
//	}
//
//
//	/**
//	 * Test method for {@link app.model.Equipement#Equipement()}.
//	 */
//	@Test
//	void testEquipement() {
//
//		equipement = null;
//
//		try {
//			equipement = new Equipement();
//		} catch (Exception e) {
//			logger.info("Erreur testEquipement : new Equipement()");
//		}
//
//		assertTrue(equipement != null, "Erreur sur l'initialisation a vide");
//	}
//
//	/**
//	 * Test method for {@link app.model.Equipement#Equipement(app.model.objet.Armure, app.model.objet.Armure, app.model.objet.Armure, app.model.objet.Armure, app.model.objet.Armure, app.model.objet.Armure[], app.model.objet.Armure, app.model.objet.Arme[])}.
//	 */
//	@Test
//	void testEquipementArmureArmureArmureArmureArmureArmureArrayArmureArmeArray() {
//		assertFalse(equipement == null, "Erreur sur l'initialisation");
//	}
//
//	/**
//	 * Test method for {@link app.model.Equipement#getArme(int)}.
//	 */
//	@Test
//	void testGetArme() {
//		assertFalse(equipement.getArme(0) == null, "Erreur sur testGetArme");
//	}
//
//	/**
//	 * Test method for {@link app.model.Equipement#getAnneau(int)}.
//	 */
//	@Test
//	void testGetAnneau() {
//		assertFalse(equipement.getAnneau(0) == null, "Erreur sur testGetAnneau");
//	}
//
//}