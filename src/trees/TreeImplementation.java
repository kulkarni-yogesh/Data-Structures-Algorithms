package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeImplementation {

	static int MAX_LEVEL = 0;
	static Node root;
	List<Integer> nodes = new ArrayList<Integer>();

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
	public Node recursionTest(Node current) {

		if (current != null) {
			System.out.print("\nExecuting head recursion");
			inorder(current.left);
			System.out.print(current.value + "\t");
			System.out.print("\nExecuting tail recursion");
			inorder(current.right);
		}

		return current;
	}

	public List<Integer> inorderList(Node current) {
		List<Integer> pathList = new ArrayList<Integer>();
		if (current != null) {
			inorder(current.left);
			pathList.add(current.value);
			inorder(current.right);
		}

		return pathList;
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

	public int height(Node current) {
		if (root == null)
			return 0;
		return Math.max(height(current.left), height(current.right)) + 1;
	}

	public List<Integer> bfsTraversal(Node current) {

		if (current != null) {
			nodes.add(current.value);
			if (current.left != null) {
				nodes.add(current.left.value);

			}
			if (current.right != null) {
				nodes.add(current.right.value);
			}

		}

		return nodes;
	}

	public void levelOrderTraversal(Node current) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(current);
		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.print(tempNode.value + "\t");
			if (tempNode.left != null)
				queue.add(tempNode.left);
			if (tempNode.right != null)
				queue.add(tempNode.right);
		}
	}

	public Node invertTree(Node node) {
		if (node == null)
			return node;

		/* recursive calls */
		Node left = invertTree(node.left);
		Node right = invertTree(node.right);

		/* swap the left and right pointers */
		node.left = right;
		node.right = left;

		return node;
	}

	public void printTree(Node current) {

		if (current == null) {
			return;
		}

		printTree(current.left);
		System.out.print(current.value + "\t");
		printTree(current.right);

	}

	public void leftViewOfTree(Node current, int level) {
		if (current == null)
			return;

		if (MAX_LEVEL < level) {
			System.out.print(current.value + "\t");
			MAX_LEVEL = level;
		}
		leftViewOfTree(current.left, level + 1);
		leftViewOfTree(current.right, level + 1);
	}

	public static void main(String[] args) {
		root = new Node(10);

		TreeImplementation treeImplementation = new TreeImplementation();

		treeImplementation.add(14);
		treeImplementation.add(11);
		treeImplementation.add(5);
		treeImplementation.add(4);
		treeImplementation.add(6);
		treeImplementation.add(15);
		
		System.out.println("Recursion Test:");
		treeImplementation.recursionTest(root);
		System.out.println();
		System.out.println();

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
		System.out.println();
		System.out.println();
		
		// System.out.print(treeImplementation.bfsTraversal(root));
		System.out.println("Level Order Traversal:");
		System.out.println();
		System.out.println();
		treeImplementation.levelOrderTraversal(root);
		
		System.out.println();
		System.out.println("Inverted Tree:");
		System.out.println();
		System.out.println();
		treeImplementation.invertTree(root);
		treeImplementation.inorder(root);
		
		System.out.println();
		System.out.println();
		System.out.println("Left View Of Tree:");
		System.out.println();
		System.out.println();
		treeImplementation.leftViewOfTree(root, 1);
	

	}

}
