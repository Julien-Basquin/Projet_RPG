package generateur.controller.button.item;

import java.io.ObjectInputStream.GetField;

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
		setText("0");
		setHeight(this.getStyle().font.getCapHeight() * 2);
		
		setTextFieldFilter(new TextFieldFilter.DigitsOnlyFilter());
	}

	public boolean isPourcent() {
		return isPourcent;
	}

	public void setPourcent(boolean isPourcent) {
		this.isPourcent = isPourcent;
	}
	
	
}
