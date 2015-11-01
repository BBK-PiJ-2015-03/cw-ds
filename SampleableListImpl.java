/**
 * A sampleable list can be sampled. 
 * 
 * @author PiJ
 */
public class SampleableListImpl implements SampleableList {
	String[] sampleList;
	
	ArrayList accessor = new ArrayList();
	
	@Override
	public SampleableList sample() {
		SampleableListImpl temp = new SampleableListImpl();
		if (this.size() < 0){
			System.out.print("Error: List is empty.");
			return temp;
		}
		
		for (int i = 1; i < this.size()-1; i += 2 ){
			if (!this.accessor.al.getArray(i).equals(null)){
				temp.sampleList[i] = this.accessor.al.arrayList[i];
			}
		}
		return temp;
	}
	
	@Override
	public boolean isEmpty() {
		return this.accessor.isEmpty();
	}

	@Override
	public int size() {
		return this.accessor.size();
	}

	@Override
	public ReturnObject get(int index) {
		return this.accessor.get(index);
	}

	@Override
	public ReturnObject remove(int index) {
		return this.accessor.remove(index);
	}

	@Override
	public ReturnObject add(int index, Object item) {
		return this.accessor.add(index, item);
	}

	@Override
	public ReturnObject add(Object item) {
		return this.accessor.add(item);
	}

	
}
