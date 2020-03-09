package apps;

import nodes.LLNode;

public class LLPlay {

	public static void main(String[] args) {
		
		LLNode<Integer> newNode = new LLNode(3);
		
		LLNode<Integer> head = newNode;
		
		newNode = new LLNode(1);
		newNode.setNext(head);
		head = newNode;
		newNode = new LLNode(4);
		newNode.setNext(head);
		head = newNode;
		newNode = new LLNode(1);
		newNode.setNext(head);
		head = newNode;
		
		LLNode<Integer> ptr = head;
		
		while (ptr != null) {
			System.out.print(ptr.getInfo() + " ");
			ptr = ptr.getNext();
		}
		
	}

}
