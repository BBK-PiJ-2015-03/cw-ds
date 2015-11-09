
public class FunctionalArrayList extends ArrayList implements FunctionalList {
	
	public FunctionalArrayList(Object[] newArray){
		super(newArray);
	}
	public FunctionalArrayList(){
		super();
	}
	
	/**
     * Returns the element at the beginning of the list. 
     * 
     * If the list is empty, an appropriate error is returned. 
     *
     * @return a copy of the element at the beginning of the list or 
     *         an error if the list is empty.
     */
    public ReturnObject head(){
    	ReturnObjectImpl object = new ReturnObjectImpl();
    	if (super.isEmpty()){
    		object.setErrorM(ErrorMessage.EMPTY_STRUCTURE);
    		return object;
    	}
    	object.setErrorM(ErrorMessage.NO_ERROR);
    	object.setObject(super.getValue(0));
    	return object;
    }

    /**
     * Returns a list with the elements in this list except the
     * head. The elements must be in the same order. The original list
     * must not change or be affected by changes in the new list. 
     * 
     * If the list is empty, another empty list is returned. 
     */
    public FunctionalList rest(){
		System.out.println("Rest Running...");
    	FunctionalArrayList restList = new FunctionalArrayList();
    	if (this.isEmpty()){
    		System.out.println("Empty list");
    		return restList;
    	}
    	for (int i = 1; i < this.size(); i++){ //double check
    		restList.add(this.getValue(i));
    		System.out.println(i + ": " + restList.get(i).getReturnValue());
    	}
    	return restList;
    }
}
