package test.unitary.generator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

import app.model.Equipement;
import app.model.enumeration.attaque.TypeAttaqueEnum;
import app.model.enumeration.attribut.AttributsEnum;
import app.model.enumeration.element.ElementEnum;
import app.model.enumeration.objet.TypeRareteEnum;
import app.model.enumeration.objet.equipement.arme.TypeArmeEnum;
import app.model.enumeration.objet.equipement.arme.souscategorie.SousCategorieArmeEnum;
import app.model.enumeration.objet.equipement.armure.TypeArmureEnum;
import app.model.enumeration.objet.equipement.armure.souscategorie.SousCategorieArmureEnum;
import app.model.enumeration.statistique.StatistiquesEnum;
import app.model.objet.Arme;
import app.model.objet.Armure;

/**
 * @author Simon Strzelecki
 *
 */
class TestEquipement {

	private Equipement equipement = null;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Start test Class : Equipement\n");
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("End test Class : Equipement\n");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		System.out.println("\nSTART NEW TEST :\n");

		Map<StatistiquesEnum, Integer> statistiques = new HashMap<StatistiquesEnum,Integer>();
		Map<TypeAttaqueEnum, Integer> typeDefense = new HashMap<TypeAttaqueEnum, Integer>();
		Map<ElementEnum, Integer> defenseElement = new HashMap<ElementEnum, Integer>();
		Map<AttributsEnum, Integer> defenseAttribue = new HashMap<AttributsEnum, Integer>();
		
		List<ElementEnum> element = new ArrayList<ElementEnum>();
		List<AttributsEnum> attributs = new ArrayList<AttributsEnum>();
		List<TypeAttaqueEnum> typeAttaque = new ArrayList<TypeAttaqueEnum>();

		Armure tete = null;
		Armure corps = null;
		Armure mains = null;
		Armure jambes = null;
		Armure pieds = null;
		Armure amulette = null;
		Armure anneau = null;
		
		Arme arme = null;
		
		Armure[] anneaux = null;
		
		Arme[] armes = null;
		
		try {
			tete = new Armure("Teste tete", "./test", "Description de teste", statistiques, 10, 10, TypeArmureEnum.TETE, typeDefense, defenseElement, defenseAttribue, SousCategorieArmureEnum.LOURDE, TypeRareteEnum.RARE, false, 10);
		} catch (Exception e) {
			System.out.println("Erreur setUp : new Armure (tete)\n");
		}
		try {
			corps = new Armure("Teste corps", "./test", "Description de teste", statistiques, 10, 10, TypeArmureEnum.CORPS, typeDefense, defenseElement, defenseAttribue, SousCategorieArmureEnum.LOURDE, TypeRareteEnum.RARE, false, 10);
		} catch (Exception e) {
			System.out.println("Erreur setUp : new Armure (corps)\n");
		}
		try {
			mains = new Armure("Teste mains", "./test", "Description de teste", statistiques, 10, 10, TypeArmureEnum.MAINS, typeDefense, defenseElement, defenseAttribue, SousCategorieArmureEnum.LOURDE, TypeRareteEnum.RARE, false, 10); 
		} catch (Exception e) {
			System.out.println("Erreur setUp : new Armure (mains)\n");
		} 
		try {
			jambes = new Armure("Teste jambes", "./test", "Description de teste", statistiques, 10, 10, TypeArmureEnum.JAMBES, typeDefense, defenseElement, defenseAttribue, SousCategorieArmureEnum.LOURDE, TypeRareteEnum.RARE, false, 10); 
		} catch (Exception e) {
			System.out.println("Erreur setUp : new Armure (jambes)\n");
		} 
		try {
			pieds = new Armure("Teste pieds", "./test", "Description de teste", statistiques, 10, 10, TypeArmureEnum.PIEDS, typeDefense, defenseElement, defenseAttribue, SousCategorieArmureEnum.LOURDE, TypeRareteEnum.RARE, false, 10);
		} catch (Exception e) {
			System.out.println("Erreur setUp : new Armure (pieds)\n");
		} 
		try {
			amulette = new Armure("Teste amulette", "./test", "Description de teste", statistiques, 10, 10, TypeArmureEnum.ACCESSOIRE, typeDefense, defenseElement, defenseAttribue, SousCategorieArmureEnum.AMULETTE, TypeRareteEnum.RARE, false, 10);
		} catch (Exception e) {
			System.out.println("Erreur setUp : new Armure (amulette)\n");
		} 
		try {
			anneau = new Armure("Teste anneau1", "./test", "Description de teste", statistiques, 10, 10, TypeArmureEnum.ACCESSOIRE, typeDefense, defenseElement, defenseAttribue, SousCategorieArmureEnum.ANNEAU, TypeRareteEnum.RARE, false, 10);
		} catch (Exception e) {
			System.out.println("Erreur setUp : new Armure (anneau)\n");
		} 
		try {
			arme = new Arme("Teste arme1", "./test", "Description de teste", statistiques, element, attributs, 10, 15, TypeArmeEnum.DAGUE, typeAttaque, SousCategorieArmeEnum.LEGER, TypeRareteEnum.RARE, false, 10);
		} catch (Exception e) {
			System.out.println("Erreur setUp : new Arme (arme)\n");
		} 
		
		try {
			 anneaux = new Armure[Equipement.getMaxAnneaux()]; 
			 anneaux[0]=anneau;
			 anneaux[1]=anneau;
		} catch (Exception e) {
			System.out.println("Erreur setUp : new Armure[equipement.getMaxAnneaux()]\n");
		}
		try {
			armes = new Arme[Equipement.getMaxArmes()];
			armes[0]=arme;
			armes[1]=arme;
		} catch (Exception e) {
			System.out.println("Erreur setUp : new Arme[equipement.getMaxArmes()]\n");
		} 

		try {
			equipement = new Equipement(tete, corps, mains, jambes, pieds, anneaux, amulette, armes);
		} catch (Exception e) {
			System.out.println("Erreur setUp : new Equipement(tete, corps, mains, jambes, pieds, anneaux, amulette, armes)\n");
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		equipement = null;
		System.out.println("END TEST :\n");
	}


	/**
	 * Test method for {@link app.model.Equipement#Equipement()}.
	 */
	@Test
	void testEquipement() {

		equipement = null;

		try {
			equipement = new Equipement();
		} catch (Exception e) {
			System.out.println("Erreur testEquipement : new Equipement()\n");
		}
		
		assertTrue("Erreur sur l'initialisation a vide", equipement != null);
	}

	/**
	 * Test method for {@link app.model.Equipement#Equipement(app.model.objet.Armure, app.model.objet.Armure, app.model.objet.Armure, app.model.objet.Armure, app.model.objet.Armure, app.model.objet.Armure[], app.model.objet.Armure, app.model.objet.Arme[])}.
	 */
	@Test
	void testEquipementArmureArmureArmureArmureArmureArmureArrayArmureArmeArray() {
		assertFalse("Erreur sur l'initialisation", equipement == null);
	}

	/**
	 * Test method for {@link app.model.Equipement#getArme(int)}.
	 */
	@Test
	void testGetArme() {
		assertFalse("Erreur sur testGetArme", equipement.getArme(0) == null);
	}

	/**
	 * Test method for {@link app.model.Equipement#getAnneau(int)}.
	 */
	@Test
	void testGetAnneau() {
		assertFalse("Erreur sur testGetAnneau", equipement.getAnneau(0) == null);
	}

}
