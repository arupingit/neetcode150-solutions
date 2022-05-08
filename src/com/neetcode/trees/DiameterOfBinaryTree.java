package com.neetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 543. Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * 
 * @author arupdutta
 *
 */
public class DiameterOfBinaryTree {
	
	public static int maxHeight =0;
	
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
		DiameterOfBinaryTree t = new DiameterOfBinaryTree();
		TreeNode root = t.new TreeNode(1);
		t.createTree(root, 2, 1);
		t.createTree(root.left, 4, 5);
		t.createTree(root.right, 1, null);	
		t.printTree(root);
		t.diameterOfBinaryTree(root);
		System.out.println("\nMax Depth : "+ maxHeight);
	}

	public int diameterOfBinaryTree(TreeNode root) {
		if(root==null){
			return -1;
		}
		int left = diameterOfBinaryTree(root.left);
		int right = diameterOfBinaryTree(root.right);
		maxHeight = Math.max(maxHeight, left+right+2);
		return 1+ Math.max(left,right);
	}
		
		//Util Functions
		public TreeNode createTree(TreeNode root, Integer leftNodeVal, Integer rightNodeVal){
			if(leftNodeVal!=null){
				root.left = new TreeNode(leftNodeVal);				
			}
			if(rightNodeVal!=null){
				root.right = new TreeNode(rightNodeVal);				
			}
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
