package generateur.view.dialog.entity_parameters.graph.node_modification;

import org.apache.log4j.Logger;

import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;

import generateur.Launcher;
import generateur.controller.button.entity_parameters.graph.node.Node;
import util.ActorActions;

public class NodeValueContent extends ScrollPane {
	private final Logger logger = Logger.getLogger(NodeValueContent.class);
	private Skin skin;
	private VerticalGroup groupContent;
	public NodeValueContent(Skin skin,Node node) {
		super(null, skin);
		this.skin = skin;

		nodeSplitPane = ((NodeSplitPane) ActorActions.findActor(Generator.stage, "node_global_pane"));

		groupContent = new VerticalGroup();
		groupContent.setName("group_node_content");

		switch(node.getCategory()) {
		case ATTRIBUT:
			nodeAttribut(node);
			logger.debug("set attribut  data...");
			break;
		case COMPETENCE:
			nodeCompetence(node);
			logger.debug("set competence  data...");
			break;
		case EQUIPEMENT:
			nodeEquipement(node);
			logger.debug("set equipement  data...");
			break;
		case STATISTIQUE:
			nodeStatistique(node);
			logger.debug("set statistique  data...");
			break;
		default:
			logger.debug("set default  data...");
			break;
		}	

		this.setActor(groupContent);
	}

	public void update(Node node) {
		groupContent.clear();
		switch(node.getCategory()) {
		case ATTRIBUT:
			nodeAttribut(node);
			logger.debug("set attribut  data...");
			break;
		case COMPETENCE:
			nodeCompetence(node);
			logger.debug("set competence  data...");
			break;
		case EQUIPEMENT:
			nodeEquipement(node);
			logger.debug("set equipement  data...");
			break;
		case STATISTIQUE:
			nodeStatistique(node);
			logger.debug("set statistique  data...");
			break;
		default:
			logger.debug("set default  data...");
			break;
		}	

		this.setActor(groupContent);
	}

	public void nodeAttribut(Node node) {
		//Sélection de l'élément
		VerticalGroup elementGroup = new VerticalGroup();
		Label element = new Label(Launcher.languageManager.getProperty("Global.Category"), skin);
		SelectNodeCategory elementSelect = new SelectNodeCategory(groupContent, skin, node);
		elementSelect.setName("node_element");
		elementGroup.setName("node_element_group");
		elementSelect.setSelected(node.getCategory());
		elementGroup.addActor(element);
		elementGroup.addActor(elementSelect);

		//Zone de la Valeur
		VerticalGroup valueGroup = new VerticalGroup();
		Label value = new Label(Launcher.languageManager.getProperty("Global.Name"), skin);
		TextField valueField = new TextField("", skin);
		valueField.setName("node_value");
		valueGroup.setName("node_value_group");
		valueGroup.addActor(value);
		valueGroup.addActor(valueField);

		//Zone du pourcentage
		VerticalGroup percentGroup = new VerticalGroup();
		Label percent = new Label(Launcher.languageManager.getProperty("Global.Name"), skin);
		CheckBox percentCheckBox = new CheckBox("", skin);
		//percentCheckBox.setChecked(((TypeNodeAttribut)node.getTypeNode()).isPercent());
		percentCheckBox.setName("node_percent");
		percentGroup.setName("node_percent_group");
		percentGroup.addActor(percent);
		percentGroup.addActor(percentCheckBox);
	}

	public void nodeCompetence(Node node) {

		//Zone du nom
		VerticalGroup nameGroup = new VerticalGroup();
		Label name = new Label(Launcher.languageManager.getProperty("Global.Name"), skin);
		TextField nameField = new TextField(node.getName(), skin);
		nameField.setName("node_value_name");
		nameGroup.addActor(name);
		nameGroup.addActor(nameField);

		groupContent.addActor(nameGroup);
	}

	public void nodeEquipement(Node node) {

		//Zone du nom
		VerticalGroup nameGroup = new VerticalGroup();
		Label name = new Label(Launcher.languageManager.getProperty("Global.Name"), skin);
		TextField nameField = new TextField(node.getName(), skin);
		nameField.setName("node_value_name");
		nameGroup.addActor(name);
		nameGroup.addActor(nameField);

		groupContent.addActor(nameGroup);
	}

	public void nodeStatistique(Node node) {

		//Zone du nom
		VerticalGroup nameGroup = new VerticalGroup();
		Label name = new Label(Launcher.languageManager.getProperty("Global.Name"), skin);
		TextField nameField = new TextField(node.getName(), skin);
		nameField.setName("node_value_name");
		nameGroup.addActor(name);
		nameGroup.addActor(nameField);

		groupContent.addActor(nameGroup);
	}

}
