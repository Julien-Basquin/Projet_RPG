package src.model.objet;

import src.model.Base;
import src.model.enumeration.objet.TypeRareteEnum;

/**
 * 
 * Classe abstract pour les objets portant la rareté, la charge de l'objet(poids) et si c'est un objet de quéte.
 *
 */
public abstract class GlobalObjet extends Base {
	
	protected TypeRareteEnum rarete;
	protected int charge;
	protected boolean quete;
	
	public int getCharge() {
		return charge;
	}
	public TypeRareteEnum getRarete() {
		return rarete;
	}
	public boolean isQuete() {
		return quete;
	}
}
