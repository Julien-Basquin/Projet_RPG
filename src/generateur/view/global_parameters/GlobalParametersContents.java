package generateur.view.global_parameters;

import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import app.model.enumeration.CategorieEnum;
import app.model.enumeration.element.ElementEnum;
import generateur.controller.button.CloseButton;
import generateur.controller.button.IconButton;
import generateur.controller.button.InitButton;
import generateur.controller.button.SaveButton;
import generateur.controller.select.SelectCategory;

/**
 * @author Julien B.
 *
 * Contenu des paramètres globaux.
 */

//TODO internationalisation
public class GlobalParametersContents extends ScrollPane {

	public GlobalParametersContents(Skin skin) {
		super(null, skin);
		setName("global_contents");
		
		VerticalGroup groupContent = new VerticalGroup();
		groupContent.setName("group_content");

		//Zone du nom
		VerticalGroup nameGroup = new VerticalGroup();
		Label name = new Label("Nom", skin);
		TextField nameField = new TextField("", skin);
		nameField.setName("name");
		nameGroup.addActor(name);
		nameGroup.addActor(nameField);
		
		//Sélection de la catégorie
		VerticalGroup categoryGroup = new VerticalGroup();
		Label category = new Label("Categorie", skin);
		SelectCategory categorySelect = new SelectCategory(groupContent, skin);
		categorySelect.setName("category");
		categorySelect.setItems(CategorieEnum.values());
		categoryGroup.addActor(category);
		categoryGroup.addActor(categorySelect);
		
		//Sélection de la sous-catégorie
		VerticalGroup subcategoryGroup = new VerticalGroup();
		Label subcategory = new Label("Sous-catégorie", skin);
		SelectBox<String> subcategorySelect = new SelectBox<String>(skin);
		subcategorySelect.setName("subcategory");
		subcategoryGroup.addActor(subcategory);
		subcategoryGroup.addActor(subcategorySelect);
		
		//Séléction des informations complémentaires pour les armes et les armures
		VerticalGroup typeGroup = new VerticalGroup();
		Label type = new Label("Type", skin);
		SelectBox<String> typeSelect = new SelectBox<String>(skin);
		typeSelect.setName("type");
		typeGroup.addActor(type);
		typeGroup.addActor(typeSelect);
		
		//Gestion de l'icône
		VerticalGroup iconGroup = new VerticalGroup();
		Label icon = new Label("Icône", skin);
		Container<Image> iconContainer = new Container<Image>();
		iconContainer.setName("icon_container");
		iconContainer.setSize(64, 64);
		IconButton iconChoose = new IconButton(skin);
		iconGroup.addActor(icon);
		iconGroup.addActor(iconContainer);
		iconGroup.addActor(iconChoose);
		
		//Sélection de l'élément
		VerticalGroup elementGroup = new VerticalGroup();
		Label element = new Label("Elément", skin);
		SelectBox<ElementEnum> elementSelect = new SelectBox<ElementEnum>(skin);
		elementSelect.setName("element");
		elementSelect.setItems(ElementEnum.values());
		elementGroup.addActor(element);
		elementGroup.addActor(elementSelect);
		
		//Description
		VerticalGroup descriptionGroup = new VerticalGroup();
		Label description = new Label("Description", skin);
		TextArea descriptionArea = new TextArea("", skin);
		descriptionArea.setName("description");
		descriptionArea.setPrefRows(5);
		descriptionGroup.addActor(description);
		descriptionGroup.addActor(descriptionArea);

		//Boutons de fermeture, de réinitialisation et d'enregistrement
		HorizontalGroup groupButton = new HorizontalGroup();
		groupButton.addActor(new CloseButton(skin));
		groupButton.addActor(new InitButton(skin));
		groupButton.addActor(new SaveButton(skin));

		//Ajout des objets au groupe
		groupContent.addActor(nameGroup);
		groupContent.addActor(categoryGroup);
		groupContent.addActor(subcategoryGroup);
		groupContent.addActor(typeGroup);
		groupContent.addActor(iconGroup);
		groupContent.addActor(elementGroup);
		groupContent.addActor(descriptionGroup);
		groupContent.addActor(groupButton);
		
		this.setActor(groupContent);
		
		//Remplissage automatique des listes déroulantes liées à la catégorie
		categorySelect.fire(new ChangeListener.ChangeEvent());
	}

	/**Libération des objets inutilisés*/
	public void dispose() {
		((IconButton) findActor("icon_selector")).dispose();
	}
}
