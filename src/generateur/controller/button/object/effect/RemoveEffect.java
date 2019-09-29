package generateur.controller.button.object.effect;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

/**
 * Bouton de suppression d'un effet d'un objet
 * 
 * @author Julien B.
 */

public class RemoveEffect extends TextButton {

	public RemoveEffect(Table table, Skin skin) {
		super("-", skin);
		
		addListener(new ClickListener() {

			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);

				//Numéro de ligne à supprimer (inclut dans le nom)
				int rowToDelete = 0;
				Pattern pattern = Pattern.compile("\\D*(\\d+)");
				Matcher match = pattern.matcher(getName());
				if (match.find() && !match.group(1).contains("add_effect")) {
					rowToDelete = Integer.parseInt(match.group(1));
				}

				//Création d'une vue en 2D des acteurs du tableau
				List<List<Actor>> listCell = new ArrayList<List<Actor>>();
				
				//SupressWarnings car getCells() renvoie un type générique;
				@SuppressWarnings("rawtypes")
				Array<Cell> cells = table.getCells();
				int k = 0;
				
				for (int i = 0; i < table.getRows(); i++) {
					List<Actor> rowCells = new ArrayList<Actor>();
					
					for (int j = 0; j < table.getColumns(); j++) {
						rowCells.add(cells.get(k++).getActor());
					}
					
					listCell.add(rowCells);
				}
				
				int rowNumber = rowToDelete;
				
				//Suppression de la ligne ciblée et déplacement des lignes suivantes
				while (rowNumber < table.getRows() - 1) {
					for (int i = 0; i < table.getColumns(); i++) {
						listCell.get(rowNumber).set(i, listCell.get(rowNumber + 1).get(i));
						if (listCell.get(rowNumber).get(i) != null) {
							Pattern namePattern = Pattern.compile("(\\D*)\\d+");
							Matcher nameMatch = namePattern.matcher(listCell.get(rowNumber).get(i).getName());
							if (nameMatch.find() && !nameMatch.group(1).contains("add_effect")) {
								listCell.get(rowNumber).get(i).setName(nameMatch.group(1) + rowNumber);
							}
						}
					}
					
					rowNumber++;
				}
				listCell.remove(rowNumber);
				
				//Régénération du tableau des effets (Table ne permet pas d'insérer ou de supprimer des cellules)
				//Voir https://github.com/libgdx/libgdx/wiki/Table#inserting-cells pour plus d'information
				table.clearChildren();
				for (List<Actor> row : listCell) {
					for (Actor actor : row) {
						table.add(actor).width(Value.percentWidth(1/8f, table));
					}
					
					table.row();
				}
			}
			
		});
	}

}
