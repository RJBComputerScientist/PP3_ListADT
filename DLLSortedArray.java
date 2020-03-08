package adts;

import interfaces.ListInterface;
import nodes.DLLNode;

public class DLLSortedArray<E> implements ListInterface<E> {
	
	protected DLLNode<E> head;
	protected DLLNode<E> tail;
		
	public DLLSortedArray() {
		head = null;
		tail = null;
	}
	
	@Override
	public void add(E element) {
		
		DLLNode<E> newNode = new DLLNode<E>(element);
		
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
			return;
		}
		
		DLLNode<E> ptr = head;
		while(ptr.getNext() != null) {
			if (((Comparable<E>)element).compareTo(ptr.getInfo()) > 0) 
				ptr = ptr.getNext();
			else
				break;
		}
		
		if(ptr.getPrev() != null)
			ptr.getPrev().setNext(newNode);
		newNode.setPrev(ptr.getPrev());
		ptr.setPrev(newNode);
	    newNode.setNext(ptr);
		
		
	}

	@Override
	public boolean remove(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		DLLNode<E> ptr = head;
		int size = 0;
		while(ptr != null) {
			ptr = ptr.getNext();
			++size;
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetIterator() {
		
	}

	@Override
	public E getNextItem() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		String str = "-HEAD-";
		
		DLLNode<E> ptr = head;
		
		while(ptr != null) {
			str += "[" + ptr.getInfo() + "]";
			ptr = ptr.getNext();
		}
		str += "-TAIL-";
		return str;
	}
}
