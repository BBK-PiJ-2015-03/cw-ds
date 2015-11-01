
public class FunctionalLinkedList extends LinkedList implements FunctionalList {
	String value;
	FunctionalLinkedList next;
	
	LinkedList ll = new LinkedList();
	
	public ReturnObject head() {
		ReturnObjectImpl temp = new ReturnObjectImpl();
		if (ll.head.equals(null)){
		temp.error = "ERROR: List is empty / head is null";
		return temp;
		}
		temp.result = "Head value is " + ll.head.value;
		return temp;
	}
	

	public FunctionalList rest() {
		ReturnObjectImpl temp = new ReturnObjectImpl();
		if (ll.head.equals(null)){
		System.out.println("ERROR: List is empty / head is null");
		return null;
		}
		FunctionalLinkedList newList = new FunctionalLinkedList();
		for ()
		temp.result = "Head value is " + ll.head.value;
		
	}

}
