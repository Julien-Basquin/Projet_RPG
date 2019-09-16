package generateur.controller.button.dialog_button.entity_parameters.graph;

import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import generateur.Generator;
import generateur.Launcher;
import generateur.controller.button.entity_parameters.graph.Link;
import generateur.controller.button.entity_parameters.graph.node.Node;
import generateur.model.entity_parameters.EventsEnum;
import generateur.model.entity_parameters.stack.ObjectEvent;
import generateur.view.entity_parameters.middle.Graph;

/**
 * Bouton de réinitialisation du graphe des entités
 * 
 * @author Julien B.
 */

public class ResetGraphButton extends TextButton {
	private Logger logger = Logger.getLogger(ResetGraphButton.class);

	public ResetGraphButton(Skin skin) {
		super(Launcher.languageManager.getProperty("Global.Confirm"), skin);
		setName("confirm");
		
		addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);

				logger.debug("Cleaning entity graph...");
				Graph graph = (Graph) Generator.findActor("graph");
				Generator.previousStates.push(new ObjectEvent(new Graph(graph), EventsEnum.INIT + "_Graph"));
				ObjectEvent.incrGroupId();
				Generator.nextStates.clear();

				for (Entry<Integer, Link> link : graph.getLinkList().entrySet()) {
					link.getValue().remove();
				}
				graph.getLinkList().clear();
				
				for (Entry<Integer, Node> node : graph.getNodeList().entrySet()) {
					node.getValue().remove();
				}
				graph.getNodeList().clear();
				logger.debug("...cleaning completed");
				
				remove();
			}
			
		});
	}
}
