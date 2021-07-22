package linked_list;

public class LinkedList {

	Node head;

	public class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;

		}

		@Override
		public String toString() {
			return "" + data;
		}

	}

	public LinkedList insert(LinkedList list, int data) {
		Node new_node = new Node(data);
		new_node.next = null;

		if (list.head == null) {
			list.head = new_node;
		} else {
			Node last_node = list.head;
			while (last_node.next != null) {

				last_node = last_node.next;
			}
			last_node.next = new_node;
		}

		return list;

	}

	public static void printList(LinkedList list) {
		Node current_node = list.head;
		while (current_node != null) {
			System.out.print(current_node.data + " -> ");
			current_node = current_node.next;

		}

	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		list.insert(list, 1);
		list.insert(list, 2);
		list.insert(list, 3);
		list.insert(list, 4);
		list.insert(list, 5);
		list.insert(list, 6);
		list.insert(list, 7);

		printList(list);

	}

}
