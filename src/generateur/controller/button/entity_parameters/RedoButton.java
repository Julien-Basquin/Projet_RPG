package generateur.controller.button.entity_parameters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import generateur.Generator;
import generateur.Launcher;
import generateur.model.entity_parameters.EventsEnum;
import generateur.model.entity_parameters.stack.ObjectEvent;

/**
 * Bouton permettant de réappliquer une action annulée.
 * 
 * @author Julien B.
 */

public class RedoButton extends TextButton {

	public RedoButton(Skin skin) {
		super(Launcher.languageManager.getProperty("Global.Redo"), skin);
		setName("redo");
		
		addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (!Generator.nextStates.isEmpty()) {
					ObjectEvent objectEvent = Generator.nextStates.peek();
					Pattern pattern = Pattern.compile("([A-Z]+)_([A-Z][a-z]+)");
					Matcher match;
					
					for (ObjectEvent obj : Generator.nextStates.searchByGroup(objectEvent.getGroupId())) {
						match = pattern.matcher(obj.getEvent());
						
						if (match.find()) {
							Generator.nextStates.peek().getObject().redo(EventsEnum.valueOf(match.group(1)));
						}
					}
				}
			}
			
		});
	}

}
