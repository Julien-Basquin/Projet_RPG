package app.model.entity
;

import java.util.Set;

import generateur.controller.button.entity_parameters.graph.Link;
import generateur.controller.button.entity_parameters.graph.node.Node;

/**
 * 
 *	Class for entiy skill
 *
 */
public class SkillTree {

	private Set<Node> nodeList;
	private Set<Link> linkList;

	/**
	 * create null tree for loading
	 */
	public SkillTree() {
	}
	
	/**
	 * Default constructor
	 * @param nodeList
	 * @param linkList
	 */
	public SkillTree(Set<Node> nodeList, Set<Link> linkList) {
		this.linkList = linkList;
		this.nodeList = nodeList;
	}
	
	public Set<Link> getLinkList() {
		return linkList;
	}
	public Set<Node> getNodeList() {
		return nodeList;
	}
}

