package generateur.view.entity_parameters.middle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import generateur.Generator;
import generateur.controller.draganddrop.entity_parameters.DragAndDropNode;
import generateur.view.entity_parameters.bottom.EntityParametersBottomPane;

/**
 * Conteneur des informations moyennes de l'interface des entités.
 * Contient les noeuds sélectionnables et le graphe.
 * 
 * @author Julien B.
 */

public class EntityParametersMiddlePane extends SplitPane {

	public EntityParametersMiddlePane(Skin skin) {
		super(new EntityParametersNodeColumn(skin), new EntityParametersBottomPane(skin), false, skin);
		setName("entity_middle_pane");
		
		//Espace de séparation entre les noeuds sélectionnables
		((VerticalGroup) findActor("entity_node_column")).space(this.getHeight() / 3);
		
		//Verrouillage de la barre de séparation (empêche de changer la taille des conteneurs)
		float prefWidth = ((VerticalGroup) findActor("entity_node_column")).getPrefWidth();
		float splitPosition = (Gdx.graphics.getWidth() * (1 - Generator.generatorWindow.getSplitAmount()));
		this.setMinSplitAmount(prefWidth / splitPosition);
		this.setSplitAmount(prefWidth / splitPosition);
		this.setMaxSplitAmount(prefWidth / splitPosition);
		
		//Initialisation du drag and drop des noeuds
		new DragAndDropNode(findActor("entity_node_column"), ((SplitPane) findActor("entity_bottom_pane")).findActor("graph"));
	}
}
