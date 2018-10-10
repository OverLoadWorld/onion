package com.nearu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int lengthOfLongestSubstringT(String s) {//Runtime: 48 ms, faster than 39.53%
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<Character>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }

    public static int lengthOfLongestSubstringNowRobust(String s) {//55 ms, faster than 29.96%
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
                //j = map.get(s.charAt(i))+1;  ex: abba
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {//Runtime: 75 ms, faster than 19.42%
        if (s.length() >= 0 && s.length() <= 1) {
            return s.length();
        }
        Set<Character> set = new HashSet<Character>();
        int maxSubStrNum = 0;
        int startIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                if(i == s.length() - 1){
                    return Math.max(maxSubStrNum, i - startIdx + 1);
                }
            } else {
                maxSubStrNum = Math.max(maxSubStrNum, i - startIdx);
                i = ++startIdx;
                set.clear();
                set.add(s.charAt(i));

            }
        }
        return maxSubStrNum;
    }

    public static int lengthOfLongestSubstringWrong(String s) {
        int maxSubStrNum = 0;
        int thisSubStrNum = 0;
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                thisSubStrNum++;
                if(i == s.length() - 1){
                    return thisSubStrNum;
                }
            } else {
                if(thisSubStrNum > maxSubStrNum){
                    maxSubStrNum = thisSubStrNum;
                }
                if(c == s.charAt(i - 1) ){
                    thisSubStrNum--;
                }
            }
        }
        return maxSubStrNum;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstringT("aaaaaaaaaaaa"));
    }

}
