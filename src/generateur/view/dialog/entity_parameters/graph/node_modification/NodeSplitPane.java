package generateur.view.dialog.entity_parameters.graph.node_modification;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.utils.Align;

import generateur.controller.button.entity_parameters.graph.node.Node;
import generateur.view.global_parameters.GlobalParametersContents;

public class NodeSplitPane extends SplitPane {

	public NodeSplitPane(Skin skin, Node node) {
		super(new NodeContent(skin, node), null, false, skin);
		setName("node_global_pane");
		
		//Verrouillage de la barre de séparation (empêche de changer la taille des conteneurs)
		this.setMinSplitAmount(1/3);
		this.setSplitAmount(1/3);
		this.setMaxSplitAmount(1/3);
	}
	
	public void dispose() {
		((GlobalParametersContents) findActor("global_contents")).dispose();
	}
}
