package generateur.view.entity_parameters.bottom;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;

import generateur.view.entity_parameters.middle.EntityParametersGraph;

/**
 * Conteneur des informations basses de l'interface des entités.
 * Contient le graphe et les informations des noeuds contenus.
 * 
 * @author Julien B.
 */

public class EntityParametersBottomPane extends SplitPane {

	public EntityParametersBottomPane(Skin skin) {
		super(new EntityParametersGraph(), new EntityParametersStats(skin), true, skin);
		setName("entity_bottom_pane");
		
		((EntityParametersGraph) findActor("graph")).addMoveNodeController();
		//TODO Gérer la séparation du splitpane
	}

}
