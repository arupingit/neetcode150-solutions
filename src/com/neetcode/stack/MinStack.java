package com.neetcode.stack;

import java.util.Stack;

/**
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/
 * 
 * @author arupdutta
 */
public class MinStack {
	
	private Stack<Integer> minStack;
	private Stack<Integer> mainStack;

	public static void main(String[] args) {
		MinStack s = new MinStack();
		s.push(-2);
		s.push(0);
		s.push(-3);
		System.out.println(s.getMin());
		s.pop();
		System.out.println(s.top());
		System.out.println(s.getMin());
	}
	
	public MinStack() {
		minStack = new Stack<>();
		mainStack = new Stack<>();
    }
    
    public void push(int val) {
        this.mainStack.add(val);
        if(this.minStack.size()==0){
        	this.minStack.add(val);
        } else {
        	if(this.minStack.peek()>val){
        		this.minStack.add(val);
        	} else {
        		this.minStack.add(this.minStack.peek());
        	}
        }
    }
    
    public void pop() {
        this.mainStack.pop();
        this.minStack.pop();
    }
    
    public int top() {
        return this.mainStack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }

}
