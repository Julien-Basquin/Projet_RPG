package generateur.model.entity_parameters.type_node;

import app.model.enumeration.element.ElementEnum;

public class TypeNodeAttribut extends TypeNode {

	/**Element of attribute*/
	private ElementEnum element;
	/**Value of attribute*/
	private int value;
	/**is percent*/
	private boolean percent;
	
	public TypeNodeAttribut() {
	}
	public TypeNodeAttribut(TypeNodeAttribut typeNode){
		setCout(typeNode.getCout());
		setDescription(typeNode.getDescription());
		setName(typeNode.getName());
		setUnlock(typeNode.isUnlock());
		setElement(typeNode.getElement());
		setValue(typeNode.getValue());
		setPercent(typeNode.isPercent());
	}
	
	public ElementEnum getElement() {
		return element;
	}
	public int getValue() {
		return value;
	}
	public boolean isPercent() {
		return percent;
	}
	public void setElement(ElementEnum element) {
		this.element = element;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void setPercent(boolean percent) {
		this.percent = percent;
	}
}
