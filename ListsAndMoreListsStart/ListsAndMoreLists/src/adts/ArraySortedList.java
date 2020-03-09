package adts;

import interfaces.ListInterface;
import nodes.DLLNode;

public class ArraySortedList<E> extends ArrayBasedList<E> implements ListInterface<E> {
	
	protected DLLNode<E> FrontCar, BackCar, iterator=null;
	
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
		
		int addLocation = 0;
		
		while (addLocation < numElements) {
			if (((Comparable)element).compareTo(list[addLocation]) > 0) {
				addLocation++;
			}
			else {
				break;
			}
		}
		
		// make room!
		for (int i = numElements; i > addLocation; i--) {
			list[i] = list[i - 1];
		}
		
		list[addLocation] = element;
		
		numElements++;
		
	}

	@Override
	public boolean remove(E element) {
		
		//return false;
		
		//find(element);  // sets found, and when found is true, sets location
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
		//find(element);
		return found;
	}

	@Override
	public E get(E element) {
		// TODO Auto-generated method stub
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
		
		return Prev;
	}
	
	public boolean find2(E element) {
		return false;
	}
	
	//Put 'toString()' here 

}
