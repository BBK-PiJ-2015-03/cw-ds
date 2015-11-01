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
public class ArrayList implements List {
	private Object[] arrayList;
	
	ReturnObjectImpl access = new ReturnObjectImpl();
	
	public boolean isEmpty(){
		if (this.size() == 0){
			return true;
		}
		return false;
	}

	public int size(){
		return this.arrayList.length;
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
		if (index >= this.size() || index < 0){
			System.out.println("ERROR: Array position is invalid");
			this.ErrorMessage = "INDEX_OUT_OF_BOUNDS";
			return ErrorMessage.INDEX_OUT_OF_BOUNDS;
		}
		return this.al.arrayList[index];
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
		if (this.get(index).equals(this[index])){ // error will be returned here if false
		ReturnObject[] tempArray = new ReturnObject[(this.size()-2)];
			for (int i = 0; i < index; i++){
				tempArray[i] = this[i];
			}
			for (int j = this.size()-1; j > index; j--){
				tempArray[j] = this[j];
			}
			return tempArray; // returns new array with index removed
		}
		return this; // returns the element (see above comment)
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
	 * @return an ReturnObject, empty if the operation is successful  // not sure what is meant by empty if operation successfull
	 *         the item added or containing an appropriate error message
	 */
	public ReturnObject add(int index, Object item){
		if (this.get(index).equals(this)){
			return this;
		}
		if (index == this.size()){ // cannot combine with above if statement as error will print twice, unless I use nested if.
			System.out.println("ERROR: Array position is invalid");
			return this;			
		}
		if (item.equals(null)){
			System.out.println("ERROR: Object cannot be null");
			return this;			
		}
		ReturnObject[] tempArray = new ReturnObject[this.size()];	
		for (int i = 0; i < index; i++){
			tempArray[i] = this[i];
		}
		for (int j = this.size; j > index; j--){
			tempArray[j] = this[j];
		}
		tempArray[index] = item;
		return tempArray;
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
		if (item.equals(null)){
			System.out.println("ERROR: Object cannot be null");
			return this;
		}
		ReturnObject[] tempArray = new ReturnObject[this.size()];
		for (int i = 0; i < this.size()-1; i++){
			tempArray[i] = this[i];
		}
		tempArray[i] = item;
		return tempArray;
	}

}
