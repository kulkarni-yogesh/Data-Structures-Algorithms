package trees;

public class TreeImplementation {

	static Node root;

	static class Node {
		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	public Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}

		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			return current;
		}

		return current;
	}

	public void add(int value) {
		root = addRecursive(root, value);
	}

	public Node inorder(Node current) {

		if (current != null) {
			inorder(current.left);
			System.out.print(current.value + "\t");
			inorder(current.right);
		}

		return current;
	}

	public Node preOrder(Node current) {

		if (current != null) {
			System.out.print(current.value + "\t");
			preOrder(current.left);
			preOrder(current.right);
		}

		return current;
	}

	public Node postOrder(Node current) {
		if (current != null) {
			postOrder(current.left);
			postOrder(current.right);
			System.out.print(current.value + "\t");
		}

		return current;
	}

	public static void main(String[] args) {
		root = new Node(10);

		TreeImplementation treeImplementation = new TreeImplementation();

		treeImplementation.add(14);
		treeImplementation.add(11);
		treeImplementation.add(5);
		treeImplementation.add(4);
		treeImplementation.add(6);

		System.out.println("In Order Traversal:");		
		treeImplementation.inorder(root);
		System.out.println();
		System.out.println();
		System.out.println("Pre Order Traversal:");		
		treeImplementation.preOrder(root);
		System.out.println();
		System.out.println();
		System.out.println("Post Order Traversal:");
		treeImplementation.postOrder(root);

	}

}
