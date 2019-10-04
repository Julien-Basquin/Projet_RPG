package generateur.view.item;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.utils.Align;

import generateur.Launcher;
import generateur.controller.button.item.ValueField;

public class ItemSpecialOptions extends Table {

	public ItemSpecialOptions(String option, Skin skin) {
		super(skin);
		setName("item_special_options");
		align(Align.topLeft);
		
		String cristal = Launcher.languageManager.getProperty("Object.Cristal");
		String scroll = Launcher.languageManager.getProperty("Object.Scroll");
		
		if (option.equalsIgnoreCase(cristal)) {
			Label cristalLabel = new Label(Launcher.languageManager.getProperty("Object.Cristal"), skin);
			Label nbChargeLabel = new Label(Launcher.languageManager.getProperty("Object.Cristal.Charge"), skin);
			Label manaPerChargeLabel = new Label(Launcher.languageManager.getProperty("Object.Cristal.Cost"), skin);
			ValueField nbCharge = new ValueField(skin);
			ValueField manaPerCharge = new ValueField(skin);
			
			add(cristalLabel).width(Value.percentWidth(1/3f, this));
			add(nbChargeLabel).width(Value.percentWidth(1/6f, this));
			add(nbCharge).width(Value.percentWidth(1/12f, this));
			add().width(Value.percentWidth(1/6f, this));
			add(manaPerChargeLabel).width(Value.percentWidth(1/6f, this));
			add(manaPerCharge).width(Value.percentWidth(1/12f, this));
		} else if (option.equalsIgnoreCase(scroll)) {
			Label scrollLabel = new Label(Launcher.languageManager.getProperty("Object.Scroll"), skin);
			Label incantationLabel = new Label(Launcher.languageManager.getProperty("Object.Scroll.Incantation"), skin);
			ValueField incantation = new ValueField(skin);
			
			add(scrollLabel).width(Value.percentWidth(1/3f, this));
			add(incantationLabel).width(Value.percentWidth(1/6f, this));
			add(incantation).width(Value.percentWidth(1/12f, this));
		}
	}
}
