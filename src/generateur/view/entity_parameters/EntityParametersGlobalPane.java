package generateur.view.entity_parameters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.utils.Disposable;

import generateur.view.entity_parameters.middle.EntityParametersMiddlePane;
import generateur.view.entity_parameters.top.EntityParametersTopPane;

/**
 * Conteneur global de l'interface de création des entités.
 * 
 * @author Julien B.
 */

public class EntityParametersGlobalPane extends SplitPane implements Disposable {

	public EntityParametersGlobalPane(Skin skin) {
		super(new EntityParametersTopPane(skin), new EntityParametersMiddlePane(skin), true, skin);
		setName("entity_pane");
		
		//Verrouillage de la barre de séparation (empêche de changer la taille des conteneurs)
		float splitAmount = ((SplitPane) findActor("entity_top_pane")).getPrefHeight();
		this.setMinSplitAmount(splitAmount / Gdx.graphics.getHeight());
		this.setSplitAmount(splitAmount / Gdx.graphics.getHeight());
		this.setMaxSplitAmount(splitAmount / Gdx.graphics.getHeight());
	}

	public void dispose() {
		((EntityParametersMiddlePane) findActor("entity_middle_pane")).dispose();
		
		remove();
	}
}
