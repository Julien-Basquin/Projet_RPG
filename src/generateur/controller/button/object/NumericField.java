package generateur.controller.button.object;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

/**
 * Champ ne pouvant contenir que des nombres
 * 
 * @author Julien B.
 */

public class NumericField extends TextField {
	private boolean isPourcent;

	public NumericField(Skin skin) {
		super("", skin);
		
		addListener(new TextFieldClickListener() {

			@Override
			public boolean keyTyped(InputEvent event, char character) {
				if (Character.isDigit(character)) {
					return super.keyTyped(event, character);
				}
				
				return false;
			}
			
		});
	}

	public boolean isPourcent() {
		return isPourcent;
	}

	public void setPourcent(boolean isPourcent) {
		this.isPourcent = isPourcent;
	}
	
	
}
