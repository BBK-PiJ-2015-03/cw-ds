public class ArrayList implements List{
	private Object[] value;
	private int arraySize;
	
	public ArrayList() {
		super();
		this.setValue(new Object[10]);
		for (int i = 0; i < this.getValue().length; i++){
			this.getValue()[i] = null;
		}
	}
	
	public ArrayList(Object[] newArray){
		this.setValue(newArray);
	}
	
	public ArrayList(int newSize){
		this.setValue(new Object[newSize]);
	}
	/**
	 * Gets an object from the array.
	 * @param index of value to retrieve
	 * @return the value store in the object
	 */
	public Object getValue(int index) {
		return value[index];
	}
	
	
	public void setValue(int index, Object item){
		this.value[index] = item;
	}
	/**
	 * Sets an object in the array
	 * @param value of object array
	 */
	public void setValue(Object[] value) {
		this.value = value;
	}
	/**
	 * Gets the total size of the array
	 * @return size of array
	 */
	public int getArraySize() {
		return this.arraySize;
	}
	/**
	 * Increment or decrement the size of the array
	 * @param new array size
	 */
	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}

	/**
	 * Returns true if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */
	public boolean isEmpty(){
		if (this.size() == 0){
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
		int total = 0;
		for (int i = 0; i < this.getValue().length; i++){
			if(this.getValue(i) != null){
				total++;
			}
		}
		return total;
	}
	
	public ArrayList doubleSize(){
		ArrayList newArray = new ArrayList((this.getValue().length*2));
		for (int i = 0; i < this.size(); i++){
			newArray.setValue(i, this.getValue(i));
			System.out.println("Array Size Now: " + i);
		}
		return newArray;
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
		if (index >= this.size() || index < 0){
			object.setErrorM(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return object;
		}
		object.setErrorM(ErrorMessage.NO_ERROR);
		object.setObject(this.getValue(index));
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
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject remove(int index){
		ReturnObjectImpl object = new ReturnObjectImpl();
		if(index >= this.size() || index < 0){
			object.setErrorM(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return object;
		}
		if(this.get(index) == null){
			object.setErrorM(ErrorMessage.INVALID_ARGUMENT);
			return object;
		}
		object.setObject(this.getValue(index));
		for(int i = index; i < this.getValue().length; i++){
			if(i != this.getValue().length-1){ //DOUBLE CHECK THIS
				this.setValue(i, this.getValue(i+1));
			}
		}
		this.arraySize--;
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
		ReturnObjectImpl object = (ReturnObjectImpl) this.get(index);
		if (item == null){
			object.setErrorM(ErrorMessage.INVALID_ARGUMENT);
			return object;
		}
		if (object.hasError()){
			return object;
		}
		object.setErrorM(ErrorMessage.NO_ERROR);
		if (index < this.size() && this.getValue(index) == null){
			object.setObject(null);
			this.setValue(index, item);
			this.arraySize++;
			return object;
		} else if(index < this.size() && this.arraySize+1 < this.getValue().length){
			for (int i = this.size()-1; i >= index; i++){
				this.setValue(i, this.getValue(i-1));
			}
			this.setValue(index, item);
			object.setObject(null);
			return object;
		}
		
		this.setValue(doubleSize().getValue());
		for (int i = (this.size()/2); i > index; i--){
			this.setValue(i, this.getValue(i-1));
		}
		object.setObject(null);
		this.setValue(index, item);
		this.arraySize++;
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
		if (item == null){
			object.setErrorM(ErrorMessage.INVALID_ARGUMENT);
			return object;
		}
		object.setErrorM(ErrorMessage.NO_ERROR);
		for (int i = 0; i <= this.size(); i++){
			if (this.getValue(i) == null){
				this.setValue(i, item);
				this.arraySize++;
				return object;
			}
		}
		return object;
	}

	public Object[] getValue() {
		return value;
	}
	
	public String toString(){
		return this.value + "";
	}
}
