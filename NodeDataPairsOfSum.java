package com.gl.datastructure.bst;

import java.util.HashSet;
import java.util.Set;

public class NodeDataPairsOfSum {

	static Node root;

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			super();
			this.data = data;
		}
	}

	NodeDataPairsOfSum() {
		root = null;
	}

	private void insert(int key) {
		root = insertNode(root, key);
	}

	private Node insertNode(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}
		if (key < root.data) {
			root.left = insertNode(root.left, key);
		} else if (key > root.data) {
			root.right = insertNode(root.right, key);
		}
		return root;
	}

	void inOrder() {
		inOrderAction(root);
	}

	private void inOrderAction(Node root) {
		if (root != null) {
			inOrderAction(root.left);
			System.out.print(root.data + " ");
			inOrderAction(root.right);
		}

	}

	public static void main(String[] args) {
		NodeDataPairsOfSum tree = new NodeDataPairsOfSum();
		tree.insert(40);
		tree.insert(20);
		tree.insert(60);
		tree.insert(10);
		tree.insert(30);
		tree.insert(50);
		tree.insert(70);
		int sum = 60;
		tree.findPairWithGivenSum(root, sum);

	}

	private void findPairWithGivenSum(NodeDataPairsOfSum.Node root, int sum) {

		Set<Integer> set = new HashSet<Integer>();
		if (!findPairUntil(root, sum, set)) {
			System.out.println("Pair do not exist" + "\n");
		}
	}

	private boolean findPairUntil(Node root, int sum, Set<Integer> set) {
		if (root == null) {
			return false;
		}
		if (findPairUntil(root.left, sum, set)) {

			return true;
		}
		if (set.contains(sum - root.data)) {
			System.out.println("Sum=" + sum);
			System.out.println("Pair is found (" + (sum - root.data) + "," + root.data + ")");
			return true;
		} else {
			set.add(root.data);

			return findPairUntil(root.right, sum, set);
		}
	}
}
