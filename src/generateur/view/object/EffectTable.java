package generateur.view.object;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.utils.Align;
import generateur.Launcher;
import generateur.controller.button.object.effect.AddEffect;

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
		debugAll();
		
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
		add(attributLabel).width(Value.percentWidth(1/8f, this));
		add(triggerChangeLabel).width(Value.percentWidth(1/8f, this));
		add(minValueLabel).width(Value.percentWidth(1/8f, this));
		add(maxValueLabel).width(Value.percentWidth(1/8f, this));
		add(percentLabel).width(Value.percentWidth(1/8f, this));
		add(groupLabel).width(Value.percentWidth(1/8f, this));
		add(activeLabel).width(Value.percentWidth(1/8f, this));
		//Préparation de la dernière colonne avec un cellule vide
		add();
		
		row();
		
		AddEffect addEffectButton = new AddEffect(this, skin);
		add(addEffectButton).width(Value.percentWidth(1/8f, this));
		//Ajout de cases vides pour préparer la ligne
		for (int i = 1; i < getColumns(); i++) {
			add();
		}

	}
}
