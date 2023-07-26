package linkedList;

import java.util.Scanner;

class SinglyLL {
	public static class Node {
		private int data;
		private Node next;

		public Node() {
			this.data = 0;
			this.next = null;
		}

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head;

	public SinglyLL() {
		this.head = null;
	}
	int count=0;

	public void displayAll() {
		
		if (head == null) {
			throw new RuntimeException("Nothing to display");
		}
		Node trav = head;
		while (trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
			count++;
		}
		System.out.println(count);
	}

	public void addFirst(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	public void addLast(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
		} else {
			Node trav = head;
			while (trav.next != null) {
				trav = trav.next;
			}
			trav.next = newNode;
		}
	}

	public void addAtPosition(int val, int pos) {
		if (head == null || pos < 1) {
			addFirst(val);
		} else {
			Node newNode = new Node(val);
			Node trav = head;
			for (int i = 1; i < pos - 1; i++) {
				// if pos is greater than list
				if (trav.next == null) {
					break;
				}
				trav = trav.next;
			}
			newNode.next = trav.next;
			trav.next = newNode;
		}
	}

	public void deleteFirst() {
		if (head == null) {
			throw new RuntimeException("Nothing to delete");
		} else {
			head = head.next;
		}
	}

	public void deleteAll() {
		if (head == null) {
			throw new RuntimeException("Nothing to delete");
		} else {
			head = null;
		}
	}

	public void deleteLast() {
		if (head == null) {
			throw new RuntimeException("Nothing to delete");
		} else {
			Node trav = head;
			Node temp = null;
			while (trav.next != null) {
				temp = trav;
				trav = trav.next;
			}
			temp.next = null;
		}
	}

	public void deleteAtPos(int pos) {

		if (pos == 1)
			deleteFirst();
		if (head == null || pos < 1)
			throw new RuntimeException("List is empty or Invalid position.");
		Node temp = null, trav = head;
		for (int i = 1; i < pos; i++) {
			if (trav == null)
				throw new RuntimeException("Invalid position.");
			temp = trav;
			trav = trav.next;
		}
		temp.next = trav.next;
	}
	public void reverseList() {
		Node oldhead = head;
	    head = null;
		while(oldhead!=null) {
			Node temp = oldhead;
			oldhead = oldhead.next;
			
			temp.next = head;
			head = temp;
		}
	}
	public void sortList() {
		Node i,j;
		for(i=head;i!=null;i=i.next) {
			for(j=i.next;j!=null;j=j.next) {
				if(i.data>j.data) {
					int temp = i.data;
					i.data = j.data;
					j.data = temp;
				}
			}
		}
	}
	public int findMiddle() {
		Node fast=head,slow=head;
		while(fast!=null&&fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}
	public void reverseDisplay() {
		int[] arr=new int[count];
		Node trav = head;
		for(int i=0;i<count;i++) {
			arr[i] = trav.data;
			trav = trav.next;
		}
		for(int i=count;i>0;i--) {
			System.out.println(arr[i]);
		}
	}
}

public class SingleLinkedList {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SinglyLL list = new SinglyLL();
		int choice, val, pos;

		do {
			System.out.println("Enter your choice");
			System.out.println("\n0. Exit\n1. Display\n2. Add First\n3.  Add Last\n"
					+ "4. Add At Pos\n5. Del First\n6.  Del Last\n" + "7. Del At Pos\n8. Del All\nEnter choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				list.displayAll();

				break;
			case 2:
				System.out.println("Enter the element : ");
				val = sc.nextInt();
				list.addFirst(val);

				break;
			case 3:
				System.out.println("Enter the element : ");
				val = sc.nextInt();
				list.addLast(val);

				break;
			case 4:
				System.out.println("Enter the element and position");
				val = sc.nextInt();
				pos = sc.nextInt();
				list.addAtPosition(val, pos);

				break;
			case 5:
				list.deleteFirst();

				break;
			case 6:
				list.deleteLast();

				break;
			case 7:
				System.out.println("Enter the positon");
				pos = sc.nextInt();
				list.deleteAtPos(pos);

				break;
			case 8:
				list.deleteAll();

				break;
			case 9:
				list.reverseList();
				break;
				
			case 10:
				list.sortList();
				break;
			case 11:
				System.out.println(list.findMiddle());
				break;
				
			case 12:
				list.reverseDisplay();

			default:
				System.out.println("Thank you!!!!");
				break;
			}

		} while (choice <= 11);
		sc.close();
	}

}
