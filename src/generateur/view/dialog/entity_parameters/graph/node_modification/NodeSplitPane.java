package generateur.view.dialog.entity_parameters.graph.node_modification;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;

import generateur.controller.button.entity_parameters.graph.node.Node;
import generateur.view.global_parameters.GlobalParametersContents;

public class NodeSplitPane extends SplitPane {

	public NodeSplitPane(Skin skin, Node node) {
		super(null, null, false, skin);
		Node nodeCopie = new Node(node);
		setName("node_global_pane");
		
		NodeContent nodeContent = new NodeContent(skin, nodeCopie);
		nodeContent.setName("node_content");
		this.setFirstWidget(nodeContent);
		
		//Verrouillage de la barre de séparation (empêche de changer la taille des conteneurs)
		this.setMinSplitAmount(0.33f);
		this.setSplitAmount(0.33f);
		this.setMaxSplitAmount(0.33f);
	}
	
	public void dispose() {
		((GlobalParametersContents) findActor("global_contents")).dispose();
	}
}
