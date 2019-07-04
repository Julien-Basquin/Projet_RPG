package src.model.objet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import src.model.enumeration.attaque.TypeAttaqueEnum;
import src.model.enumeration.attribut.AttributsEnum;
import src.model.enumeration.element.ElementEnum;
import src.model.enumeration.objet.TypeRareteEnum;
import src.model.enumeration.objet.equipement.armure.TypeArmureEnum;
import src.model.enumeration.objet.equipement.armure.souscategorie.SousCategorieArmureEnum;
import src.model.enumeration.statistique.StatistiquesEnum;

/**
 * Définie les statistique des armures.
 *
 */
public class Armure extends GlobalObjet{

	private TypeArmureEnum type;
	private SousCategorieArmureEnum sousCategorie;
	private Map<TypeAttaqueEnum, Integer> typeDefense;
	private Map<ElementEnum, Integer> defenseElement;
	private Map<AttributsEnum, Integer> defenseAttribue;
	private int defensePhysique;
	private int defenseMagique;
	
	/**
	 * default constructor
	 * @param nom : nom de l'armure
	 * @param iconPath : path de l'icon
	 * @param description : description de l'armure
	 * @param statistiques : statistique qu'elle up sous la forme (Type, Nombre)
	 * @param attributs : attribue que peu infliger l'armure si equiper
	 * @param defensePhysique : montant de defense physique
	 * @param defenseMagique : montant de defense magique
	 * @param type : type d'armure
	 * @param typeDefense : defense suplementaire sur les dommage sous la forme (Type, valeur)
	 * @param defenseElement : defense suplémentaire au élément sous la forme (Type, valeur)
	 * @param defenseAttribue : % de chance de resister a l'attribut sous la forme (Attribut, %)
	 * @param sousCategorie : sous catégorie d'armure
	 * @param rarete : rareté de l'armure
	 * @param quete : true si objet de quéte
	 * @param charge : poids de l'objet
	 */
	
	public Armure(String nom, String iconPath, String description, Map<StatistiquesEnum,Integer> statistiques, int defensePhysique, int defenseMagique,
			 TypeArmureEnum type, Map<TypeAttaqueEnum, Integer> typeDefense, Map<ElementEnum, Integer> defenseElement, Map<AttributsEnum, Integer> defenseAttribue,
			 SousCategorieArmureEnum sousCategorie, TypeRareteEnum rarete, boolean quete, int charge) {
		this.nom = nom;
		this.description = description;
		this.iconPath = iconPath;
		this.defensePhysique = defensePhysique;
		this.defenseMagique = defenseMagique;
		this.type = type;
		this.sousCategorie = sousCategorie;
		
		this.typeDefense =  new HashMap<TypeAttaqueEnum, Integer>();
		this.typeDefense.putAll(typeDefense);
		this.defenseElement =  new HashMap<ElementEnum, Integer>();
		this.defenseElement.putAll(defenseElement);
		this.defenseAttribue =  new HashMap<AttributsEnum, Integer>();
		this.defenseAttribue.putAll(defenseAttribue);
		this.statistiques = new HashMap<StatistiquesEnum, Integer>();
		this.statistiques.putAll(statistiques);
		this.attributs = new ArrayList<AttributsEnum>();
		this.attributs.addAll(attributs);

		this.element = null;
		this.rarete = rarete;
		this.charge = charge;
		this.quete = quete;
	}
	
	/**
	 * copie constructor
	 * @param armure : armure à copié
	 */
	public Armure(Armure armure) {
		this.nom = armure.getNom();
		this.description = armure.getDescription();
		this.iconPath = armure.getIconPath();
		this.defensePhysique = armure.getDefensePhysique();
		this.defenseMagique = armure.getDefenseMagique();
		this.type = armure.getType();
		this.sousCategorie = armure.getSousCategorie();
		this.typeDefense =  new HashMap<TypeAttaqueEnum, Integer>(armure.getTypeDefense());
		this.defenseElement =  new HashMap<ElementEnum, Integer>(armure.getDefenseElement());
		this.defenseAttribue =  new HashMap<AttributsEnum, Integer>(armure.getDefenseAttribue());
		this.statistiques = new HashMap<StatistiquesEnum, Integer>(armure.getStatistiques());
		this.element = null;
		this.attributs = new ArrayList<AttributsEnum>(armure.getAttributs());
		this.rarete = armure.getRarete();
		this.charge = armure.getCharge();
		this.quete = armure.isQuete();
	}

	public TypeArmureEnum getType() {
		return type;
	}
	public SousCategorieArmureEnum getSousCategorie() {
		return sousCategorie;
	}
	public Map<TypeAttaqueEnum, Integer> getTypeDefense() {
		return typeDefense;
	}
	public Map<ElementEnum, Integer> getDefenseElement() {
		return defenseElement;
	}
	public Map<AttributsEnum, Integer> getDefenseAttribue() {
		return defenseAttribue;
	}
	public int getDefenseMagique() {
		return defenseMagique;
	}
	public int getDefensePhysique() {
		return defensePhysique;
	}
}
