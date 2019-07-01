//Class to create Objects and store their IDs (child-parent)
public class Person
{
	private int id;
	private Integer parent_id;
	public int getId() {
		return id;
	}
	public Person(int id, Integer parent_id) {
		super();
		this.id = id;
		this.parent_id = parent_id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", parent_id=" + parent_id + "]";
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
}
