package app.model.entity;

import java.util.List;
import java.util.Map;

import app.model.Base;
import app.model.enumeration.attribut.AttributsEnum;
import app.model.enumeration.element.ElementEnum;
import app.model.enumeration.statistique.StatistiquesEnum;

/**
 * 
 * Class pour les entités
 *
 */
public class Entity extends Base {
	private SkillTree skillTree;
	
	/**
	 * create null entity for loading
	 */
	public Entity() {
	}
	
	/**
	 * Default constructor
	 * @param skillTree
	 * @param nom
	 * @param iconPath
	 * @param description
	 * @param statistiques
	 * @param element
	 * @param attributs
	 */
	public Entity(SkillTree skillTree, String nom, String iconPath, String description, Map<StatistiquesEnum,Integer> statistiques, ElementEnum element, 
			List<AttributsEnum> attributs) {
		this.skillTree = skillTree;
		this.attributs = attributs;
		this.description = description;
		this.element = element;
		this.iconPath = iconPath;
		this.nom = nom;
		this.statistiques = statistiques;
	}
	
	public SkillTree getSkillTree() {
		return skillTree;
	}
}
