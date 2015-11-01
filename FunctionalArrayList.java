
public class FunctionalArrayList extends ArrayList implements FunctionalList {
	String[] arrayList;
	
	ArrayList al = new ArrayList();
	
	public String[] getArray(int index){
		return this.arrayList[index];
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
		ReturnObjectImpl temp = new ReturnObjectImpl();
		if(this.al.isEmpty()){
			temp.error = "ERROR: ArrayList is empty";
			return temp;
		}
		temp.result = this.arrayList[0];
		return temp;
	}
	
	 /**
     * Returns a list with the elements in this list except the
     * head. The elements must be in the same order. The original list
     * must not change or be affected by changes in the new list. 
     * 
     * If the list is empty, another empty list is returned. 
     */
	public FunctionalList rest() {
		if(this.al.isEmpty()){
			return null;
		}
		FunctionalArrayList newList = new FunctionalArrayList();
		newList.arrayList = this.arrayList;
		for (int i = 0; i < this.al.size()-1 ; i++){
			newList.arrayList[i] = this.arrayList[i+1];
		}
		return newList;
	}

}
