package generateur.view.global;

import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import app.model.enumeration.CategorieEnum;
import app.model.enumeration.element.ElementEnum;
import generateur.controller.button.global_parameters.IconButton;
import generateur.Launcher;
import generateur.MainWindow;
import generateur.controller.select.SelectCategory;
import generateur.controller.select.StringSelectBox;

/**
 * Contenu des paramètres globaux.
 * 
 * @author Julien B.
 */

public class GlobalContents extends ScrollPane {

	public GlobalContents(Skin skin) {
		super(null, skin);
		setName("global_contents");
		
		//Zone du nom
		Label name = new Label(Launcher.languageManager.getProperty("Global.Name"), skin);
		TextField nameField = new TextField("", skin);
		nameField.setName("name");
		
		//Sélection de la catégorie
		Label category = new Label(Launcher.languageManager.getProperty("Global.Category"), skin);
		SelectCategory categorySelect = new SelectCategory(skin);
		categorySelect.setName("category");
		categorySelect.setItems(CategorieEnum.values());
		
		//Sélection de la sous-catégorie
		Label subcategory = new Label(Launcher.languageManager.getProperty("Global.Sub.Category"), skin);
		StringSelectBox subcategorySelect = new StringSelectBox(null, skin);
		subcategorySelect.setName("subcategory");
		
		//Séléction des informations complémentaires pour les armes et les armures
		Label type = new Label(Launcher.languageManager.getProperty("Global.Type"), skin);
		StringSelectBox typeSelect = new StringSelectBox(skin);
		typeSelect.setName("type");
		
		//Gestion de l'icône
		Label icon = new Label(Launcher.languageManager.getProperty("Global.Icon"), skin);
		Container<Image> iconContainer = new Container<Image>();
		iconContainer.setName("icon_container");
		iconContainer.setSize(64, 64);
		IconButton iconChoose = new IconButton(skin);
		
		//Sélection de l'élément
		Label element = new Label(Launcher.languageManager.getProperty("Global.Element"), skin);
		StringSelectBox elementSelect = new StringSelectBox(ElementEnum.class, skin);
		elementSelect.setName("element");
		
		//Description
		Label description = new Label(Launcher.languageManager.getProperty("Global.Description"), skin);
		TextArea descriptionArea = new TextArea("", skin);
		descriptionArea.setName("description");
		descriptionArea.setPrefRows(5);
		
		Table content = new Table(MainWindow.skin);
		content.align(Align.top);
		
		content.add(name);
		content.row();
		content.add(nameField).spaceBottom(5);
		content.row();
		
		content.add(category);
		content.row();
		content.add(categorySelect).spaceBottom(5);
		content.row();
		
		content.add(subcategory);
		content.row();
		content.add(subcategorySelect).spaceBottom(5);
		content.row();
		
		content.add(type);
		content.row();
		content.add(typeSelect).spaceBottom(5);
		content.row();
		
		content.add(element);
		content.row();
		content.add(elementSelect).spaceBottom(5);
		content.row();
		
		content.add(icon);
		content.row();
		content.add(iconChoose);
		content.row();
		content.add(iconContainer).minHeight(64).prefHeight(64).spaceBottom(5);
		content.row();
		
		content.add(description);
		content.row();
		content.add(descriptionArea).prefWidth(MainWindow.stage.getWidth() * 0.33f * 0.9f).spaceBottom(5);
		content.row();
		
		this.setActor(content);
	}
	
	public void fireCategorySelect() {
		findActor("category").fire(new ChangeListener.ChangeEvent());
	}

	/**Libération des objets inutilisés*/
	public void dispose() {
		((IconButton) findActor("icon_selector")).dispose();
	}
}
