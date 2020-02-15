package generateur.view.item_base.armor;

import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

import generateur.Launcher;
import generateur.controller.button.item.ValueField;

public class ArmorOptions extends Table {
	public ArmorOptions (Skin skin) {
		super(skin);
		setName("armor_contents");
		align(Align.topLeft);

		//Targets
		Label physicalDefenseLabel = new Label(Launcher.languageManager.getProperty("Stats.PhysicalDefense"), skin);
		Label magicalDefenseLabel = new Label(Launcher.languageManager.getProperty("Stats.MagicalDefense"), skin);
		Label questLabel = new Label(Launcher.languageManager.getProperty("Object.Usable.Quest"), skin);
		
		ValueField physicalDefense = new ValueField(skin);
		ValueField magicalDefense = new ValueField(skin);
		CheckBox quest = new CheckBox("", skin);

		add(physicalDefenseLabel);
		add(physicalDefense);
		row();
		add(magicalDefenseLabel);
		add(magicalDefense);
		row();
		add(questLabel);
		add(quest);
		row();
	}
}
