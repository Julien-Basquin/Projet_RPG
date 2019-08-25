package app.model.objet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.model.enumeration.attaque.TypeAttaqueEnum;
import app.model.enumeration.attribut.AttributsEnum;
import app.model.enumeration.element.ElementEnum;
import app.model.enumeration.objet.TypeRareteEnum;
import app.model.enumeration.objet.equipement.arme.TypeArmeEnum;
import app.model.enumeration.objet.equipement.arme.souscategorie.SousCategorieArmeEnum;
import app.model.enumeration.statistique.StatistiquesEnum;

/**
 * 
 * Définie les statistique des armes.
 *
 */

public class Arme extends GlobalObjet{
	
	private TypeArmeEnum type;
	private int degatsMin;
	private int degatsMax;
	private List<TypeAttaqueEnum> typeAttaque;
	private SousCategorieArmeEnum sousCategorie;
	
	/**
	 * create null weapon for loading
	 */
	public Arme() {
	}
	
	/**
	 * Default constructor
	 * @param nom : nom de l'arme
	 * @param iconPath : path de l'icon
	 * @param description : description de l'arme
	 * @param statistiques : statistique qu'elle up sous la forme (Type, Nombre)
	 * @param element : element de frape
	 * @param attributs : attribue quelle peux infliger
	 * @param min : dommage minimum
	 * @param max : dommage maximum
	 * @param type : type de l'arme
	 * @param typeAttaque : type d'attaque de l'arme
	 * @param sousCategorie : sous catégorie de l'arme
	 * @param rarete : rareter de l'arme
	 * @param quete : true si objet de quete
	 * @param charge : poids de l'objet
	 */
	public Arme(String nom, String iconPath, String description, Map<StatistiquesEnum,Integer> statistiques, ElementEnum element, List<AttributsEnum> attributs, 
			int min, int max, TypeArmeEnum type, List<TypeAttaqueEnum> typeAttaque, SousCategorieArmeEnum sousCategorie, TypeRareteEnum rarete, boolean quete, int charge) {
		this.nom = nom;
		this.description = description;
		this.iconPath = iconPath;
		this.degatsMax = max;
		this.degatsMin = min;
		this.type = type;
		this.sousCategorie = sousCategorie;
		
		this.typeAttaque =  new ArrayList<TypeAttaqueEnum>(typeAttaque);
		this.statistiques = new HashMap<StatistiquesEnum, Integer>(statistiques);
		this.element = element;
		this.attributs = new ArrayList<AttributsEnum>(attributs);
		
		this.rarete = rarete;
		this.charge = charge;
		this.quete = quete;
	}
	
	/**
	 * copie constructor
	 * @param arme : arme à copié
	 */
	public Arme(Arme arme) {
		this.nom = arme.getNom();
		this.description = arme.getDescription();
		this.iconPath = arme.getIconPath();
		this.degatsMax = arme.getDegatsMax();
		this.degatsMin = arme.getDegatsMin();
		this.type = arme.getType();
		this.sousCategorie = arme.getSousCategorie();
		this.typeAttaque =  new ArrayList<TypeAttaqueEnum>(arme.getTypeAttaque());
		this.statistiques = new HashMap<StatistiquesEnum, Integer>(arme.getStatistiques());
		this.element = arme.getElement();
		this.attributs = new ArrayList<AttributsEnum>(arme.getAttributs());
		this.rarete = arme.getRarete();
		this.charge = arme.getCharge();
		this.quete = arme.isQuete();
	}

	public TypeArmeEnum getType() {
		return type;
	}
	public SousCategorieArmeEnum getTaille() {
		return sousCategorie;
	}
	public List<TypeAttaqueEnum> getTypeAttaque() {
		return typeAttaque;
	}
	public int getDegatsMax() {
		return degatsMax;
	}
	public int getDegatsMin() {
		return degatsMin;
	}
	public SousCategorieArmeEnum getSousCategorie() {
		return sousCategorie;
	}
}
