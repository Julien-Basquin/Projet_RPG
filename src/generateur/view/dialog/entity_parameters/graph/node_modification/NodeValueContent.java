package generateur.view.dialog.entity_parameters.graph.node_modification;

import org.apache.log4j.Logger;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

import generateur.Generator;
import generateur.Launcher;
import generateur.controller.button.entity_parameters.graph.node.Node;

public class NodeValueContent extends ScrollPane {
	private final Logger logger = Logger.getLogger(NodeValueContent.class);
	private NodeSplitPane nodeSplitPane;
	private Skin skin;
	private VerticalGroup groupContent;
	public NodeValueContent(Skin skin,Node node) {
		super(null, skin);
		this.skin = skin;

		nodeSplitPane = ((NodeSplitPane)Generator.findActor("node_global_pane"));

		groupContent = new VerticalGroup();
		groupContent.setName("group_node_content");


		addListener(new ChangeListener() {

			@Override
			public void changed(ChangeEvent event, Actor actor) {
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
			}
		});		
		}

		public void nodeAttribut(Node node) {

			//Zone du nom
			VerticalGroup nameGroup = new VerticalGroup();
			Label name = new Label(Launcher.languageManager.getProperty("Global.Name"), skin);
			TextField nameField = new TextField(node.getName(), skin);
			nameField.setName("node_value_name");
			nameGroup.addActor(name);
			nameGroup.addActor(nameField);

			groupContent.addActor(nameGroup);
			this.setActor(groupContent);
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
			this.setActor(groupContent);
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
			this.setActor(groupContent);
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
			this.setActor(groupContent);
		}

	}
