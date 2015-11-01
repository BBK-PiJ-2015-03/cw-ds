
public class FunctionalArrayList extends ArrayList implements FunctionalList {
	private Object[] arrayList;
	
	public void setArray(Object[] arrayList){
		this.arrayList = arrayList;
	}
	
    /**
     * Returns the element at the beginning of the list. 
     * 
     * If the list is empty, an appropriate error is returned. 
     *
     * @return a copy of the element at the beginning of the list or 
     *         an error if the list is empty.
     */
	public ReturnObject head() {
		ReturnObjectImpl access = new ReturnObjectImpl();
		if(this.isEmpty()){
			access.setError(ErrorMessage.EMPTY_STRUCTURE);
			return access;
		}
		access.setError(ErrorMessage.NO_ERROR);
		access.setValue(this.getArrayElem(0));
		return access;
	}
	
	 /**
     * Returns a list with the elements in this list except the
     * head. The elements must be in the same order. The original list
     * must not change or be affected by changes in the new list. 
     * 
     * If the list is empty, another empty list is returned. 
     */
	public FunctionalList rest() {
		ReturnObjectImpl access = new ReturnObjectImpl();
		FunctionalArrayList tempArray = new FunctionalArrayList();
		if(this.isEmpty()){
			return tempArray;
		}
		tempArray.setArray(this.arrayList);
		for (int i = 0; i < this.al.size() ; i++){
			tempArray.setArray(arrayList[i]) = this.arrayList[i+1];
		}
		return tempArray;
	}

}
