public class Node {
	private int position;
	private Object value;
	private Node next;
	private Node prev;
	/**
	 * Get position of current node
	 * @return current position
	 */
	public int getPosition() {
		return position;
	}
	/**
	 * Set the position of current node
	 * @param new current position
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	/**
	 * Constructor method for node
	 * creates new node with given value
	 * sets next & previous nodes to null.
	 * @param new value to assign to node
	 */
	public Node(Object value){
		this.value = value;
		this.next = null;
		this.prev = null;
	}
	/**
	 * Empty constructor method for node
	 * In case I need temporary nodes for methods
	 */
	public Node(){
		this.value = null;
		this.next = null;
		this.prev = null;
	}
	
	/**
	 * Gets the value current objects value
	 * @return value of this object
	 */
	public Object getValue() {
		return value;
	}
	/**
	 * Sets a new value to current object
	 * @param new value of this object
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	/**
	 * Get the next node in the list
	 * @return next node in list
	 */
	public Node getNext() {
		return next;
	}
	/**
	 * Set the next node in the list
	 * @param node to set as next
	 */
	public void setNext(Node next) {
		this.next = next;
	}
	/**
	 * Gets the previous node to current node
	 * @return previous node
	 */
	public Node getPrev() {
		return prev;
	}
	/**
	 * Set the previous node in the list
	 * @param node to set as previous
	 */
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	/**
	 * Returns the String value of the current node
	 */
	public String toString(){
		return this.value + "";
	}
}
