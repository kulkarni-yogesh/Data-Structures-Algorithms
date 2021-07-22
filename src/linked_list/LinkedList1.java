package linked_list;

public class LinkedList1 {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "" + data;
		}

	}

	public LinkedList1 insert(LinkedList1 list, int data) {
		Node new_node = new Node(data);
		new_node.next = null;

		if (list.head == null) {
			list.head = new_node;
		} else {
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = new_node;
		}

		return list;
	}

	public LinkedList1 insertAtPosition(LinkedList1 list, int data, int position) {
		Node new_node = new Node(data);

		if (list.head == null) {
			list.head = new_node;
		} else {
			int index = 1;
			Node current_node = list.head;
			while (index <= position && current_node.next != null ) {
				
				if (index == position) {
					Node previous_node = current_node;
					previous_node.next = new_node;					
					new_node.next = current_node.next;
				}else {
					current_node = current_node.next;
					index++;
				}

				

			}
		}

		return list;
	}

	public void printList(LinkedList1 list) {
		Node current_node = list.head;
		while (current_node != null) {
			System.out.print(current_node.data + " -> ");
			current_node = current_node.next;
		}

	}

	public static void main(String[] args) {
		LinkedList1 list = new LinkedList1();
		list.insert(list, 10);
		list.insert(list, 20);
		list.insert(list, 30);

		list.insert(list, 50);
		list.insert(list, 60);
		list.printList(list);
		list.insertAtPosition(list, 40, 4);
		System.out.println();
		list.printList(list);

	}

}
