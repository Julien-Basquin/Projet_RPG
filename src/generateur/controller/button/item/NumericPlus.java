package generateur.controller.button.item;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class NumericPlus extends TextButton {

	public NumericPlus(NumericField field, Skin skin) {
		super("+", skin);
		
		addListener(new ClickListener() {

			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				
				if (field.getText().isEmpty()) {
					field.setText("1");
				} else {
//					if (!field.isPourcent() || field.isPourcent() && Integer.parseInt(field.getText()) < 100) {
						field.setText(String.valueOf(Integer.parseInt(field.getText()) + 1));
//					}
				}
			}
			
		});
	}

}
