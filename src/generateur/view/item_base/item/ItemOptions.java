package generateur.view.item_base.item;

import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.utils.Align;

import generateur.Launcher;
import generateur.controller.button.item.ValueField;

public class ItemOptions extends Table {

	public ItemOptions(Skin skin) {
		super(skin);
		setName("object_contents");
		align(Align.topLeft);
		
		//Usability
		Label usable = new Label(Launcher.languageManager.getProperty("Object.Usable"), skin);
		usable.setAlignment(Align.center);
		Label inFightLabel = new Label(Launcher.languageManager.getProperty("Object.Usable.InFight"), skin);
		inFightLabel.setAlignment(Align.center);
		Label outFightLabel = new Label(Launcher.languageManager.getProperty("Object.Usable.OutFight"), skin);
		outFightLabel.setAlignment(Align.center);
		Label materialLabel = new Label(Launcher.languageManager.getProperty("Object.Usable.Material"), skin);
		materialLabel.setAlignment(Align.center);
		Label questLabel = new Label(Launcher.languageManager.getProperty("Object.Usable.Quest"), skin);
		questLabel.setAlignment(Align.center);
		
		CheckBox inFight = new CheckBox("", skin);
		CheckBox outFight = new CheckBox("", skin);
		CheckBox material = new CheckBox("", skin);
		CheckBox quest = new CheckBox("", skin);
		
		//Targets
		Label target = new Label(Launcher.languageManager.getProperty("Object.Target"), skin);
		target.setAlignment(Align.center);
		Label alliesLabel = new Label(Launcher.languageManager.getProperty("Object.Target.Allies"), skin);
		Label ennemiesLabel = new Label(Launcher.languageManager.getProperty("Object.Target.Ennemies"), skin);
		
		ValueField allies = new ValueField(skin);
		ValueField ennemies = new ValueField(skin);

		add(usable).width(Value.percentWidth(1/3f, this));
		row();
		add();
		add(inFightLabel).width(Value.percentWidth(1/6f, this));
		add(inFight).width(Value.percentWidth(1/12f, this));
		add().width(Value.percentWidth(1/6f, this));
		add(outFightLabel).width(Value.percentWidth(1/6f, this));
		add(outFight).width(Value.percentWidth(1/12f, this));
		row();
		add(null, materialLabel, material, null, questLabel, quest);
		
		row();
		
		add(target);
		row();
		add();
		add(alliesLabel);
		add(allies).width(Value.percentWidth(1/12f, this)).height(allies.getHeight());
		add(null, ennemiesLabel);
		add(ennemies).width(Value.percentWidth(1/12f, this)).height(allies.getHeight());
	}
}
