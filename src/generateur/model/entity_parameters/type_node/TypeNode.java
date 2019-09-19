package generateur.model.entity_parameters.type_node;

public abstract class TypeNode {

	/**Nom*/
	private String name;
	/**Description*/
	private String description;
	/**Coût de déverrouillage*/
	private int cout;
	/**Coût de déverrouillage*/
	private boolean unlock;
	
	public int getCout() {
		return cout;
	}
	public String getDescription() {
		return description;
	}
	public String getName() {
		return name;
	}
	public boolean isUnlock() {
		return unlock;
	}
	public void setCout(int cout) {
		this.cout = cout;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUnlock(boolean unlock) {
		this.unlock = unlock;
	}
}
