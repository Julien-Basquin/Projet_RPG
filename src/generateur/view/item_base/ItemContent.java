package generateur.view.item_base;

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.utils.Align;

import app.model.enumeration.CategorieEnum;
import generateur.MainWindow;
import generateur.view.item_base.armor.ArmorOptions;
import generateur.view.item_base.item.ItemOptions;
import generateur.view.item_base.weapon.WeaponOptions;
import generateur.controller.select.SelectCategory;
import util.ActorActions;

public class ItemContent extends ScrollPane {

	public ItemContent(Skin skin) {
		super(null, skin);
		setName("item_content");
		
		VerticalGroup group = new VerticalGroup();
		group.setName("item_content_group");
		group.align(Align.topLeft);
		group.grow();
		
		CategorieEnum category = ((SelectCategory) ActorActions.findActor(MainWindow.stage, "category")).getSelected();
		
		switch(category) {
			case ARME:
				WeaponOptions weaponOptions = new WeaponOptions(skin);
				group.addActor(weaponOptions);
				break;
			case ARMURE:
				ArmorOptions armorOptions = new ArmorOptions(skin);
				group.addActor(armorOptions);
				break;
			case OBJET:
				ItemOptions itemOptions = new ItemOptions(skin);
				group.addActor(itemOptions);
				break;
			default:
				
				break;
		}
		
		EffectTable table = new EffectTable(skin);
		group.space(50);
		
		group.addActor(table);
		
		setActor(group);
	}

}
