package com.neetcode.arrarysAndHashing;

import java.util.Hashtable;

/**
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 * 
 * @author arupdutta
 *
 */
public class ContainsDuplicate {

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,1};
		System.out.println(checkDup(nums1));
		int[] nums2 = {1,2,3,4};
		System.out.println(checkDup(nums2));
	}
	
	public static boolean checkDup(int[] input){
		Hashtable<Integer,Integer> inputtable = new Hashtable<>();
		for(int i : input){
			if(inputtable.contains(i)){
				return true;
			}
			inputtable.put(i, i);
		}
		return false;
	}

}
