package generateur.view.item;

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.utils.Align;

public class ItemContent extends ScrollPane {

	public ItemContent(Skin skin) {
		super(null, skin);
		setName("item_content");
		
		VerticalGroup group = new VerticalGroup();
		group.setName("item_content_group");
		group.align(Align.topLeft);
		group.grow();
		
		ItemOptions options = new ItemOptions(skin);
		
		EffectTable table = new EffectTable(skin);
		group.space(50);
		
		group.addActor(options);
		group.addActor(table);
		
		setActor(group);
	}

}
