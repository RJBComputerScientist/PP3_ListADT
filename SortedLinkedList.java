package Sorted;

import interfaces.ListInterface;
import nodes.DLLNode;
import java.lang.Comparable;
public class SortedLinkedList<E> implements ListInterface<E> {
	
	protected DLLNode<E> FrontCar=null, BackCar=null, iterator=null, BackIterator = null,
			location=null; 
	
	protected boolean found, DirtyFlag = true;
	protected Comparable[] TempList = null;
	protected int position;

	@Override
	public void add(E element) {
		DLLNode<E> temp = new DLLNode<>(element);
		
		if(FrontCar == null) {
			FrontCar = temp;
			BackCar = temp;
			
		}
		else {
			DLLNode<E> Cur = FrontCar;
			Comparable<E> c = null;
			Comparable<E> e = null;
			if(element instanceof Comparable<?>){
				e = (Comparable<E>)element;
			}
			if(Cur instanceof Comparable<?>) {
				c = (Comparable<E>)Cur.getInfo();
			}
			while(c.compareTo(e) < 0 && Cur != null) {
				Cur = Cur.getNext();
				if(Cur instanceof Comparable<?>) {
					c = (Comparable<E>)Cur.getInfo();
				}
			}
			if(Cur == null) {
				BackCar.setNext(temp);
				temp.setPrev(BackCar);
				BackCar = temp;
			}
			else if(Cur == FrontCar){
				FrontCar.setPrev(temp);
				temp.setNext(FrontCar);
				FrontCar = temp;
			}
			else {
				Cur.getPrev().setNext(temp);
				Cur.setPrev(temp);
			}
			FrontCar.setPrev(temp);
			FrontCar = temp;
			
		}
		DirtyFlag = true;
		//}
	}

	@Override
	public boolean remove(E element) {
		find(element);
		if(found) {
			if(location.getPrev() != null) {
				location.getPrev().setNext(location.getNext());
			}
			else {
				FrontCar = location.getNext();
				location.getNext().setPrev(null);
			}
			if(location.getNext() != null) {
				location.getNext().setPrev(location.getPrev());
			}
			else {
				BackCar = location.getPrev();
				location.getPrev().setNext(null);
			}
			DirtyFlag = true;
		}
		return found;
		
	}

	@Override
	public int size() {
		int numElements = 0;
		DLLNode<E> temp = FrontCar;
		
		while(temp != null) {
			numElements++;
			temp = temp.getNext();
		}
		return numElements;
	}

	@Override
	public boolean isEmpty() {
		
		return FrontCar == null;
	}

	@Override
	public boolean contains(E element) {
		find(element);
		return found;
	}

	@Override
	public E get(E element) {
		find(element);
		E temp = null;
		if(found) {
			temp = location.getInfo();
		}
		return temp;
	}

	@Override
	public void resetIterator() {
		iterator=FrontCar;
		
	}
	
	public void resetBackIterator() {
		BackIterator = BackCar;
	}

	@Override
	public E getNextItem() {
		E temp = null;
		if(iterator != null) {
			temp = iterator.getInfo();
			iterator = iterator.getNext();
		}
		
		return temp;
	}
	
	public E getPrevItem() {
		E temp = null;
		if(BackIterator != null) {
			temp = BackIterator.getInfo();
			BackIterator = BackIterator.getPrev();
		}
		
		return temp;
		
	}
	
	public void find(E element) {
		found = false;
		location = FrontCar;
		
		while(location != null) {
			if(location.getInfo().equals(element)) {
				found = true;
				return;
			}
			location = location.getNext();
		}
		

	}
	public void find2(E element) {
		if(DirtyFlag == true) {
			TempList = new Comparable[size()];
			DLLNode<E> temp = FrontCar;
			for(int i = 0; i < TempList.length; i++) {
				TempList[i] = (Comparable) temp.getInfo();
				temp = temp.getNext();
			}
			DirtyFlag = false;
		}
		int low = 0;
		int high = TempList.length - 1;
		 position = -1;
		found = false;
		
		int mid = (low + high) / 2;
		while(low <= high && found == false) {
			mid = (low + high) / 2;
			if(TempList[mid].equals(element)) {
				found = true;
				position = mid;
			}
			else if(TempList[mid].compareTo(element) < 0) {
					high = mid - 1;
				}
			else if(TempList[mid].compareTo(element) > 0) {
				low = mid + 1;
			}
			}
		}
	}


)