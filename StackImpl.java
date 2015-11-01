
public class StackImpl extends AbstractStack{
	private StackImpl pointer;
	private StackImpl prev;
	private Object data;
	
	/**
	 * Getters & Setters
	 */
	public StackImpl getPointer() {
		return pointer;
	}


	public void setPointer(StackImpl pointer) {
		this.pointer = pointer;
	}


	public StackImpl getPrev() {
		return prev;
	}


	public void setPrev(StackImpl prev) {
		this.prev = prev;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}
	

	/**
	 * Constructor
	 */
	public StackImpl(List list) {
		super(list);
	}


	@Override
	public boolean isEmpty() {
		if (this.pointer.equals(null)){
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		if (!this.isEmpty()){
			int count = 0;
			StackImpl newStack = pointer;
			while(!newStack.prev.equals(null)){
				newStack = newStack.prev;
				count++;
			}
			return count;
		}
		return 0;
	}

	public void push(Object item) {
		pointer = item;
		
		
	}

	@Override
	public ReturnObject top() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnObject pop() {
		// TODO Auto-generated method stub
		return null;
	}

}
