package generateur.controller.select;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import app.model.enumeration.CategorieEnum;
import app.model.enumeration.objet.equipement.arme.TypeArmeEnum;
import app.model.enumeration.objet.equipement.arme.souscategorie.SousCategorieArmeEnum;
import app.model.enumeration.objet.equipement.armure.TypeArmureEnum;
import app.model.enumeration.objet.equipement.armure.souscategorie.SousCategorieArmureEnum;
import util.Converter;

/**
 * @author Julien B.
 *
 * Liste déroulante des catégories et modification de toutes les informations liées.
 */

public class SelectCategory extends SelectBox<CategorieEnum> {

	public SelectCategory(Group parent, Skin skin) {
		super(skin);
		
		setItems(CategorieEnum.values());
		
		//Gestion des changements
		addListener(new ChangeListener() {

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				//Récupération des listes des sous-catégories et des types pour mise à jour
				//SupressWarnings("unchecked") car toujours String
				@SuppressWarnings("unchecked")
				SelectBox<String> subcategorySelect = (SelectBox<String>) parent.findActor("subcategory");
				@SuppressWarnings("unchecked")
				SelectBox<String> typeSelect = (SelectBox<String>) parent.findActor("type");
				//Mise à jour des listes en fonction de la catégorie
				switch(getSelected()) {
					case ARME:
						subcategorySelect.setItems(Converter.enumToStringArray(TypeArmeEnum.class));
						subcategorySelect.setSelectedIndex(0);
						typeSelect.setItems(Converter.enumToStringArray(SousCategorieArmeEnum.class));
						typeSelect.setSelectedIndex(0);
						break;
					case ARMURE:
						subcategorySelect.setItems(Converter.enumToStringArray(TypeArmureEnum.class));
						subcategorySelect.setSelectedIndex(0);
						typeSelect.setItems(Converter.enumToStringArray(SousCategorieArmureEnum.class));
						typeSelect.setSelectedIndex(0);
						break;
					case COMPETENCE:
					case ENTITE:
					case OBJET:
						subcategorySelect.clearItems();
						typeSelect.clearItems();
						break;
					default:
						break;
				}
			}
			
		});
	}
	
}
