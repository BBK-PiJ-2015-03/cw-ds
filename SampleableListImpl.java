
public class SampleableListImpl extends LinkedList implements SampleableList {
	private SampleableListImpl sampleList;
	/**
	 * Returns a list containing the first, third, fifth...
	 * items of this list, or an empty list if the list is empty. 
	 * 
	 * @return a list containing the first, third, fifth... items of this list
	 */
	public SampleableList sample(){
		SampleableListImpl returnlist = new SampleableListImpl();
		if (this.size() == 0){
			return returnlist.sampleList;
		}
		for(int i = 0; i < this.size(); i= i+2){
			returnlist.sampleList.add(this.get(i));
		}
	return returnlist.sampleList;
	}
}
