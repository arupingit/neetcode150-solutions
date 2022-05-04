package com.neetcode.arrarysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/submissions/
 * 
 * @author arupdutta
 *
 */
public class TwoSum {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15} , 9)));
		System.out.println(Arrays.toString(twoSum(new int[]{3,2,4} , 6)));
		System.out.println(Arrays.toString(twoSum(new int[]{3,3} , 6)));
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> twoSumMap = new HashMap<>();
		for(int i=0; i< nums.length; i++){
			if(twoSumMap.containsKey(nums[i])){
				return new int[]{twoSumMap.get(nums[i]), i};
			} else{
				twoSumMap.put(target - nums[i], i);
			}
		}
		return new int[]{};
    }
}
