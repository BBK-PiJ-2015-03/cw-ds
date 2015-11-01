/**
 * A list is a collection of objects that are sorted and can be
 * accessed by index. The first element in the list is at index 0.
 *
 * A list can store objects of any kind, and they can be of different
 * types: Integers, Doubles, String, or even other lists. However,
 * this list cannot store null objects.
 * 
 * There is no limit to the number of elements in the list (provided
 * that there is free memory in the Java Virtual Machine).
 * 
 * Not all operations on a list will always be successful. For
 * example, a programmer may try to remove an element from an empty
 * list, or from a position where there is nothing. Since we hace not
 * covered exceptions yet, we need another mechanism to report
 * errors. In order to do that, methods of this list will return a
 * {@see ReturnObject} that will contain either an object or an error
 * value of the right kind (as defined in {@see ErrorMessage}). 
 * 
 * @author PiJ
 */
public class LinkedList implements List {
	FunctionalLinkedList head;
	FunctionalLinkedList tail;
	
	FunctionalLinkedList ll = new FunctionalLinkedList();

	/**
	 * Returns true if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */
	public boolean isEmpty(){
		if(head.next.equals(null)){
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
		if(this.isEmpty()){
			return 0;
		}
		LinkedList tempList = head;
		int count = 0;
		while (!tempList.next.equals(null)){
			tempList = tempList.next;
			count++;
		}
		return count;
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
		ReturnObjectImpl temp = new ReturnObjectImpl();
		if (index >= this.size() || index < 0){
			temp.error = "ERROR: Position given in paramaters is invalid";
			return temp;
		}
		FunctionalLinkedList tempList = head;
		for (int i = 0; i < index; i++){
			tempList = tempList.ll.next;
		}
		temp.result = "Value at index " + index + " is " + tempList.ll.value;
		return temp;
	}

	/**
	 * Returns the elements at the given position and removes it
	 * from the list. The indeces of elements after the removed
	 * element must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject remove(int index){
	if (!this.get(index).equals(null)){
		LinkedList tempList = head;
		for (int i = 0; i < index-1; i++){
			tempList = tempList.ll.next;
		}
		tempList.ll.next = tempList.ll.next.next;
		tempList.ll.next.next = null;
		ReturnObjectImpl temp = new ReturnObjectImpl();
		temp.result = "Value at index " + index + "has been removed from the list.";
		return temp;
	}
	ReturnObjectImpl temp = new ReturnObjectImpl();
	temp.error = "ERROR: Index " + index +  " is not valid.";
	return null;

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
		if (!this.get(index).equals(null) && !item.equals(null)){
			LinkedList tempList = head;
			FunctionalLinkedList newNode = new FunctionalLinkedList();
			newNode.ll.value = (String) item;
			for (int i = 0; i < index-1; i++){
				tempList = tempList.ll.next;
			}
			newNode.ll.next = tempList.ll.next;
			tempList.ll.next = newNode;
			return null; //double check as need to return empty
		}
		ReturnObjectImpl temp = new ReturnObjectImpl();
		temp.error = "ERROR: Index " + index + " is not valid";
		return temp;
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
		if (!item.equals(null)){
			FunctionalLinkedList tempList = head;
			FunctionalLinkedList newNode = new FunctionalLinkedList();
			newNode.ll.value = (String) item;
			for (int i = 0; !tempList.ll.next.equals(null); i++){
				tempList = tempList.ll.next;
			}
			tail = newNode;
			tempList.ll.next = newNode;
			return null;
		}
		ReturnObjectImpl temp = new ReturnObjectImpl();
		temp.error = "ERROR: Value " + item + "Could not be been added to list.";
		return temp;
	}

}
