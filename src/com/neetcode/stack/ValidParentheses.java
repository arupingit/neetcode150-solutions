package com.neetcode.stack;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * @author arupdutta
 *
 */
public class ValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("]"));
	}
	
	public static boolean isValid(String s) {
        Stack<Character> inputStack = new Stack<>(); 
        for(int i=0;i<s.length();i++){
        	if(
        			(s.charAt(i) == ')' && inputStack.size() != 0 && inputStack.peek() == '(') ||
        			(s.charAt(i) == '}' && inputStack.size() != 0 && inputStack.peek() == '{') ||
        			(s.charAt(i) == ']' && inputStack.size() != 0 && inputStack.peek() == '[')
        		){
        		inputStack.pop();
        	} else {
        		inputStack.push(s.charAt(i));
        	}
        }
        return inputStack.size() == 0;
    }

}
