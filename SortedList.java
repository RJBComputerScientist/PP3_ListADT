package adts;

import nodes.DLLNode;
import interfaces.ListInterface;

public class SortedList<E> implements ListInterface<E> {

	protected DLLNode<E> head;
	protected DLLNode<E> tail;
	protected DLLNode<E> ipos;
	protected DLLNode<E> bpos;
	
	public SortedList() {
		head = null;
		tail = null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void add(E element) {
		
		DLLNode<E> newNode = new DLLNode<E>(element);
		
		//Do this if list is empty
		if(isEmpty()) {
			head = newNode;
			tail = head;
			resetIterator();
			resetBackIterator();
			return;
		}
		
		//Do this if list has 1 element
		if(size() == 1) {
			if(((Comparable<E>)element).compareTo(head.getInfo()) > 0) {
				head.setNext(newNode);
				newNode.setPrev(head);
				tail = newNode;
				resetIterator();
				resetBackIterator();
				return;	
			} else {
				newNode.setNext(head);
				head.setPrev(newNode);
				head = newNode;
				tail = newNode.getNext();
				resetIterator();
				resetBackIterator();
				return;
			}
		}
		
		//do this if list has more than 1 element
		DLLNode<E> ptr = head;
		while(ptr.getNext() != null) {
			if (((Comparable<E>)element).compareTo(ptr.getInfo()) > 0) {
				ptr = ptr.getNext();
				continue;
			}
			break;	
		}
		if(ptr.getPrev() == null) {
			newNode.setNext(ptr);
			ptr.setPrev(newNode);
			head = newNode;
		} else if (ptr.getNext() == null){
			newNode.setPrev(ptr);
			ptr.setNext(newNode);
			tail = newNode;
		} else {
			ptr.getPrev().setNext(newNode);
			newNode.setPrev(ptr.getPrev());
			newNode.setNext(ptr);
			ptr.setPrev(newNode);
		}
		resetIterator();
		resetBackIterator();
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
			size++;
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
		ipos = head;
	}
	
	public void resetBackIterator() {
		bpos = tail;
	}

	@Override
	public E getNextItem() {
		E element = ipos.getInfo();
		ipos = ipos.getNext();
		
		if(ipos == null)
			resetIterator();
		
		return element;
	}
	
	public E getPrevItem() {
		E element = bpos.getInfo();
		bpos = bpos.getPrev();
		
		if(bpos == null)
			resetBackIterator();
		
		return element;
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
