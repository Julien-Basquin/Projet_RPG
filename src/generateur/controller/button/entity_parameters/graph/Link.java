package generateur.controller.button.entity_parameters.graph;

import org.apache.log4j.Logger;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/**
 * Classe représentant un lien entre plusieurs noeuds dans le graphe.
 * 
 * @author Julien B.
 */

public class Link extends Button {
	private Node node1;
	private Node node2;
	private Pixmap line;
	private Texture texture;
	private final Logger logger = Logger.getLogger(Link.class);
	
	public Link(Node end1, Node end2) {
		super((Drawable)null);
		
		if (end1.equals(end2)) {
			logger.error("Second node is already attached to this link.\nCreation aborted.");
			//TODO Throw exception
		} else {
			node1 = end1;
			node2 = end2;
			line = new Pixmap((int) Math.abs(node1.getX() - node2.getX()), (int) Math.abs(node1.getY() - node2.getY()), Format.RGBA8888);
			line.setColor(Color.WHITE);
			int x1 = (int) (node1.getX() + node1.getWidth() / 2);
			int y1 = (int) (node1.getY() - node1.getHeight());
			int x2 = (int) (Math.abs(node2.getX() - node1.getX()));
			int y2 = (int) (Math.abs(node2.getY() - node1.getY()));
			line.drawLine(0, 0, x2, y2);
			texture = new Texture(line);
			setStyle(new LinkStyle(texture));
			setSize(Math.abs(node1.getX() - node2.getX()), Math.abs(node1.getY() - node2.getY()));
			setPosition(x1, y1);
		}
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

	public Pixmap getLine() {
		return line;
	}

	public void setLine(Pixmap line) {
		this.line = line;
	}
	
	public void dispose() {
		texture.dispose();
		line.dispose();
	}
}
