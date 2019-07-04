package src.model;

import java.util.List;
import java.util.Map;

import src.model.enumeration.attribut.AttributsEnum;
import src.model.enumeration.element.ElementEnum;
import src.model.enumeration.statistique.StatistiquesEnum;

/**
 * 
 * Classe de base qui possède le nom, le path de son icône, une description, les statistiques globale,
 * la liste des éléments et la liste des attributs.
 * 
 *  Elle hérite sur les objets, les entités et la magie.
 *
 */

public abstract class Base {
	
	protected String nom;
	protected String iconPath;
	protected String description;
	protected Map<StatistiquesEnum,Integer> statistiques;
	protected List<ElementEnum> element;
	protected List<AttributsEnum> attributs;
	
	public List<AttributsEnum> getAttributs() {
		return attributs;
	}
	public String getDescription() {
		return description;
	}
	public List<ElementEnum> getElement() {
		return element;
	}
	public String getIconPath() {
		return iconPath;
	}
	public String getNom() {
		return nom;
	}
	public Map<StatistiquesEnum, Integer> getStatistiques() {
		return statistiques;
	}
}
