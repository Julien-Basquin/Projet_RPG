package generateur.controller.button.object.effect;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class RemoveEffect extends TextButton {

	public RemoveEffect(Skin skin) {
		super("-", skin);
		
		addListener(new ClickListener() {

			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				//TODO Gérer la suppression d'un effet
			}
			
		});
	}

}
