package com.neetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/
 * 
 * @author arupdutta
 *
 */
public class InvertBinaryTree {
	
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
		InvertBinaryTree ibt = new InvertBinaryTree();
		TreeNode root = ibt.new TreeNode(4);
		ibt.createTree(root, 2, 7);
		ibt.createTree(root.left, 1, 3);
		ibt.createTree(root.right, 6, 9);
		
		ibt.printTree(root);
		
		System.out.println("");
		
		ibt.invertTree(root);
		ibt.printTree(root);
	}
	
	public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }

        //swap the children
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
	
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
