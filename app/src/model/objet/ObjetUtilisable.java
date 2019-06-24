package src.model.objet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.model.enumeration.attribut.AttributsEnum;
import src.model.enumeration.element.ElementEnum;
import src.model.enumeration.objet.TypeRareteEnum;
import src.model.enumeration.statistique.StatistiquesEnum;

/**
 * 
 * classe pour les objet utilisable
 *
 */
public class ObjetUtilisable extends GlobalObjet{
	
	private boolean utilisableCombat;
	private boolean utilisableHorsCombat;
	
	/**
	 * default constructor
	 * @param nom : nom de l'objet
	 * @param iconPath : path de l'icon
	 * @param description : description de l'objet
	 * @param statistiques : statistique qu'ajoute l'objet si consomé (type, valeur)
	 * @param element : element qu'il ajoute au craft
	 * @param attributs : attribue qu'il ajoute au craft
	 * @param rarete : rareter de l'objet
	 * @param quete : true si objet de quéte
	 * @param utilisableCombat : true si utilisable en combat
	 * @param utilisableHorsCombat : true si utilisable hors combat
	 * @param charge : poids de l'objet
	 */
	public ObjetUtilisable(String nom, String iconPath, String description, Map<StatistiquesEnum,Integer> statistiques, List<ElementEnum> element, List<AttributsEnum> attributs,
			TypeRareteEnum rarete, boolean quete, boolean utilisableCombat, boolean utilisableHorsCombat, int charge) {
		this.nom = nom;
		this.description = description;
		this.iconPath = iconPath;
		this.statistiques = new HashMap<StatistiquesEnum, Integer>(statistiques);
		this.element = new ArrayList<ElementEnum>(element);
		this.attributs = new ArrayList<AttributsEnum>(attributs);
		this.rarete = rarete;
		this.charge = charge;
		this.quete = quete;
		this.utilisableCombat = utilisableCombat;
		this.utilisableHorsCombat = utilisableHorsCombat;
	}
	public boolean isUtilisableCombat() {
		return utilisableCombat;
	}
	public boolean isUtilisableHorsCombat() {
		return utilisableHorsCombat;
	}
}
