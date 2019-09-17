package generateur.view.dialog.entity_parameters.graph;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import generateur.Launcher;
import generateur.controller.button.dialog_button.CancelButton;
import generateur.controller.button.entity_parameters.graph.node.Node;
import generateur.view.dialog.entity_parameters.graph.node_modification.NodeSplitPane;

public class NodeModificationDialogue extends Dialog {

	public NodeModificationDialogue(Skin skin,Node node) {
		super(Launcher.languageManager.getProperty("Global.Confirm"), skin);
		//Récupération de la résolution active
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();

		//set la taille de la fenêtre
		setSize(width / 1.5f, height / 1.5f);
		setPosition(width / 2 - getWidth() / 2, height / 2 - getHeight() / 2);		

		NodeSplitPane nodeSplitPane = new NodeSplitPane(skin, node);
		//nodeSplitPane.setFillParent(true);
		nodeSplitPane.setPosition(getX(), getY());
		nodeSplitPane.setSize(getWidth(), getHeight()-getButtonTable().getPrefHeight()-this.getTitleTable().getPrefHeight());
		addActor(nodeSplitPane);
		
		//Ajout des boutons à la fenêtre de dialogue
		button(new CancelButton(skin));
		
		//this.getButtonTable().setZIndex(99);
		
	}

}
