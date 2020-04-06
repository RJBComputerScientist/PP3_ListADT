package Sorted;

import interfaces.ListInterface;
import nodes.DLLNode;

public class ArraySortedList<E> extends ArrayBasedList<E> implements ListInterface<E> {
	
	protected DLLNode<E> FrontCar, MidCar, BackCar, iterator=null;
	
	public ArraySortedList() {
		super();
	}
	
	public ArraySortedList(int initialCapacity) {
		super(initialCapacity);
	}
	
	@Override
	public void add(E element) {
		
		if (numElements == list.length) {
			enlarge();
		}
		
		int AddSpot = 0;
		
		while (AddSpot < numElements) {
			if (((Comparable)element).compareTo(list[AddSpot]) > 0) {
				AddSpot++;
			}
			else {
				break;
			}
		}
		
		// make room!
		for (int i = numElements; i > AddSpot; i--) {
			list[i] = list[i - 1];
		}
		
		list[AddSpot] = element;
		
		numElements++;
		
	}

	@Override
	public boolean remove(E element) {
		
		//return false;
		
		find(element);  // sets found, and when found is true, sets location
		find2(element);
	    if (found) {
	    	for (int i = location; i < numElements - 1; i++) {
	    		list[i] = list[i+1];
	    	}
	    	//list[location] = list[numElements - 1];
	    	// clear out element that had been the last element:
	    	list[numElements - 1] = null;
	    	numElements--;
	    }
	    return found;
	}

	@Override
	public int size() {
		return numElements;
	}

	@Override
	public boolean isEmpty() {
		return numElements == 0;
	}

	@Override
	public boolean contains(E element) {
		find(element);
		find2(element);
		//return found; //relates to find code
		return true;
	}

	@Override
	public E get(E element) {
		find(element);
		find2(element);
		return null;
	}

	@Override
	public void resetIterator() {
		iterator = FrontCar;
		
	}
	
	public void resetBackIterator() {
		iterator = BackCar;
		
	}

	@Override
	public E getNextItem() {
		E Next = iterator.getInfo();
		iterator = iterator.getNext();
		
		return Next;
	}
	
	public E getPrevItem() {
		E Prev = iterator.getInfo();
		iterator = iterator.getPrev();
		
		return Prev; //= iterator.setPrev();
	}
	
	@Override
	protected void find(E target) {
		found = false;
		location = 0;
		
		int low = 0;
		int high = numElements;
		
		while(low <= high) {
		
		int mid = (low + high) / 2;
		if(target.equals(list[mid])) {
			found = true;
			location = mid;
			break;
		}
		else {
			if(((Comparable)target).compareTo(list[mid]) > 0) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
	}
		return;
	}
	
	protected void find2(E element) { //This is for array based linked list"
		int FrontSpot = 0;
		int BackSpot = list.length - 1;
		int MidSpot = 0;
		
		
		while (FrontSpot <= BackSpot) {
			MidSpot = (FrontSpot + BackSpot) / 2;
		}
		
		if (list[MidSpot+1] != element) {
			FrontSpot = MidSpot + 1;
		}
		
		else if (list[MidSpot-1] != element){
			BackSpot = MidSpot - 1;
		}
		
		else {
			MidSpot++;
			//return false;
	}
		//return found;
	}
	
	public String toString() {
		String CarOption = "My Chosen Pair Of Cars \n";
		return CarOption;
		
	}
}
