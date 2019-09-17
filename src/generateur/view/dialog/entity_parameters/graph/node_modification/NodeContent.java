package generateur.view.dialog.entity_parameters.graph.node_modification;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;

import generateur.Launcher;
import generateur.controller.button.entity_parameters.graph.node.Node;
import generateur.controller.select.SelectNodeCategory;

public class NodeContent extends ScrollPane {

	public NodeContent(Skin skin,Node node) {
		super(null, skin);
		
		Node nodeCopie = new Node(node);
		setName("node_content");
		
		VerticalGroup groupContent = new VerticalGroup();
		groupContent.setName("group_node_content");

		//Zone du nom
		VerticalGroup nameGroup = new VerticalGroup();
		Label name = new Label(Launcher.languageManager.getProperty("Global.Name"), skin);
		TextField nameField = new TextField(node.getName(), skin);
		nameField.setName("node_name");
		nameGroup.addActor(name);
		nameGroup.addActor(nameField);

		//Sélection de la catégorie
		VerticalGroup categoryGroup = new VerticalGroup();
		Label category = new Label(Launcher.languageManager.getProperty("Global.Category"), skin);
		SelectNodeCategory categorySelect = new SelectNodeCategory(groupContent, skin, nodeCopie);
		categorySelect.setName("node_category");
		categorySelect.setSelected(node.getCategory());
		categoryGroup.addActor(category);
		categoryGroup.addActor(categorySelect);
		

		//Ajout des objets au groupe
		groupContent.addActor(nameGroup);
		groupContent.addActor(categoryGroup);
		this.setActor(groupContent);

	}

}
