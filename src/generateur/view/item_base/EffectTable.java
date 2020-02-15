package generateur.view.item_base;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

import generateur.Launcher;
import generateur.MainWindow;
import generateur.controller.button.item.effect.AddEffect;

/**
 * Tableau des effets d'un objet
 * 
 * @author Julien B.
 */

public class EffectTable extends Table {

	public EffectTable(Skin skin) {
		super(skin);
		setName("effects_table");
		align(Align.topLeft);
		
		//Création des labels
		Label attributLabel = new Label(Launcher.languageManager.getProperty("Object.Effects.Attribute"), skin);
		attributLabel.setName("attribut_label");
		attributLabel.setAlignment(Align.center);
		
		Label triggerChangeLabel = new Label(Launcher.languageManager.getProperty("Object.Effects.Trigger"), skin);
		triggerChangeLabel.setName("trigger_chance_label");
		triggerChangeLabel.setAlignment(Align.center);
		
		Label minValueLabel = new Label(Launcher.languageManager.getProperty("Object.Effects.Min"), skin);
		minValueLabel.setName("min_value_label");
		minValueLabel.setAlignment(Align.center);
		
		Label maxValueLabel = new Label(Launcher.languageManager.getProperty("Object.Effects.Max"), skin);
		maxValueLabel.setName("max_value_label");
		maxValueLabel.setAlignment(Align.center);
		
		Label percentLabel = new Label("%", skin);
		percentLabel.setName("percent_label");
		percentLabel.setAlignment(Align.center);
		
		Label groupLabel = new Label(Launcher.languageManager.getProperty("Object.Effects.Group"), skin);
		groupLabel.setName("group_label");
		groupLabel.setAlignment(Align.center);
		
		Label activeLabel = new Label(Launcher.languageManager.getProperty("Object.Effects.Active"), skin);
		activeLabel.setName("active_label");
		activeLabel.setAlignment(Align.center);
		
		//Ajout des labels avec taille prédéfinie
		add(attributLabel).width(MainWindow.stage.getWidth() * 0.66f * 1/4f).center();
		add(triggerChangeLabel).width(MainWindow.stage.getWidth() * 0.66f * 1/8f).center();
		add(minValueLabel).width(MainWindow.stage.getWidth() * 0.66f * 1/8f).center();
		add(maxValueLabel).width(MainWindow.stage.getWidth() * 0.66f * 1/8f).center();
		add(percentLabel).width(MainWindow.stage.getWidth() * 0.66f * 1/16f).center().grow();
		add(groupLabel).width(MainWindow.stage.getWidth() * 0.66f * 1/8f).center();
		add(activeLabel).width(MainWindow.stage.getWidth() * 0.66f * 1/8f).center();
		//Préparation de la dernière colonne avec un cellule vide
		add().width(MainWindow.stage.getWidth() * 0.66f * 1/16f).center().grow();
		
		row();
		
		AddEffect addEffectButton = new AddEffect(this, skin);
		add(addEffectButton).width(MainWindow.stage.getWidth() * 0.66f * 1/4f).center();
		//Ajout de cases vides pour préparer la ligne
		for (int i = 1; i < getColumns(); i++) {
			add();
		}

	}
}
