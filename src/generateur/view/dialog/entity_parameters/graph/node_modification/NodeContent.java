package generateur.view.dialog.entity_parameters.graph.node_modification;

import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import generateur.Launcher;
import generateur.controller.button.entity_parameters.graph.node.Node;
import generateur.controller.select.SelectNodeCategory;

public class NodeContent extends ScrollPane {

	public NodeContent(Skin skin,Node node) {
		super(null, skin);

		setName("node_content");

		VerticalGroup groupContent = new VerticalGroup();
		groupContent.setName("group_node_content");

		//Zone du nom
		VerticalGroup nameGroup = new VerticalGroup();
		Label name = new Label(Launcher.languageManager.getProperty("Global.Name"), skin);
		TextField nameField = new TextField(node.getName(), skin);
		nameField.setName("node_name");
		nameGroup.setName("node_name_group");
		nameGroup.addActor(name);
		nameGroup.addActor(nameField);

		// image
		VerticalGroup imageGroup = new VerticalGroup();
		Label image = new Label(Launcher.languageManager.getProperty("Global.Name"), skin);
		Image nodeImage = node.getCategoryImage();
		nodeImage.setName("node_image");
		imageGroup.setName("node_image_group");
		imageGroup.addActor(image);
		imageGroup.addActor(nodeImage);

		//Sélection de la catégorie
		VerticalGroup categoryGroup = new VerticalGroup();
		Label category = new Label(Launcher.languageManager.getProperty("Global.Category"), skin);
		SelectNodeCategory categorySelect = new SelectNodeCategory(groupContent, skin, node);
		categorySelect.setName("node_category");
		categoryGroup.setName("node_category_group");
		categorySelect.setSelected(node.getCategory());
		categoryGroup.addActor(category);
		categoryGroup.addActor(categorySelect);

		//Zone du cout
		VerticalGroup coutGroup = new VerticalGroup();
		Label cout = new Label(Launcher.languageManager.getProperty("Global.Name"), skin);
		TextField coutField = new TextField(Integer.toString(node.getCout()), skin);
		coutField.setName("node_cout");
		coutGroup.setName("node_cout_group");
		coutGroup.addActor(cout);
		coutGroup.addActor(coutField);

		//Zone du unlock
		VerticalGroup unlockGroup = new VerticalGroup();
		Label unlock = new Label(Launcher.languageManager.getProperty("Global.Name"), skin);
		CheckBox unlockCheckBox = new CheckBox("", skin);
		unlockCheckBox.setChecked(node.isUnlock());
		unlockCheckBox.setName("node_unlock");
		unlockGroup.setName("node_unlock_group");
		unlockGroup.addActor(unlock);
		unlockGroup.addActor(unlockCheckBox);

		//Description
		VerticalGroup descriptionGroup = new VerticalGroup();
		Label description = new Label(Launcher.languageManager.getProperty("Global.Description"), skin);
		TextArea descriptionArea = new TextArea(node.getDescription(), skin);
		descriptionArea.setName("node_description");
		descriptionGroup.setName("node_description_group");
		descriptionArea.setPrefRows(5);
		descriptionGroup.addActor(description);
		descriptionGroup.addActor(descriptionArea);

		//Ajout des objets au groupe
		groupContent.addActor(nameGroup);
		groupContent.addActor(imageGroup);
		groupContent.addActor(categoryGroup);
		groupContent.addActor(coutGroup);
		groupContent.addActor(unlockGroup);
		groupContent.addActor(descriptionGroup);
		this.setActor(groupContent);

	}

}
