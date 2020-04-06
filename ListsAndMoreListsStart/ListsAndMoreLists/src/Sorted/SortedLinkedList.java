package Sorted;

import interfaces.ListInterface;
import car.Car;
import nodes.DLLNode;
import nodes.LLNode;

import java.lang.Comparable;

public class SortedLinkedList<E> implements ListInterface<E> {

	protected DLLNode<E> FrontCar = null, BackCar = null, iterator = null, BackIterator = null, location = null;

	protected boolean found, DirtyFlag = true;
	protected Comparable[] TempList = null;
	protected int position, numElements = 0;

	public SortedLinkedList() {
		super();
	}

	public SortedLinkedList(int initialCapacity) {
		super();
	}

	@Override
	public void add(E element) {
		DLLNode<E> temp = new DLLNode<E>(element);

		if (FrontCar == null) {
			FrontCar = temp;
			BackCar = temp;
		} else if (((Comparable) element).compareTo(FrontCar.getInfo()) <= 0) {
			FrontCar.setPrev(temp);
			temp.setNext(FrontCar);
			FrontCar = temp;
		} else if (((Comparable) element).compareTo(BackCar.getInfo()) >= 0) {
			BackCar.setNext(temp);
			temp.setPrev(BackCar);
			BackCar = temp;
		} else {
			DLLNode<E> cur = FrontCar;
			while (cur != BackCar) {
				if (((Comparable) element).compareTo(cur.getInfo()) > 0) {
					cur = cur.getNext();
				}
					cur.getPrev().setNext(temp);
					temp.setPrev(cur.getPrev());
					temp.setNext(cur);
					cur.setPrev(temp);
					break;
			}
		}
		++numElements;
		System.out.println(toString());
	}

	@Override
	public boolean remove(E element) {
		find2(element);
		if (found) {
				if (FrontCar.getInfo().equals(element)) {
					FrontCar = FrontCar.getNext();
					FrontCar.setPrev(null);
					return found;
			} else if (BackCar.getInfo().equals(element)) {
					BackCar = BackCar.getPrev();
					BackCar.setNext(null);
					return found;
				
			} else {
					location.getPrev().setNext(location.getNext());
					location.getNext().setPrev(location.getPrev());
					return found;
			}
		}
		System.out.println(toString());
		numElements--;
		return false;
	}

	@Override
	public int size() {
		int numElements = 0;
		DLLNode<E> temp = FrontCar;

		while (temp != null) {
			numElements++;
			temp = temp.getNext();
		}
		System.out.println(toString());
		return numElements;
	}

	@Override
	public boolean isEmpty() {
		return FrontCar == null;
	}

	@Override
	public boolean contains(E element) {
		System.out.println("Start Contains 1");
		find(element);
		System.out.println("end Contains 1");
		System.out.println(System.nanoTime());
		System.out.println("Start Contains 2");
		find2(element);
		System.out.println("end Contains 2");
		System.out.println(System.nanoTime());
		return found;
	}

	@Override
	public E get(E element) {
		find(element);
		find2(element);
		E temp = null;
		if (found) {
			temp = location.getInfo();
		}
		return temp;
	}

	@Override
	public void resetIterator() {
		iterator = FrontCar;
		System.out.println(toString());
	}

	public void resetBackIterator() {
		BackIterator = BackCar;
		System.out.println(toString());
	}

	@Override
	public E getNextItem() {
		E temp = null;
		if (iterator != null) {
			temp = iterator.getInfo();
			iterator = iterator.getNext();
		}
		return temp;
	}

	public E getPrevItem() {
		E temp = null;
		if (BackIterator != null) {
			temp = BackIterator.getInfo();
			BackIterator = BackIterator.getPrev();
		}
		return temp;

	}

	public void find(E element) {
		found = false;
		location = FrontCar;
		while (location != null) {
			if (location.getInfo().equals(element)) {
				found = true;
				return;
			}
			location = location.getNext();
		}

	}

	public void find2(E element) {
		if (DirtyFlag == true) {
			TempList = new Comparable[size()];
			DLLNode<E> temp = FrontCar;
			for (int i = 0; i < TempList.length; i++) {
				TempList[i] = (Comparable) temp.getInfo();
				temp = temp.getNext();
			}
			DirtyFlag = false;
		}
		
		found = false;
		position = 0;
		
		int low = 0;
		int high = numElements;
		int mid = 0;
		while(low <= high) {
		
			 mid = (low + high) / 2;
			if(TempList[mid].equals(element)) {
				found = true;
				position = mid;
				break;
			}
			else if(((Comparable)element).compareTo(TempList[mid]) > 0) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		location = FrontCar;
		for(int i=0; i < mid; i++) {
			location = location.getNext();
		}
	}

	public String toString() {
		String CarOrder = "Here is your garage";
		DLLNode<E> Car = FrontCar;
		while (Car != null) {
			String temp = Car.getInfo().toString();
			CarOrder = CarOrder + " " + temp;
			Car = Car.getNext();
		}
		return CarOrder;
	}
}
