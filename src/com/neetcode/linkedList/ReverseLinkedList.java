package com.neetcode.linkedList;

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 * 
 * @author arupdutta
 *
 */
public class ReverseLinkedList {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public static void main(String[] args) {
		ReverseLinkedList rl = new ReverseLinkedList();
		ListNode head = rl.createList(new int[]{1,2,3,4,5});
		rl.printNodes(head);
		System.out.println("");
		ListNode reverseHead = rl.reverseList(head);
		rl.printNodes(reverseHead);
	}
	
	public ListNode reverseList(ListNode head) {
        return reverse(head,null);
    }
	
	public ListNode reverse(ListNode rightNode, ListNode leftNode){
		if(rightNode==null){
			return leftNode;
		}
		ListNode temp = rightNode.next;
		rightNode.next = leftNode;
		leftNode = rightNode;
		rightNode = temp;
		return reverse(rightNode, leftNode);
	}

	//Util functions
	public ListNode createList(int[] nodes){
		ListNode tempNode;
		ListNode tailNode = new ListNode(nodes[0]);
		ListNode dummyNode = tailNode;
		for(int i=1;i<nodes.length;i++){
			tempNode = new ListNode(nodes[i]);
			tailNode.next = tempNode;
			tailNode = tempNode;
		}
		return dummyNode;
	}
	
	public void printNodes(ListNode node){
		while(node!=null){
			System.out.print(node.val + "-->");
			node = node.next;
		}
	}
}
