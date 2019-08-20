package app.model.objet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.model.enumeration.attribut.AttributsEnum;
import app.model.enumeration.element.ElementEnum;
import app.model.enumeration.objet.TypeRareteEnum;
import app.model.enumeration.statistique.StatistiquesEnum;

/**
 * classe pour les objet de craft ou objet de quéte
 *
 */
public class ObjetNonUtilisable extends GlobalObjet{

	private boolean materiau;
	
	/**
	 * default constructor
	 * @param nom : nom de l'objet
	 * @param iconPath : path de l'icon
	 * @param description : description de l'objet
	 * @param statistiques : statistique qu'il ajoute au craft sous la forme (type, valeur)
	 * @param element : element qu'il ajoute au craft
	 * @param attributs : attribue qu'il ajoute au craft
	 * @param rarete : rareter de l'objet
	 * @param quete : true si objet de quéte
	 * @param materiau : true si objet pour le craft
	 * @param charge : poids de l'objet
	 */
	public ObjetNonUtilisable(String nom, String iconPath, String description, Map<StatistiquesEnum,Integer> statistiques, ElementEnum element, List<AttributsEnum> attributs,
			TypeRareteEnum rarete, boolean quete, boolean materiau, int charge) {
		this.nom = nom;
		this.description = description;
		this.iconPath = iconPath;
		this.statistiques = new HashMap<StatistiquesEnum, Integer>(statistiques);
		this.element = element;
		this.attributs = new ArrayList<AttributsEnum>(attributs);
		this.rarete = rarete;
		this.charge = charge;
		this.quete = quete;
		this.materiau = materiau;
	}
	public boolean isMateriau() {
		return materiau;
	}
}
