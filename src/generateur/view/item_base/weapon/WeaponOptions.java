package generateur.view.item_base.weapon;

import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

import generateur.Launcher;
import generateur.controller.button.item.ValueField;

public class WeaponOptions extends Table {
	public WeaponOptions (Skin skin) {
		super(skin);
		setName("weapon_contents");
		align(Align.topLeft);

		//Targets
		Label minDamageLabel = new Label(Launcher.languageManager.getProperty("Stats.MinDamage"), skin);
		Label maxDamageLabel = new Label(Launcher.languageManager.getProperty("Stats.MaxDamage"), skin);
		Label questLabel = new Label(Launcher.languageManager.getProperty("Object.Usable.Quest"), skin);
		
		ValueField minDamage = new ValueField(skin);
		ValueField maxDamage = new ValueField(skin);
		CheckBox quest = new CheckBox("", skin);

		add(minDamageLabel);
		add(minDamage);
		row();
		add(maxDamageLabel);
		add(maxDamage);
		row();
		add(questLabel);
		add(quest);
	}
}
