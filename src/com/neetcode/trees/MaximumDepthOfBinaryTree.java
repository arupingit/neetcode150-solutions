package com.neetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * @author arupdutta
 *
 */
public class MaximumDepthOfBinaryTree {
	
	 public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	 }

	public static void main(String[] args) {
		MaximumDepthOfBinaryTree t = new MaximumDepthOfBinaryTree();
		TreeNode root = t.new TreeNode(3);
		t.createTree(root, 9, 20);
		t.createTree(root.right, 15, 7);
		
		t.printTree(root);
		
		System.out.println("\nMax Depth : "+ t.maxDepth(root));
	}

	
	public int maxDepth(TreeNode root) {
		if(root==null){
			return 0;
		} else {
			return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
		}
    }
	
	//Util Functions
	public TreeNode createTree(TreeNode root, int leftNodeVal, int rightNodeVal){
		root.left = new TreeNode(leftNodeVal);
		root.right = new TreeNode(rightNodeVal);
		return root;
	}
	
	//BFS parsing and printing the nodes
	public void printTree(TreeNode root){
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode tempNode;
		q.add(root);
		while(!q.isEmpty()){
			tempNode = q.poll();
			System.out.print(tempNode.val + ",");
			if(tempNode.left!=null){
				q.add(tempNode.left);				
			}
			if(tempNode.right!=null){
				q.add(tempNode.right);				
			}
		}
	}
}
