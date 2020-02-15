package generateur.controller.button.item.effect;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import app.model.enumeration.attribut.AttributsEnum;
import generateur.MainWindow;
import generateur.controller.button.item.ValueField;
import util.Converter;

/**
 * Bouton d'ajout des effets d'un objet
 * 
 * @author Julien B.
 */

public class AddEffect extends TextButton {

	public AddEffect(Table table, Skin skin) {
		super("+", skin);
//		setStyle(skin.get(EffectTableButtonStyle.class));
		setName("add_effect");
		
		addListener(new ClickListener() {

			//SuppressWarnings car un seul type récupérable
			@SuppressWarnings("unchecked")
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				
				SelectBox<String> selectAttribute = new SelectBox<String>(skin);
				selectAttribute.setName("select_attribute_" + (table.getRows() - 1));
				selectAttribute.setItems(Converter.enumToStringArray(AttributsEnum.class));
				
				ValueField triggerChance = new ValueField(skin);
				triggerChance.setName("trigger_chance_" + (table.getRows() - 1));
				
				ValueField minValue = new ValueField(skin);
				minValue.setName("min_value_" + (table.getRows() - 1));
				
				ValueField maxValue = new ValueField(skin);
				maxValue.setName("max_value_" + (table.getRows() - 1));
				
				CheckBox percent = new CheckBox("", skin);
				percent.setName("percent_" + (table.getRows() - 1));
				
				ValueField group = new ValueField(skin);
				group.setName("group_" + (table.getRows() - 1));
				
				ValueField active = new ValueField(skin);
				active.setName("active_" + (table.getRows() - 1));
				
				RemoveEffect removeEffect = new RemoveEffect(table, skin);
				removeEffect.setName("remove_effect_" + (table.getRows() - 1));
				
				int cellNumber = table.getCell(table.findActor("add_effect")).getRow() * table.getColumns() + table.getCell(AddEffect.this).getColumn();
				
				table.getCells().get(cellNumber).setActor(selectAttribute).width(MainWindow.stage.getWidth() * 0.66f * 1/4f).center();
				table.getCells().get(cellNumber + 1).setActor(triggerChance).width(MainWindow.stage.getWidth() * 0.66f * 1/8f).center();
				table.getCells().get(cellNumber + 2).setActor(minValue).width(MainWindow.stage.getWidth() * 0.66f * 1/8f).center();
				table.getCells().get(cellNumber + 3).setActor(maxValue).width(MainWindow.stage.getWidth() * 0.66f * 1/8f).center();
				table.getCells().get(cellNumber + 4).setActor(percent).width(MainWindow.stage.getWidth() * 0.66f * 1/16f).center().grow();
				table.getCells().get(cellNumber + 5).setActor(group).width(MainWindow.stage.getWidth() * 0.66f * 1/8f).center();
				table.getCells().get(cellNumber + 6).setActor(active).width(MainWindow.stage.getWidth() * 0.66f * 1/8f).center();
				table.getCells().get(cellNumber + 7).setActor(removeEffect).width(MainWindow.stage.getWidth() * 0.66f * 1/16f).center().grow();
				
				table.row();
				
				AddEffect addEffectButton = AddEffect.this;
				table.add(addEffectButton).width(MainWindow.stage.getWidth() * 0.66f * 1/4f).center();
				for (int i = 1; i < table.getColumns(); i++) {
					table.add();
				}
			}
			
		});
	}

}
