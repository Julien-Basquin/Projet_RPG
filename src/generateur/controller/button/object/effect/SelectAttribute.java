package generateur.controller.button.object.effect;

import java.util.List;

import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import app.model.enumeration.attribut.AttributsEnum;

public class SelectAttribute extends SelectBox<AttributsEnum> {
	private static List<AttributsEnum> usedAttributes;

	public SelectAttribute(Skin skin) {
		super(skin);
		
		AttributsEnum[] toAdd = new AttributsEnum[AttributsEnum.values().length];
		
		int i = 0;
		for (AttributsEnum attribute : AttributsEnum.values()) {
			if (!usedAttributes.contains(attribute)) {
				toAdd[i++] = attribute;
			}
		}
		
		setItems(toAdd);
	}
}
