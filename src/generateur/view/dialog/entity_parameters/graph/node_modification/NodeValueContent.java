package generateur.view.dialog.entity_parameters.graph.node_modification;

import javax.swing.event.ChangeEvent;

import org.apache.log4j.Logger;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import app.model.enumeration.CategorieEnum;
import generateur.Launcher;
import generateur.controller.button.entity_parameters.graph.node.Node;
import generateur.controller.select.SelectCategory;
import generateur.controller.select.SelectEquipementCategorieNode;
import generateur.controller.select.SelectNodeCategory;
import generateur.controller.select.StringSelectBox;

public class NodeValueContent extends ScrollPane {
	private final Logger logger = Logger.getLogger(NodeValueContent.class);
	private Skin skin;
	private VerticalGroup groupContent;
	public NodeValueContent(Skin skin,Node node) {
		super(null, skin);
		this.skin = skin;

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

		groupContent.addActor(elementGroup);
		groupContent.addActor(valueGroup);
		groupContent.addActor(percentGroup);
	}

	public void nodeCompetence(Node node) {

		//Zone du nom
		VerticalGroup nameGroup = new VerticalGroup();
		Label name = new Label("TODO", skin);

		nameGroup.addActor(name);

		groupContent.addActor(nameGroup);
	}

	public void nodeEquipement(Node node) {

		//Sélection de la catégorie
		VerticalGroup categoryGroup = new VerticalGroup();
		Label category = new Label(Launcher.languageManager.getProperty("Global.Category"), skin);
		SelectEquipementCategorieNode categorySelect = new SelectEquipementCategorieNode(groupContent, skin);
		categorySelect.setName("category_equipement_node");
		categorySelect.setItems(CategorieEnum.ARME, CategorieEnum.ARMURE, CategorieEnum.ACCESSORY);
		categoryGroup.addActor(category);
		categoryGroup.addActor(categorySelect);

		//Sélection de la sous-catégorie
		VerticalGroup subcategoryGroup = new VerticalGroup();
		Label subcategory = new Label(Launcher.languageManager.getProperty("Global.Sub.Category"), skin);
		StringSelectBox subcategorySelect = new StringSelectBox(null, skin);
		subcategorySelect.setName("subcategory_node");
		subcategoryGroup.addActor(subcategory);
		subcategoryGroup.addActor(subcategorySelect);

		//Séléction des informations complémentaires pour les armes et les armures
		VerticalGroup typeGroup = new VerticalGroup();
		Label type = new Label(Launcher.languageManager.getProperty("Global.Type"), skin);
		StringSelectBox typeSelect = new StringSelectBox(skin);
		typeSelect.setName("type_node");
		typeGroup.addActor(type);
		typeGroup.addActor(typeSelect);

		//Zone du pourcentage
		VerticalGroup bonusGroupe = new VerticalGroup();
		Label bonus = new Label(Launcher.languageManager.getProperty("Global.Name"), skin);
		CheckBox bonusCheckBox = new CheckBox("", skin);
		//percentCheckBox.setChecked(((TypeNodeAttribut)node.getTypeNode()).isPercent());
		bonusCheckBox.setName("node_equipe");
		bonusGroupe.setName("node_equipe_group");
		bonusGroupe.addActor(bonus);
		bonusGroupe.addActor(bonusCheckBox);

		//Zone du pourcentage
		VerticalGroup bonusValeurGroupe = new VerticalGroup();
		Label bonusValeur = new Label(Launcher.languageManager.getProperty("Global.Name"), skin);
		TextField bonusValeurCheckBox = new TextField("", skin);
		//percentCheckBox.setChecked(((TypeNodeAttribut)node.getTypeNode()).isPercent());
		bonusCheckBox.setName("node_equipe");
		bonusValeurGroupe.setName("node_equipe_group");
		bonusValeurGroupe.addActor(bonusValeur);
		bonusValeurGroupe.addActor(bonusValeurCheckBox);

		groupContent.addActor(categoryGroup);
		groupContent.addActor(subcategoryGroup);
		groupContent.addActor(typeGroup);
		groupContent.addActor(bonusGroupe);
		groupContent.addActor(bonusValeurGroupe);
		categorySelect.fire(new ChangeListener.ChangeEvent());
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
