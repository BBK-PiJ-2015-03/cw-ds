	/**
	 * An implementation of a stack with additional methods. 
	 * 
	 * Classes implementing this interface must use a {@see List} as the
	 * underlying data structure to store the elements on the stack. 
	 * 
	 * Not all operations on a stack will always be successful. For
	 * example, a programmer may try to pop an element from an empty
	 * stack. Since we hace not covered exceptions yet, we need another
	 * mechanism to report errors. In order to do that, methods of this
	 * list will return a {@see ReturnObject} that will contain either an
	 * object or an error value of the right kind (as defined in {@see
	 * ErrorMessage}).
	 * 
	 * @author PiJ
	 */
public class ImprovedStackImpl implements ImprovedStack {
	private ArrayList arrayStack;
	
	public ImprovedStackImpl(ArrayList newArray){
		this.arrayStack = newArray;
	}
	public ImprovedStackImpl(){
	}
	public boolean isEmpty() {
		if(this.arrayStack.isEmpty()){
			return true;
		}
		return false;
	}

	public int size() {
		return this.arrayStack.size();
	}

	public void push(Object item) {
		this.arrayStack.add(item);
	}

	public ReturnObject top() {
		ReturnObjectImpl object = new ReturnObjectImpl();
		if(this.isEmpty()){
			object.setErrorM(ErrorMessage.EMPTY_STRUCTURE);
			return object;
		}
		int getValue = this.arrayStack.size()-1;
		object.setObject((this.arrayStack.get(getValue).getReturnValue()));
		object.setErrorM(ErrorMessage.NO_ERROR);
		return null;
	}

	@Override
	public ReturnObject pop() {
		ReturnObjectImpl object = new ReturnObjectImpl();
		if(this.isEmpty()){
			object.setErrorM(ErrorMessage.EMPTY_STRUCTURE);
			return object;
		}
		Object targetValue = this.arrayStack.get(this.arrayStack.size()-1);
		object.setObject(targetValue);
		this.arrayStack.remove(this.arrayStack.size()-1);
		object.setErrorM(ErrorMessage.NO_ERROR);
		return object;
	}

	public ImprovedStack reverse() {
		ImprovedStackImpl reversedStack = new ImprovedStackImpl();
		if(this.isEmpty()){
			return reversedStack;
		}
		for(int i = this.arrayStack.size(); i > 0; i++){
			Object setValue = this.arrayStack.get(i).getReturnValue();
			reversedStack.arrayStack.add(setValue);
		}
		return reversedStack;
	}

	public void remove(Object object) {
		if(this.arrayStack.isEmpty()){
			//do nothing
		} else {
			for(int i = 0; i < this.arrayStack.size(); i++){
				if(this.arrayStack.get(i).getReturnValue().equals(object)){
					this.arrayStack.remove(i);
				}
			}
		}
	}

}
