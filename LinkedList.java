
public class LinkedList implements List {
	private Node head;
	private Node tail;
	private int lastPosition = -1;
	
	/**
	 * Get the last position in the list
	 * first position is 0
	 * @return the last position in the list
	 */
	public int getLastPosition() {
		return lastPosition;
	}
	/**
	 * Increment or decrement last position in the list
	 * @param new last position in the list
	 */
	public void setLastPosition(int lastPosition) {
		this.lastPosition = lastPosition;
	}
	/**
	 * Gets the first node in the list
	 * @return head node
	 */
	public Node getHead() {
		return head;
	}
	/**
	 * Sets the first node in the list
	 * @param new node to be set as head
	 */
	public void setHead(Node head) {
		this.head = head;
	}
	/**
	 * Gets the last node in the list
	 * @return tail node
	 */
	public Node getTail() {
		return tail;
	}
	/**
	 * Sets the last node in the list
	 * @param new node to be set as tail
	 */
	public void setTail(Node tail) {
		this.tail = tail;
	}

	/**
	 * Returns true if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */
	public boolean isEmpty(){
		if (this.lastPosition == -1){
			return true;
		}
		return false;
	}

	/**
	 * Returns the number of items currently in the list.
	 * 
	 * @return the number of items currently in the list
	 */
	public int size(){
		return (this.lastPosition+1);
	}

	/**
	 * Returns the elements at the given position. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject get(int index){
		ReturnObjectImpl object = new ReturnObjectImpl();
		if (index < 0){
			object.setErrorM(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return object;
		}
		if (this.size() == 0){
			object.setErrorM(ErrorMessage.EMPTY_STRUCTURE);
			return object;
		}
		if (index > this.lastPosition){
			object.setErrorM(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return object;
		}
		Node tempHead = this.head;
		for (int i = 0; i < index; i++){
			tempHead = tempHead.getNext();
		}
		object.setObject(tempHead.getValue());
		object.setErrorM(ErrorMessage.NO_ERROR);
		return object;	
	}

	/**
	 * Returns the elements at the given position and removes it
	 * from the list. The indeces of elements after the removed
	 * element must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.  
	 * 
	 * ********** The above is a bit confusing - so if we want to remove 
	 * ********** the last node we cannot as index will be equal to the list
	 * ********** I misunderstand this instruction
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject remove(int index) {
		ReturnObjectImpl object = new ReturnObjectImpl();
		if (this.size() == 0){
			if (index > this.lastPosition || index < 0){  
				object.setErrorM(ErrorMessage.INDEX_OUT_OF_BOUNDS);
				return object;
			}
			object.setErrorM(ErrorMessage.EMPTY_STRUCTURE);
			return object;
		}
		if (index > this.lastPosition || index < 0){  
			object.setErrorM(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return object;
		}
		object.setErrorM(ErrorMessage.NO_ERROR);
		if (this.lastPosition == 0 && index == 0){
			object.setObject(this.head.getValue());
			this.tail = null;
			this.head = null;
			this.lastPosition--;
			return object;
		}
		if (index == this.lastPosition){
			object.setObject(this.tail.getValue());
			this.tail = tail.getPrev();
			this.tail.setNext(null);
			this.lastPosition--;
			return object;
		}
		if (index == 0){
			object.setObject(this.head.getValue());
			this.head.getNext().setPrev(null);
			Node targetNode = this.head;
			this.head = this.head.getNext();
			targetNode.setNext(null);
			this.lastPosition--;
			return object;
		}
		Node targetNode = this.head;
		for (int i = 0; i < index; i++){
			targetNode = targetNode.getNext();
		}
		targetNode = targetNode.getNext();
		object.setObject(targetNode.getValue());
		targetNode.getPrev().setNext(targetNode.getNext());
		targetNode.getNext().setPrev(targetNode.getPrev());
		targetNode.setNext(null);
		targetNode.setPrev(null);
		this.lastPosition++;
		return object;
	}
	
	/**
	 * Adds an element to the list, inserting it at the given
	 * position. The indeces of elements at and after that position
	 * must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param index the position at which the item should be inserted in
	 *              the list
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         the item added or containing an appropriate error message
	 */
	public ReturnObject add(int index, Object item){
		ReturnObjectImpl object = new ReturnObjectImpl();
		Node newNode = new Node(item);
		if (item == null){
			object.setErrorM(ErrorMessage.INVALID_ARGUMENT);
			System.out.println("Point 1");
			return object;
		}
		if (index > this.lastPosition || index < 0){  
			object.setErrorM(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			System.out.println("Point 2");
			return object;
		}
		object.setErrorM(ErrorMessage.NO_ERROR);
		if (this.lastPosition == -1 && index == 0){
			System.out.println("Point 3");
			this.head.setNext(newNode);
			newNode.setPrev(this.head);
			this.tail = newNode;
			this.lastPosition++;
			return object;
		}
		if (index == this.lastPosition){
			System.out.println("Point 4");
			newNode.setPrev(this.tail);
			this.tail.setNext(newNode);
			this.tail = newNode;
			this.lastPosition++;
			return object;
		}
		if (this.lastPosition == -1){
			System.out.println("Point 5");
			this.head = newNode;
			this.tail = newNode;
			this.lastPosition++;
			return object;
		}
		System.out.println("Point 6");
		Node targetNode = this.head;
		for (int i = 0; index != i; i++){
			targetNode = targetNode.getNext();
		}
		newNode.setNext(targetNode);
		targetNode.getPrev().setNext(newNode);
		targetNode.getPrev().getNext().setPrev(targetNode.getPrev());
		targetNode.setPrev(targetNode.getPrev().getNext());
		this.lastPosition++;
		return object;
	}

	/**
	 * Adds an element at the end of the list.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         the item added or containing an appropriate error message
	 */
	public ReturnObject add(Object item){
		ReturnObjectImpl object = new ReturnObjectImpl();
		Node newNode = new Node(item);
		if (item == null){
			System.out.println("Point 1");
			object.setErrorM(ErrorMessage.INVALID_ARGUMENT);
			return object;
		}
		object.setErrorM(ErrorMessage.NO_ERROR);
		if (this.isEmpty()){
			this.head = newNode;
			this.tail = newNode;
			this.lastPosition++;
			return object;
		}
		this.tail.setNext(newNode);
		newNode.setPrev(tail);
		this.tail = newNode;
		this.lastPosition++;
		return object;
	}
}
