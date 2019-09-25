package generateur.view.object;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import generateur.Launcher;

public class ObjectContents extends ScrollPane {

	public ObjectContents(Skin skin) {
		super(null, skin);
		setName("object_contents");
		
		//Usability
		Label usable = new Label(Launcher.languageManager.getProperty("Object.Usable"), skin);
		CheckBox inFight = new CheckBox(Launcher.languageManager.getProperty("Object.Usable.InFight"), skin);
		CheckBox outFight = new CheckBox(Launcher.languageManager.getProperty("Object.Usable.OutFight"), skin);
		CheckBox material = new CheckBox(Launcher.languageManager.getProperty("Object.Usable.Material"), skin);
		CheckBox quest = new CheckBox(Launcher.languageManager.getProperty("Object.Usable.Quest"), skin);
		
		//Targets
		Label target = new Label(Launcher.languageManager.getProperty("Object.Target"), skin);
		CheckBox ally = new CheckBox(Launcher.languageManager.getProperty("Object.Target.Ally"), skin);
		CheckBox ennemy = new CheckBox(Launcher.languageManager.getProperty("Object.Target.Ennemy"), skin);
		CheckBox allies = new CheckBox(Launcher.languageManager.getProperty("Object.Target.Allies"), skin);
		CheckBox ennemies = new CheckBox(Launcher.languageManager.getProperty("Object.Target.Ennemies"), skin);
	}
}
