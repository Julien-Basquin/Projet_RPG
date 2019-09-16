package generateur.view.entity_parameters.bottom;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.utils.Disposable;

import generateur.view.entity_parameters.middle.Graph;

/**
 * Conteneur des informations basses de l'interface des entités.
 * Contient le graphe et les informations des noeuds contenus.
 * 
 * @author Julien B.
 */

public class EntityParametersBottomPane extends SplitPane implements Disposable {

	public EntityParametersBottomPane(Skin skin) {
		super(new Graph(), new EntityParametersStats(skin), true, skin);
		setName("entity_bottom_pane");
		
		//TODO Gérer la séparation du splitpane
	}

	@Override
	public void dispose() {
		((Graph) findActor("graph")).dispose();
		
//		for (EntityParametersGraph state : EntityParametersGraph.getPreviousStates()) {
//			state.dispose();
//		}
//		
//		for (EntityParametersGraph state : EntityParametersGraph.getNextStates()) {
//			state.dispose();
//		}
		
//		EntityParametersGraph.getPreviousStates().clear();
//		EntityParametersGraph.getNextStates().clear();
		
//		((EntityParametersStats) findActor("entity_stats")).dispose();
	}
}
