package generateur.controller.button.entity_parameters.graph;

import org.apache.log4j.Logger;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import generateur.controller.button.entity_parameters.graph.node.Node;

/**
 * Classe représentant un lien entre plusieurs noeuds dans le graphe.
 * 
 * @author Julien B.
 */

public class Link extends Button {
	/**Extrémité du lien*/
	private Node node1;
	/**Extrémité du lien*/
	private Node node2;
	private Pixmap line;
	private Texture texture;
	private final Logger logger = Logger.getLogger(Link.class);
	
	public Link(Node end1, Node end2) {
		super((Drawable)null);
		
		if (end1.equals(end2)) {
			logger.error("Second node is already attached to this link.\nCreation aborted.");
		} else {
			node1 = end1;
			node2 = end2;
			
			draw();
		}
	}
	
	/**
	 * Création et positionnement du lien sur le graphe.
	 * N'ajoute pas le lien à l'écran.
	 */
	public void draw() {
		if (texture != null) {
			texture.dispose();
		}
		
		float directionX = node2.getX() - node1.getX();
		float directionY = node2.getY() - node1.getY();
		int width = (int) Math.abs(directionX);
		int height = (int) Math.abs(directionY);
		int x = (int) (node1.getX() + node1.getWidth() / 2);
		int y = (int) (node1.getY() + node1.getHeight() / 2);
		
		//Création de l'image
		line = new Pixmap((int) width, (int)  height, Format.RGBA8888);
		line.setColor(Color.WHITE);
		
		//Positionnement
		if (directionX >= 0 && directionY >= 0) {
			setPosition(x, y);
			line.drawLine(0, height, width, 0);
		} else if (directionX >= 0 && directionY < 0) {
			setPosition(x, y - height);
			line.drawLine(0, 0, width, height);
		} else if (directionX < 0 && directionY >= 0) {
			setPosition(x - width, y);
			line.drawLine(0, 0, width, height);
		} else {
			line.drawLine(0, height, width, 0);
			setPosition(x - width, y - height);
		}
		
		texture = new Texture(line);
		line.dispose();
		setStyle(new LinkStyle(texture));
		setSize(width, height);
	}

	@Override
	public boolean equals(Object obj) {
		Link o = (Link) obj;
		
		return node1.equals(o.getNode1()) || node1.equals(o.getNode2()) || node2.equals(o.getNode1()) || node2.equals(o.getNode2());
	}

	public Node getNode1() {
		return node1;
	}

	public void setNode1(Node node1) {
		this.node1 = node1;
	}

	public Node getNode2() {
		return node2;
	}

	public void setNode2(Node node2) {
		this.node2 = node2;
	}
	
	public void dispose() {
		remove();
		
		if (texture != null) {
			texture.dispose();
		}
	}
}
