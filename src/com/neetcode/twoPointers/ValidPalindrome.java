package com.neetcode.twoPointers;

/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 * 
 * @author arupdutta
 *
 */
public class ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
		System.out.println(isPalindrome(" "));
		System.out.println(isPalindrome("0P"));
	}

	public static boolean isPalindrome(String s) {
		if(s.length()<2){
        	return true;
        }
		int leftPointer = 0;
        int rightPointer = s.length() - 1;
		String lowerCaseS = s.toLowerCase();
        char leftChar;
        char rightChar;
        while(leftPointer<rightPointer){
        	leftChar = lowerCaseS.charAt(leftPointer);
        	rightChar = lowerCaseS.charAt(rightPointer);
        	if((leftChar<'a' || leftChar>'z') && (leftChar<'0' || leftChar>'9')){
        		leftPointer++;
        		continue;
        	}
        	if((rightChar<'a' || rightChar>'z') && (rightChar<'0' || rightChar>'9')){
        		rightPointer--;
        		continue;
        	}
        	if(leftChar!=rightChar){
        		return false;
        	}
        	leftPointer++;
        	rightPointer--;
        }
        
		return true;
    }
}
