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
	    	// replace element to be removed with last element:
	    	list[location] = list[numElements - 1];
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
	
	protected void find2(E element) { //make a instance variable of when "find2" was used
		int FrontSpot = 0;
		int BackSpot = list.length - 1;
		int MidSpot = 0;
		
		
		while (FrontCar != BackCar) {
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
		String CarOrder = "My Chosen Pair Of Cars \n";
		return CarOrder;
		
	}
}
