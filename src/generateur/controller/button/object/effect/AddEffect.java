package generateur.controller.button.object.effect;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import app.model.enumeration.attribut.AttributsEnum;
import generateur.controller.button.object.ValueField;
import util.Converter;

public class AddEffect extends TextButton {

	public AddEffect(Table table, Skin skin) {
		super("+", skin);
		setName("add_effect");
		
		addListener(new ClickListener() {

			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				
				SelectBox<String> selectAttribute = new SelectBox<String>(skin);
				selectAttribute.setName("select_attribute_" + table.getRows());
				selectAttribute.setItems(Converter.enumToStringArray(AttributsEnum.class));
				
				ValueField triggerChance = new ValueField(skin);
				triggerChance.setName("trigger_chance_" + table.getRows());
				
				ValueField minValue = new ValueField(skin);
				minValue.setName("min_value_" + table.getRows());
				
				ValueField maxValue = new ValueField(skin);
				maxValue.setName("max_value_" + table.getRows());
				
				CheckBox percent = new CheckBox("", skin);
				percent.setName("percent_" + table.getRows());
				
				ValueField group = new ValueField(skin);
				group.setName("group_" + table.getRows());
				
				ValueField active = new ValueField(skin);
				active.setName("active_" + table.getRows());
				
				table.getCell(AddEffect.this).setActor(selectAttribute).width(Value.percentWidth(1/8f, table));
				table.add(triggerChance).width(Value.percentWidth(1/8f, table));
				table.add(minValue).width(Value.percentWidth(1/8f, table));
				table.add(maxValue).width(Value.percentWidth(1/8f, table));
				table.add(percent).width(Value.percentWidth(1/8f, table));
				table.add(group).width(Value.percentWidth(1/8f, table));
				table.add(active).width(Value.percentWidth(1/8f, table));
				
//				for (Cell<Actor> cell : table.getCells()) {
//					cell.growX();
//				}
				
				table.row();
				
				AddEffect addEffectButton = AddEffect.this;
				table.add(addEffectButton);
				table.getCell(addEffectButton).align(Align.left);
			}
			
		});
	}

}
