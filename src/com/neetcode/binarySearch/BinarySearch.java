package com.neetcode.binarySearch;

/**
 * 704. Binary Search
 * https://leetcode.com/problems/binary-search/
 * O(log n) runtime complexity.
 * 
 * @author arupdutta
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		System.out.println(search(new int[] {-1,0,3,5,9,12}, 9));
		System.out.println(search(new int[] {-1,0,3,5,9,12}, 2));
	}

	public static int search(int[] nums, int target) {
		int leftPointer = 0;
		int rightPointer = nums.length -1;
		int midPointer;
		while(leftPointer <= rightPointer){
			midPointer = (leftPointer+rightPointer)/2;
			if(nums[midPointer]>target){
				rightPointer = midPointer-1;
			} else if(nums[midPointer]<target){
				leftPointer = midPointer+1;
			} else {
				return midPointer;
			}
		}
        return -1;
    }
}
