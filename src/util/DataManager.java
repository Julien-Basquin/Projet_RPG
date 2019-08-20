package util;


import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter.OutputType;

import app.model.Base;
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
import app.model.objet.Arme;
import app.model.objet.Armure;
import generateur.controller.select.SelectCategory;
import generateur.controller.select.StringSelectBox;

public class DataManager {

	/**
	 * Save data
	 * @param object
	 * @param path
	 * @param fileName
	 */
	public static void saveData(Object object, String path, String fileName) {
		Json json = new Json();
		json.setOutputType(OutputType.json);
		try(FileWriter file = new FileWriter(path+fileName)){
			file.write(json.prettyPrint(object));
			file.flush();
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void downloadData() {
		// TODO
	}
	
	/**
	 * Valide l'objet pour la sauvegarde
	 * @param parent
	 * @return la liste des erreurs
	 * @throws Exception si parent est null
	 */
	@SuppressWarnings("unchecked")
	public static List<String> objectValidation(Group parent) throws Exception{
		List<String> errors = new ArrayList<String>();
		if(parent == null) {
			throw new GdxRuntimeException("# ERROR: Parent is NULL #");
		}
		if (((TextField) parent.findActor("name")).getText().equals("") || ((TextField) parent.findActor("name")).getText() == null) {
			errors.add("Generator.Error.Name.Empty");
		}
		if (((Container<Image>) parent.findActor("icon_container")).getActor() == null) {
			errors.add("Generator.Error.Icon.Empty");
		}
		if (((TextField) parent.findActor("description")).getText().equals("") || ((TextField) parent.findActor("description")).getText() == null) {
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
	 * @return l'objet a sauvegarder
	 * @throws Exception si parent est null
	 */
	public static Base objectConstructor(Group parent) throws Exception{
		
		Base object = null;
		
		if(parent == null) {
			throw new GdxRuntimeException("# ERROR: Parent is NULL #");
		}
		
		CategorieEnum categorieEnum =((SelectCategory) parent.findActor("category")).getSelected();
		
		//Maping
		Map<StatistiquesEnum, Integer> statistiques = new HashMap<StatistiquesEnum,Integer>();
		Map<TypeAttaqueEnum, Integer> typeDefense = new HashMap<TypeAttaqueEnum, Integer>();
		Map<ElementEnum, Integer> defenseElement = new HashMap<ElementEnum, Integer>();
		Map<AttributsEnum, Integer> defenseAttribue = new HashMap<AttributsEnum, Integer>();
		List<AttributsEnum> attributs = new ArrayList<AttributsEnum>();
		List<TypeAttaqueEnum> typeAttaque = new ArrayList<TypeAttaqueEnum>();
		
		//set value
		String name = ((TextField) parent.findActor("name")).getText();
		String iconPath = ""; //((TextField) parent.findActor("icon_container")).getText();
		String description = ((TextField) parent.findActor("description")).getText();
		int minDamage = 1;
		int maxDamage = 10;
		int defensePhysique = 10;
		int defenseMagique = 10;
		ElementEnum element = ElementEnum.valueOf(((StringSelectBox) parent.findActor("element")).getSelected());
		TypeRareteEnum rarity = TypeRareteEnum.RARE;
		Boolean quest = false;
		int charge = 10;
		
		switch (categorieEnum) {
		case ARME:
			// TODO
			SousCategorieArmeEnum type = SousCategorieArmeEnum.valueOf(((StringSelectBox) parent.findActor("type")).getSelected());
			TypeArmeEnum subCategory = TypeArmeEnum.valueOf(((StringSelectBox) parent.findActor("subcategory")).getSelected());
			object = new Arme(name, iconPath, description, statistiques, element, attributs, minDamage, maxDamage, subCategory, typeAttaque, type, rarity, quest, charge);
			break;
		case ARMURE:
			// TODO
			SousCategorieArmureEnum type1 = SousCategorieArmureEnum.valueOf(((StringSelectBox) parent.findActor("type")).getSelected());
			TypeArmureEnum subCategory1 = TypeArmureEnum.valueOf(((StringSelectBox) parent.findActor("subcategory")).getSelected());
			object = new Armure(name, iconPath, description, statistiques, defensePhysique, defenseMagique, subCategory1, typeDefense, defenseElement, defenseAttribue, type1, rarity, quest, charge);
			break;
		case COMPETENCE:
			// TODO
			break;
		case ENTITE:
			// TODO
			break;
		case OBJET:
			// TODO
			break;
		}
		return object;
	}

	/**
	 * Construit le path en fonction de la catégorie en entrée
	 * @param categorieEnum
	 * @return Path
	 * @throws Exception if categorieEnum is null
	 */
	public static String pathConstructor(CategorieEnum categorieEnum) throws Exception{
		
		if(categorieEnum == null) {
			throw new GdxRuntimeException("# ERROR: Categorie is NULL #");
		}
		switch (categorieEnum) {
		case ARME:
			return "./ressources/generateur/Data/Object/Equipement/Weapon/";
		case ARMURE:
			return "./ressources/generateur/Data/Object/Equipement/Armor/";
		case COMPETENCE:
			return "./ressources/generateur/Data/skill/";
		case ENTITE:
			return "./ressources/generateur/Data/Entity/";
		case OBJET:
			return "./ressources/generateur/Data/Object/Other/";
		}
		return null;
	}
}
