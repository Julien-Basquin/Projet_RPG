package app.model.magie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.model.Base;
import app.model.enumeration.attaque.TypeAttaqueEnum;
import app.model.enumeration.attribut.AttributsEnum;
import app.model.enumeration.element.ElementEnum;
import app.model.enumeration.statistique.StatistiquesEnum;

/**
 * 
 * Possède les dommages minimal et maximal des sorts ainsi que leurs consommation en mana.
 * 
 */

public class Magie extends Base {

	private int valeurMin;
	private int valeurMax;
	private List<TypeAttaqueEnum> typeAttaque;
	private int manaRequis;
	private boolean utilisableCombat;
	private boolean utilisableHorsCombat;
	
	/**
	 * create null Ability for loading
	 */
	public Magie() {
	}
	
	/**
	 * Default constructor.
	 * @param nom : nom de la magie
	 * @param iconPath : path de l'icon
	 * @param description : description
	 * @param statistiques : statistique quelle up sous la forme (type, nombre)
	 * @param element : element de frappe
	 * @param attributs : attribue que la magie peux apliqué
	 * @param min : dommage minimum
	 * @param max : dommage maximum
	 * @param mana : mana requie
	 * @param utilisableCombat : true si utilisable en combat
	 * @param utilisableHorsCombat : true si utilisable hors combat
	 * @param typeAttaque : le type d'attaque du sort
	 */
	public Magie(String nom, String iconPath, String description, Map<StatistiquesEnum,Integer> statistiques, ElementEnum element, List<AttributsEnum> attributs,
			int min, int max, int mana, boolean utilisableCombat, boolean utilisableHorsCombat, List<TypeAttaqueEnum> typeAttaque) {
		this.nom = nom;
		this.description = description;
		this.iconPath = iconPath;
		this.utilisableCombat = utilisableCombat;
		this.utilisableHorsCombat = utilisableHorsCombat;
		this.statistiques = new HashMap<StatistiquesEnum, Integer>(statistiques);
		this.element = element;
		this.attributs = new ArrayList<AttributsEnum>(attributs);
		this.valeurMax = max;
		this.valeurMin = min;
		this.manaRequis = mana;
		this.typeAttaque = new ArrayList<TypeAttaqueEnum>(typeAttaque);
	}
	
	public int getManaRequis() {
		return manaRequis;
	}
	public int getValeurMin() {
		return valeurMin;
	}
	public int getValeurMax() {
		return valeurMax;
	}
	public boolean isUtilisableCombat() {
		return utilisableCombat;
	}
	public boolean isUtilisableHorsCombat() {
		return utilisableHorsCombat;
	}
	public List<TypeAttaqueEnum> getTypeAttaque() {
		return typeAttaque;
	}
}
