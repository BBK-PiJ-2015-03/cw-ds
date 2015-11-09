public class FunctionalLinkedList extends LinkedList implements FunctionalList {
	
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
    	if (super.getHead() == null){
    		object.setErrorM(ErrorMessage.EMPTY_STRUCTURE);
    		return object;
    	}
    	object.setErrorM(ErrorMessage.NO_ERROR);
    	object.setObject(super.getHead().getValue());
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
    	FunctionalLinkedList restList = new FunctionalLinkedList();
    	Node copyNode = super.getHead().getNext();
    	for (int i = 1; i < this.size(); i++){
    		restList.add(copyNode.getValue());
    		System.out.println(i + ": " + copyNode.getValue());
    		copyNode = copyNode.getNext();
    	}
    	return restList;
    }
}
