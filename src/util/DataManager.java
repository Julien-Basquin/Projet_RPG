package util;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter.OutputType;

import app.model.Base;
import app.model.entity.Entity;
import app.model.entity.SkillTree;
import app.model.enumeration.CategorieEnum;
import app.model.enumeration.attaque.TypeAttaqueEnum;
import app.model.enumeration.attribut.AttributsEnum;
import app.model.enumeration.element.ElementEnum;
import app.model.enumeration.objet.TypeRareteEnum;
import app.model.enumeration.objet.equipement.arme.TypeArmeEnum;
import app.model.enumeration.objet.equipement.arme.souscategorie.SousCategorieArmeEnum;
import app.model.enumeration.objet.equipement.armure.TypeArmureEnum;
import app.model.enumeration.objet.equipement.armure.souscategorie.SousCategorieArmureEnum;
import app.model.enumeration.statistique.StatistiquesEnum;
import app.model.magie.Magie;
import app.model.objet.Arme;
import app.model.objet.Armure;
import generateur.Generator;
import generateur.controller.select.SelectCategory;
import generateur.controller.select.StringSelectBox;
import generateur.view.entity_parameters.middle.EntityParametersGraph;

/**
 * Class for Save and Load data from Json file
 * @author simon
 *
 */
public class DataManager {

	/**
	 * Save data as Json file
	 * @param object		Object to save
	 * @param path			Path of the folder to save
	 * @param fileName		Name of the file to save
	 */
	public static void saveData(Object object, String path, String fileName) {
		Logger logger = Logger.getLogger("DataManager.saveData");
		Json json = new Json();
		json.setOutputType(OutputType.json);
		try(FileWriter file = new FileWriter(path+fileName+".json")){
			file.write(json.prettyPrint(object));
			file.flush();
			file.close();
		} catch (Exception e) {
			logger.error("Can't write in path : " +path+fileName+".json " +e);
		}
	}

	/**
	 * Cast Object
	 * @deprecated			Function is updated and loader don't need it for moment ..... let see after development if Object needed cast
	 * @param <T>
	 * @param object		Object for cast
	 * @param clazz			Class for cast
	 * @return				Object cast
	 * @throws Exception	if cast fail
	 */
	public static <T> T convertInstanceOfObject(Object object, Class<T> clazz) throws Exception{
		Logger logger = Logger.getLogger("DataManager.convertInstanceOfObject");
		try {
			return clazz.cast(object);
		} catch(ClassCastException e) {
			logger.error("Error for casting Object " + e);
			return null;
		}
	}

	/**
	 * Load object's data from a json file
	 * 
	 * @param objectClass	Class of the object to load
	 * @param path			Path of the folder to load
	 * @param fileName		Name of the file to load
	 * 
	 * @return	An object containing the file's data
	 */
	public static Object loadData(Class<?> objectClass, String path, String fileName) {

		Logger logger = Logger.getLogger("DataManager.loadData");
		// TODO import function in loader code
		Json parser = new Json();
		Object object = null;
		try(FileReader file = new FileReader(path+fileName+".json")) {

			object = parser.fromJson(Class.forName(objectClass.getName()), file);

			file.close();
		} catch (Exception e) {
			logger.error("File not found " + path+fileName+".json " + e);
		}

		return object;
	}

	/**
	 * Valide l'objet pour la sauvegarde
	 * @param parent
	 * @return la liste des erreurs
	 * @throws Exception si parent est null
	 */
	@SuppressWarnings("unchecked")
	public static List<String> objectValidation(Group parent) throws Exception{
		Logger logger = Logger.getLogger("DataManager.objectValidation");
		List<String> errors = new ArrayList<String>();
		if(parent == null) {
			logger.error("Parent is NULL");
			throw new GdxRuntimeException("# ERROR: Parent is NULL #");
		}
		if (((TextField) parent.findActor("name")).getText().equals("") || ((TextField) parent.findActor("name")).getText() == null) {
			logger.error("Name is Empty or null");
			errors.add("Generator.Error.Name.Empty");
		}
		if (((Container<Image>) parent.findActor("icon_container")).getActor() == null) {
			logger.error("Icon is Empty or null");
			errors.add("Generator.Error.Icon.Empty");
		}
		if (((TextField) parent.findActor("description")).getText().equals("") || ((TextField) parent.findActor("description")).getText() == null) {
			logger.error("Description is Empty or null");
			errors.add("Generator.Error.Description.Empty");
		}
		if (errors.isEmpty()) {
			errors = null;
		}
		return errors;
	}

	/**
	 * Construit l'objet pour la sauvegarde
	 * @param parent
	 * @return <b>Java Object</b> à sauvegarder
	 * @throws Exception si parent est null
	 */
	public static Base objectConstructor(Group parent) throws Exception{

		Logger logger = Logger.getLogger("DataManager.objectConstructor");
		Base object = null;

		if(parent == null) {
			logger.error("Parent is NULL");
			throw new GdxRuntimeException("# ERROR: Parent is NULL #");
		}

		switch (((SelectCategory) parent.findActor("category")).getSelected()) {
		case ARME:
			logger.info("Weapon create");
			object = createWeapon(parent);
			break;
		case ARMURE:
			logger.info("Armor create");
			object = createArmor(parent);
			break;
		case COMPETENCE:
			logger.info("Ability create");
			object = createMagic(parent);
			break;
		case ENTITE:
			// TODO
			logger.info("Entity create");
			object = createEntity(parent);
			break;
		case OBJET:
			// TODO
			logger.info("Object create");
			break;
		}
		return object;
	}

	private static Base createEntity(Group parent) throws Exception{
		Logger logger = Logger.getLogger("DataManager.createMagic");
		Base object = null;

		if(parent == null) {
			logger.error("Parent is NULL");
			throw new GdxRuntimeException("# ERROR: Parent is NULL #");
		}

		EntityParametersGraph graph = (EntityParametersGraph) Generator.findActor("graph");
		
		if(graph == null) {
			logger.error("graph is NULL");
			throw new GdxRuntimeException("# ERROR: Graph is NULL #");
		}
		
		//SkillTree
		SkillTree skillTree = new SkillTree(graph.getNodeList(), graph.getLinkList());
		
		//Maping
		Map<StatistiquesEnum, Integer> statistiques = new HashMap<StatistiquesEnum,Integer>();
		List<AttributsEnum> attributs = new ArrayList<AttributsEnum>();
		List<TypeAttaqueEnum> typeAttaque = new ArrayList<TypeAttaqueEnum>();

		//set value
		// TODO set attribute
		String name = ((TextField) parent.findActor("name")).getText();
		String description = ((TextField) parent.findActor("description")).getText();
		ElementEnum element = ElementEnum.valueOf(((StringSelectBox) parent.findActor("element")).getSelected());
		String iconPath = ""; //((TextField) parent.findActor("icon_container")).getText();
		int minDamage = 1;
		int maxDamage = 10;
		int mana = 10;
		Boolean utilisableCombat = false;
		Boolean utilisableHorsCombat = false;

		object = new Entity(skillTree, name, iconPath, description, statistiques, element, attributs);

		return object;
	}
	
	/**
	 * Create magic <b>Java Object</b> for saving
	 * @param parent
	 * @return magic
	 * @throws Exception if parent is null
	 */
	private static Base createMagic(Group parent) throws Exception{
		Logger logger = Logger.getLogger("DataManager.createMagic");
		Base object = null;

		if(parent == null) {
			logger.error("Parent is NULL");
			throw new GdxRuntimeException("# ERROR: Parent is NULL #");
		}

		//Maping
		Map<StatistiquesEnum, Integer> statistiques = new HashMap<StatistiquesEnum,Integer>();
		List<AttributsEnum> attributs = new ArrayList<AttributsEnum>();
		List<TypeAttaqueEnum> typeAttaque = new ArrayList<TypeAttaqueEnum>();

		//set value
		// TODO set attribute
		String name = ((TextField) parent.findActor("name")).getText();
		String description = ((TextField) parent.findActor("description")).getText();
		ElementEnum element = ElementEnum.valueOf(((StringSelectBox) parent.findActor("element")).getSelected());
		String iconPath = ""; //((TextField) parent.findActor("icon_container")).getText();
		int minDamage = 1;
		int maxDamage = 10;
		int mana = 10;
		Boolean utilisableCombat = false;
		Boolean utilisableHorsCombat = false;

		object = new Magie(name, iconPath, description, statistiques, element, attributs, minDamage, maxDamage, mana, utilisableCombat, utilisableHorsCombat, typeAttaque);

		return object;
	}

	/**
	 * Create armor <b>Java Object</b> for saving
	 * @param parent
	 * @return armor
	 * @throws Exception if parent is null
	 */
	private static Base createArmor(Group parent) throws Exception{
		Logger logger = Logger.getLogger("DataManager.createArmor");
		Base object = null;

		if(parent == null) {
			logger.error("Parent is NULL");
			throw new GdxRuntimeException("# ERROR: Parent is NULL #");
		}

		//Maping
		Map<StatistiquesEnum, Integer> statistiques = new HashMap<StatistiquesEnum,Integer>();
		Map<TypeAttaqueEnum, Integer> typeDefense = new HashMap<TypeAttaqueEnum, Integer>();
		Map<ElementEnum, Integer> defenseElement = new HashMap<ElementEnum, Integer>();
		Map<AttributsEnum, Integer> defenseAttribue = new HashMap<AttributsEnum, Integer>();

		//set value
		String name = ((TextField) parent.findActor("name")).getText();
		String description = ((TextField) parent.findActor("description")).getText();
		SousCategorieArmureEnum type1 = SousCategorieArmureEnum.valueOf(((StringSelectBox) parent.findActor("type")).getSelected());
		TypeArmureEnum subCategory1 = TypeArmureEnum.valueOf(((StringSelectBox) parent.findActor("subcategory")).getSelected());
		// TODO set attribute
		String iconPath = ""; //((TextField) parent.findActor("icon_container")).getText();
		int defensePhysique = 10;
		int defenseMagique = 10;
		TypeRareteEnum rarity = TypeRareteEnum.RARE;
		Boolean quest = false;
		int charge = 10;

		object = new Armure(name, iconPath, description, statistiques, defensePhysique, defenseMagique, subCategory1, typeDefense, defenseElement, defenseAttribue, type1, rarity, quest, charge);

		return object;
	}

	/**
	 * Create weapon <b>Java Object</b> for saving
	 * @param parent
	 * @return weapon
	 * @throws Exception if parent is null
	 */
	private static Base createWeapon(Group parent) throws Exception{
		Logger logger = Logger.getLogger("DataManager.createWeapon");
		Base object = null;

		if(parent == null) {
			logger.error("Parent is NULL");
			throw new GdxRuntimeException("# ERROR: Parent is NULL #");
		}

		//Maping
		Map<StatistiquesEnum, Integer> statistiques = new HashMap<StatistiquesEnum,Integer>();
		List<AttributsEnum> attributs = new ArrayList<AttributsEnum>();
		List<TypeAttaqueEnum> typeAttaque = new ArrayList<TypeAttaqueEnum>();

		//set value
		String name = ((TextField) parent.findActor("name")).getText();
		String description = ((TextField) parent.findActor("description")).getText();
		ElementEnum element = ElementEnum.valueOf(((StringSelectBox) parent.findActor("element")).getSelected());
		SousCategorieArmeEnum type = SousCategorieArmeEnum.valueOf(((StringSelectBox) parent.findActor("type")).getSelected());
		TypeArmeEnum subCategory = TypeArmeEnum.valueOf(((StringSelectBox) parent.findActor("subcategory")).getSelected());

		// TODO set attribute
		String iconPath = ""; //((TextField) parent.findActor("icon_container")).getText();
		TypeRareteEnum rarity = TypeRareteEnum.RARE;
		Boolean quest = false;
		int charge = 10;
		int minDamage = 1;
		int maxDamage = 10;

		object = new Arme(name, iconPath, description, statistiques, element, attributs, minDamage, maxDamage, subCategory, typeAttaque, type, rarity, quest, charge);

		return object;
	}

	/**
	 * Construit le path en fonction de la catégorie en entrée
	 * @param categorieEnum
	 * @return Path
	 * @throws Exception if categorieEnum is null
	 */
	public static String pathConstructor(CategorieEnum categorieEnum) throws Exception{
		Logger logger = Logger.getLogger("DataManager.pathConstructor");

		if(categorieEnum == null) {
			logger.error("Parent is NULL");
			throw new GdxRuntimeException("# ERROR: Categorie is NULL #");
		}
		switch (categorieEnum) {
		case ARME:
			logger.info("Path : ./ressources/Data/Object/Equipement/Weapon/");
			return "./ressources/Data/Object/Equipement/Weapon/";
		case ARMURE:
			logger.info("Path : ./ressources/Data/Object/Equipement/Armor/");
			return "./ressources/Data/Object/Equipement/Armor/";
		case COMPETENCE:
			logger.info("Path : ./ressources/Data/Skill/");
			return "./ressources/Data/Skill/";
		case ENTITE:
			logger.info("Path : ./ressources/Data/Entity/");
			return "./ressources/Data/Entity/";
		case OBJET:
			logger.info("Path : ./ressources/Data/Object/Other/");
			return "./ressources/Data/Object/Other/";
		}
		return null;
	}

	/**
	 * delete the file
	 * @param path
	 * @param fileName
	 */
	public static void deleteFile(String path, String fileName) throws Exception{
		Logger logger = Logger.getLogger("DataManager.deleteFile");
		
		File file = new File(path+fileName+".json"); 

		if(file.delete()) 
		{ 
			logger.info("File deleted successfully"); 
		} 
		else
		{ 
			logger.error("Failed to delete the file");
			throw new GdxRuntimeException("# ERROR: Failed to delete the file #");
		} 
	}
}
