package generateur.view.dialog.entity_parameters.graph.node_modification;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;

import generateur.Generator;
import generateur.controller.button.entity_parameters.graph.node.Node;
import generateur.controller.button.entity_parameters.graph.node.NodeAttribut;
import generateur.controller.button.entity_parameters.graph.node.NodeCompetence;
import generateur.controller.button.entity_parameters.graph.node.NodeEquipement;
import generateur.controller.button.entity_parameters.graph.node.NodeStatistique;
import generateur.model.entity_parameters.EventsEnum;
import generateur.model.entity_parameters.stack.ObjectEvent;
import generateur.view.global_parameters.GlobalParametersContents;

public class NodeSplitPane extends SplitPane {

	public NodeSplitPane(Skin skin, Node node) {
		super(null, null, false, skin);
		Node nodeCopie=null;
		
		switch (node.getCategory()) {
		case STATISTIQUE:
			nodeCopie = new NodeStatistique(node);
			break;
		case EQUIPEMENT:
			nodeCopie = new NodeEquipement(node);
			break;
		case ATTRIBUT:
			nodeCopie = new NodeAttribut(node);
			break;
		case COMPETENCE:
			nodeCopie = new NodeCompetence(node);
			break;
		default:
			break;
		}
		setName("node_global_pane");
		
		NodeContent nodeContent = new NodeContent(skin, nodeCopie);
		nodeContent.setName("node_content");
		this.setFirstWidget(nodeContent);
		
		NodeValueContent nodeValueContent = new NodeValueContent(skin, nodeCopie);
		nodeValueContent.setName("node_value_content");
		setSecondWidget(nodeValueContent);
		
		//Verrouillage de la barre de séparation (empêche de changer la taille des conteneurs)
		this.setMinSplitAmount(0.5f);
		this.setSplitAmount(0.5f);
		this.setMaxSplitAmount(0.5f);
	}
	
	public void dispose() {
		((GlobalParametersContents) findActor("global_contents")).dispose();
	}
}
