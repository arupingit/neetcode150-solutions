package com.neetcode.linkedList;

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 * @author arupdutta
 *
 */
public class MergeTwoSortedLists {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public static void main(String[] args) {
		MergeTwoSortedLists mergeList = new MergeTwoSortedLists();
		ListNode list1 = mergeList.createList(new int[]{1,2,4});
		ListNode list2 = mergeList.createList(new int[]{1,3,4});
		ListNode result = mergeList.mergeTwoLists(list1, list2);
		mergeList.printNodes(result);
	}
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      ListNode newListNodeHead;
      ListNode newListNodePointer;    
      newListNodeHead = newListNodePointer = new ListNode();
      
      while(list1!=null || list2!=null){
    	  if(list1==null){
    		  newListNodePointer.next = list2;
    		  break;
    	  } else if(list2==null){
    		  newListNodePointer.next = list1;
    		  break;
    	  } else {
    		  if(list1.val<=list2.val){
    	    	  newListNodePointer.next = list1;
    	    	  list1 = list1.next;
    	      } else {
    	    	  newListNodePointer.next = list2;
    	    	  list2 = list2.next;
    	      }
    		  newListNodePointer = newListNodePointer.next;
    	  }
      }
      
      return newListNodeHead.next;
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
