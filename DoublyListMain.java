package linkedList;

import java.util.Scanner;

class DoublyList {
    static class Node {
        private int data;
        private Node next;
        private Node prev;

        public Node() {
            data = 0;
            next = null;
            prev = null;
        }

        public Node(int val) {
            data = val;
            next = null;
            prev = null;
        }
    }

    private Node head;

    public DoublyList() {
        head = null;
    }

    public void displayForward() {
        System.out.println("Fwd List: ");
        Node trav = head;
        while (trav != null) {
            System.out.println(trav.data);
            trav = trav.next;
        }
    }

    public void displayReverse() {
        System.out.println("Rev List: ");
        if (head == null)
            return;
        Node trav = head;
        while (trav.next != null)
            trav = trav.next;
        while (trav != null) {
            System.out.println(trav.data);
            trav = trav.prev;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node trav = head;
            while (trav.next != null)
                trav = trav.next;
            trav.next = newNode;
            newNode.prev = trav;
        }
    }

    void addFirst(int val) {
        Node newNode = new Node(val);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addAtPos(int val, int pos) {
        if (head == null || pos <= 1)
            addFirst(val);
        else {
            Node newNode = new Node(val);
            Node temp, trav = head;
            for (int i = 1; i < pos - 1; i++) {
                if (trav.next == null)
                    break;
                trav = trav.next;
            }
            temp = trav.next;
            newNode.next = temp;
            newNode.prev = trav;
            trav.next = newNode;
            if (temp != null)
                temp.prev = newNode;
        }
    }

    public void delFirst() {
        if (head == null)
            throw new RuntimeException("List is empty.");
        if (head.next == null)
            head = null;
        else {
            head = head.next;
            head.prev = null;
        }
    }

    public void delAtPos(int pos) {
        if (pos == 1)
            delFirst();
        if (head == null || pos < 1)
            throw new RuntimeException("List is empty or Invalid position.");
        Node trav = head;
        for (int i = 1; i < pos; i++) {
            if (trav == null)
                throw new RuntimeException("Invalid position.");
            trav = trav.next;
        }
        trav.prev.next = trav.next;
        if (trav.next != null)
            trav.next.prev = trav.prev;
    }
}

public class DoublyListMain {
    public static void main(String[] args) {
        int choice, val, pos;
        DoublyList list = new DoublyList();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n0. Exit\n1. Display\n2. Add First\n3. Add Last\n4. Add At Pos\n5. Del First\n6. Del Last\n7. Del At Pos\n8. Del All\nEnter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    list.displayForward();
                    list.displayReverse();
                    break;
                case 2:
                    System.out.print("Enter new element: ");
                    val = sc.nextInt();
                    list.addFirst(val);
                    break;
                case 3:
                    System.out.print("Enter new element: ");
                    val = sc.nextInt();
                    list.addLast(val);
                    break;
                case 4:
                    System.out.print("Enter new element: ");
                    val = sc.nextInt();
                    System.out.print("Enter element position: ");
                    pos = sc.nextInt();
                    list.addAtPos(val, pos);
                    break;
                case 5:
                    try {
                        list.delFirst();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    break;
                case 7:
                    System.out.print("Enter element position: ");
                    pos = sc.nextInt();
                    try {
                        list.delAtPos(pos);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    break;
            }
        } while (choice != 0);
        sc.close();
    }
}
