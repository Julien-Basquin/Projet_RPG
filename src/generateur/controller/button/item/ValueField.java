package generateur.controller.button.item;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;

public class ValueField extends SplitPane {
	private NumericField field;
	private NumericPlus plus;
	private NumericMinus minus;
	
	
	public ValueField(Skin skin) {
		super(null, null, false, skin);
		
		field = new NumericField(skin);
		plus = new NumericPlus(field, skin);
		minus = new NumericMinus(field, skin);
		
		float width = field.getWidth() / 4;
		float height = field.getHeight() / 2;
		if (width == 0) {
			width = field.getPrefWidth() / 4;
		}
		if (height == 0) {
			height = field.getPrefHeight() / 2;
		}
		plus.setSize(width, height);
		minus.setSize(width, height);
		
		setSize(field.getWidth() + width, field.getHeight());
		setFirstWidget(field);
		
		SplitPane secondWidget = new SplitPane(plus, minus, true, skin);
		secondWidget.setSize(width, field.getHeight());
		setSecondWidget(secondWidget);
	}
}
