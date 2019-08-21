package generator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


import generateur.controller.button.entity_parameters.graph.Node;
import generateur.view.entity_parameters.middle.EntityParametersGraph;

/**
 * Tests des opérations effectuées sur le graphe des entités
 * 
 * @author Julien B.
 */

public class TestGraph {
	private EntityParametersGraph graph = new EntityParametersGraph();;
	
	@Test
	public void addNodeTest() {
		assertEquals(0, graph.getNodeList().size());
		graph.addNode(new Node(0, 0));
		assertEquals(1, graph.getNodeList().size());
	}
	
	@Test
	public void addLinkTest() {
		Node node1 = new Node(0, 0);
		Node node2 = new Node(100, 100);
		graph.addNode(node1);
		graph.addNode(node2);
		
		assertEquals(0, node1.getLinks().size());
		assertEquals(0, node2.getLinks().size());
		assertEquals(0, graph.getLinkList().size());
		
		graph.addLink(node1, node2);
		assertEquals(1, node1.getLinks().size());
		assertEquals(1, node2.getLinks().size());
		assertEquals(1, graph.getLinkList().size());
	}
}
