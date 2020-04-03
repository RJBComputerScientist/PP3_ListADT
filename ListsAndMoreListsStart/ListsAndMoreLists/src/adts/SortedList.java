package adts;

import nodes.DLLNode;
import interfaces.ListInterface;

public class SortedList<E> implements ListInterface<E> {

	protected DLLNode<E> head;
	protected DLLNode<E> tail;
	protected DLLNode<E> ipos; // guessing i stands for iterator and b for back iterator?
	protected DLLNode<E> bpos;
	protected boolean found;
	protected int location;
	
	protected int numElements = 0;
	
	public SortedList() {
		head = null;
		tail = null;
	}  
	
	@Override
	@SuppressWarnings("unchecked")
	public void add(E element) {
		System.out.println("21 (method start)-----------------------------------------" + element);
		DLLNode<E> newNode = new DLLNode<E>(element);
		System.out.println("23 (newNode)--------------------------------------------" + element);
		System.out.println("size: " + size());
		switch(size()) {	
			case 0:
				head = newNode;
				break;
			case 1: // the bug is in this block of the case statement somewhere, preventing more than 1 item from being added
				System.out.println((((Comparable)element).compareTo(head.getInfo()) > 0));
				/*example of comparable
				 * 			if (((Comparable)element).compareTo(list[addLocation]) > 0) {
							addLocation++;
							}
				 * 
				 * 
				 * 
				 */
				
				
				
			//	if(((Comparable<E>)element).compareTo(head.getInfo()) > 0) {
				if(((Comparable)element).compareTo(head.getInfo()) > 0) {
					head.setNext(newNode);
					newNode.setPrev(head);
					tail = newNode;
					System.out.println("<<<<<<<<<<HEAD<<<<<<<<<<<    tail: " + tail);
				} else {
					newNode.setNext(head);
					head.setPrev(newNode);
					tail = head;
					head = newNode;
					System.out.println(">>>>>>>>>TAIL>>>>>>>>>>>     head:" + head);
				}
				break;	
			default:
				System.out.println("56 -------------------------------------------------------" + element);
				DLLNode<E> ptr = head;
				int tempCtr = numElements; //using this to count down and end the loop 
				//while(ptr.getNext() != null) { //now theres an infinite loop here too, gonna try to fix this
				while(tempCtr>=0) {
					if (((Comparable<E>)element).compareTo(ptr.getInfo()) > 0) {
						ptr = ptr.getNext();
						tempCtr--;
						System.out.println("61 -------------------------------------------------------" + element);
						//continue;
					}
					System.out.println("64 -------------------------------------------------------" + element);
					break;	
				}
				if(ptr.getPrev() == null) {
					System.out.println("68 -------------------------------------------------------" + element);
					newNode.setNext(ptr);
					ptr.setPrev(newNode);
					head = newNode;
					System.out.println("72 -------------------------------------------------------" + element);
				} else if (ptr.getNext() == null){
					System.out.println("74 -------------------------------------------------------" + element);
					newNode.setPrev(ptr);
					ptr.setNext(newNode);
					tail = newNode;
					System.out.println("78 -------------------------------------------------------" + element);
				} else {
					System.out.println("80 -------------------------------------------------------" + element);
					ptr.getPrev().setNext(newNode);
					newNode.setPrev(ptr.getPrev());
					newNode.setNext(ptr);
					ptr.setPrev(newNode);
					System.out.println("85 -------------------------------------------------------" + element);
				}
				System.out.println("87 -------------------------------------------------------" + element);
				break; //there was only a break in the while loop, maybe this is why it kept getting stuck? EDIT: no it wasn't, remove this later? idk
			}
		System.out.println("90 -------------------------------------------------------" + element);	
		resetIterator();
		System.out.println("92 -------------------------------------------------------" + element);
		resetBackIterator();
		numElements++;
		System.out.println("94 (end of method)----------------------------------------" + element);
	}

	@Override
	public boolean remove(E element) {
		// TODO WRITE A METHOD HERE!!!!!
		numElements--; //this'll probably go at the end
		return false;
	}

	@Override
	public int size() {
		/*
		//DLLNode<E> ptr = head; 
		DLLNode<E> ptr = tail; //using this instead fixes the loop but only reports the size as 0 every time
		//this way of doing size is laggy and buggy, might just have a numElements counter like ArraySortedlist
		int size = 0;
		while(ptr != null) { //finally found the infinite loop, it's here but only when there's 2 elements in the list
			ptr = ptr.getNext();
			size++;
			System.out.println("(size method test within method ln 111) size: " + size); 
		} 
		return size; */
		return numElements;
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
		DLLNode<E> ptr = head;
		E temp;
		int tempCtr = numElements; //using this to count down and end the loop 
		//while(ptr.getNext() != null) { //now theres an infinite loop here too, gonna try to fix this

		
		
		find(element);
		if (found) {
			while(tempCtr>=location) {
				if (!element.equals(ptr.getInfo())) {
					ptr = ptr.getNext();
					tempCtr--;
				} else {
					temp = ptr.getInfo();
					return temp;
				}
			}
		}
		//else {
			temp = null;
			return temp;
	//	}
	}
	
	
	public void find(E target) {
		found = false;
		location = 0;
		int low = 0;
		int high = numElements - 1;
		
		//temporary find method for testing purposes, does not use binary search
		//REPLACE LATER WHEN THE FIND METHOD IS DONE!
		//THIS IS NOT FINALIZED!!!
		DLLNode<E> ptr = head;
		E temp;
		int tempCtr = numElements; //using this to count down and end the loop 
		//while(ptr.getNext() != null) { //now theres an infinite loop here too, gonna try to fix this
		while(tempCtr>=0) {
			if (!target.equals(ptr.getInfo())) {
				ptr = ptr.getNext();
				tempCtr--;
				location++;
			} else {
				tempCtr = 0;
				found = true;
				//location = ptr.
			}
		}
		
		/*  example of binary search
		while(low <= high) {
			int mid = (low + high) / 2;
			if (target.equals(list[mid])) {
				found = true;
				location = mid;
				return;
			} 
			else {
				if(((Comparable)target).compareTo(list[mid]) > 0) {
					low = mid + 1;
				}
				else {
					high = mid - 1;
				} 
			} 
		} */
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
	
	public void find()
	{
		System.out.println("TEST");
	}
	
	@Override
	public String toString() {
		String str = "-HEAD-";
		DLLNode<E> ptr = head;
		//while(ptr != null) { //another infinite loop I think
		int tempCtr = numElements; //using this to count down and end the loop 
		while(tempCtr>=0) {
			tempCtr--;
			str += "[" + ptr.getInfo() + "]";
			ptr = ptr.getNext();
		}
		str += "-TAIL-";
		return str;
	}
}
