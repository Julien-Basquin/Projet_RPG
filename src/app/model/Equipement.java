package app.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.GdxRuntimeException;

import app.model.objet.Arme;
import app.model.objet.Armure;

/**
 * 
 * Classe pour l'equipement des entitées.
 *
 */
public class Equipement {
	
	final static int maxArmes = 2;
	final static int maxAnneaux = 2;
	
	private Armure tete;
	private Armure corps;
	private Armure mains;
	private Armure jambes;
	private Armure pieds;
	private Armure[] anneaux;
	private Armure amulette;
	private Arme[] armes;
	
	/**
	 * Default constructor
	 */
	public Equipement() {
		this.anneaux = new Armure[maxAnneaux];
		this.armes = new Arme[maxArmes];
	}
	
	/**
	 * initalization constructor
	 * 
	 * @param tete
	 * @param corps
	 * @param mains
	 * @param jambes
	 * @param pieds
	 * @param anneaux : tableau des anneaux
	 * @param amulette : tableau des armes
	 * @param armes
	 * 
	 * @throws erreur si les taille de tableau ne sont pas respecté
	 */
	public Equipement(Armure tete, Armure corps, Armure mains, Armure jambes, Armure pieds, Armure[] anneaux, Armure amulette, Arme[] armes) {
		Gdx.app.debug("initalization constructor Start", "Start initalization of equipment");
		try {
			verifLength(anneaux, armes);
			int i;
			this.anneaux = new Armure[maxAnneaux];
			this.armes = new Arme[maxArmes];
			
			this.tete = new Armure(tete);
			this.corps = new Armure(corps);
			this.mains = new Armure(mains);
			this.jambes = new Armure(jambes);
			this.pieds = new Armure(pieds);
			this.amulette = new Armure(amulette);
		
			i=0;
			for (Armure anneau : anneaux) {
				this.anneaux[i] = new Armure(anneau);
				i++;
			}
			
			i=0;
			for (Arme arme : armes) {
				this.armes[i] = new Arme(arme);
				i++;
			}
		} catch (Exception e) {
			Gdx.app.error("CODE_1", "Error of initialization of equipment", e);
		} finally {
			Gdx.app.debug("initalization constructor End", "End initalization of equipment");
		}
	}
	
	/**
	 * @author simon :
	 * 
	 * Vérifie la tailles des tableau
	 * 
	 * @param anneaux : tableau des anneaux
	 * @param armes : tableau des armes
	 * @throws Exception : si l'un des tableau n'as pas la bonne taille
	 * @return void
	 */
	private void verifLength(Armure[] anneaux, Arme[] armes) throws Exception {
		if(anneaux.length != maxAnneaux || armes.length != maxArmes) {
			throw new GdxRuntimeException("# ERROR: Error on tables size #");
		}
	}
	
	/**
	 * @author simon
	 * @param id : id de l'arme
	 * @return Armes[id] : l'arme
	 */
	public Arme getArme(int id) {
		return armes[id];
	}
	/**
	 * @author simon
	 * @param id : id de l'anneaux
	 * @return anneaux[id] : l'anneau
	 */
	public Armure getAnneau(int id) {
		return anneaux[id];
	}
	
	public Armure getAmulette() {
		return amulette;
	}
	public Armure[] getAnneaux() {
		return anneaux;
	}
	public Arme[] getArmes() {
		return armes;
	}
	public Armure getCorps() {
		return corps;
	}
	public Armure getJambes() {
		return jambes;
	}
	public Armure getMains() {
		return mains;
	}
	public Armure getPieds() {
		return pieds;
	}
	public Armure getTete() {
		return tete;
	}
	public static int getMaxAnneaux() {
		return maxAnneaux;
	}
	public static int getMaxArmes() {
		return maxArmes;
	}
}
