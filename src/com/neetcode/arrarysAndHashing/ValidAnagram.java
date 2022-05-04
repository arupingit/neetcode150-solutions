package com.neetcode.arrarysAndHashing;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 * 
 * @author arupdutta
 *
 */
public class ValidAnagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("rat", "car"));
		
		System.out.println(isAnagramWithoutExtraSpace("anagram", "nagaram"));
		System.out.println(isAnagramWithoutExtraSpace("rat", "car"));
	}

	public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
        	return false;
        }
        if(s.equals(t)){
        	return true;
        }
        Hashtable<Character,Integer> alphabetTable = new Hashtable<>();
        for(int i=0;i<s.length();i++){
        	int temp =0;
        	if(alphabetTable.containsKey(s.charAt(i))){
        		temp = alphabetTable.get(s.charAt(i));
        	}
        	alphabetTable.put(s.charAt(i), ++temp);
        }
        for(int i=0;i<t.length();i++){
        	if(!alphabetTable.containsKey(t.charAt(i))){
        		return false;
        	}
        	int temp = alphabetTable.get(t.charAt(i)) - 1;
        	alphabetTable.put(t.charAt(i), temp);
        	if(temp<0){
        		return false;
        	}
        }
        return true;
    }
	
	public static boolean isAnagramWithoutExtraSpace(String s, String t) {
		if(s.length()!=t.length()){
        	return false;
        }
        if(s.equals(t)){
        	return true;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        
        for(int i=0; i<sChar.length; i++){
        	if(sChar[i]!=tChar[i]){
        		return false;
        	}
        }
        return true;
	}
}
