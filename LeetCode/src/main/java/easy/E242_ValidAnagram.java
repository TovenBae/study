package easy;

// https://leetcode.com/problems/valid-anagram/

//Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//
//        Example 1:
//
//        Input: s = "anagram", t = "nagaram"
//        Output: true
//        Example 2:
//
//        Input: s = "rat", t = "car"
//        Output: false
//
//
//        Constraints:
//
//        1 <= s.length, t.length <= 5 * 10 4
//        s and t consist of lowercase English letters.
//
//
//        Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class E242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        else if (s.length() < t.length()) return false;

        // String function
//        return s.contains(t);

        // contains logic 구현
        char [] c = t.toCharArray();
        int pos = 0;
        int oPos = 0;
        for (int i=0; i<c.length; i++) {
            pos = s.indexOf(c[i], pos);
            if (pos < 0) return false;
            else if (i > 0 && pos != oPos+1) {
                i = -1;
                pos = oPos+1;
            } else {
                oPos = pos;
            }
        }
        return true;
    }

    public boolean isAnagram_nuree(String s, String t) {
        List<String> input1 = new ArrayList<String>();
        List<String> input2 = new ArrayList<String>();
        if(!(s.length()==t.length())){ 			//첫번째 케이스 글자수가 같지 않으면 바로 실패
            return false;
        }else {
            if(s.length()==0 || t.length()==0){ //문제의 조건은 문자열의 크기는 1 이상이지만.. 글자가 없을때 ex) ""
                return false;
            }else {										//문자열의 크기가 같을 때
                for(int i=0; i<s.length(); i++) {		//ArrayList에 각각 값을 담아주고
                    input1.add(i,s.substring(i,i+1));
                    input2.add(i,t.substring(i,i+1));
                }
                Collections.sort(input1);				//정렬해서 두개 비교
                Collections.sort(input2);
                return Arrays.equals(input1.toArray(), input2.toArray());
            }
        }
    }

    @Test
    public void isAnagramTest() {
        String s = "anagram";
        String t = "nagram";
        Boolean output = true;

        assertEquals(output, isAnagram(s, t));

        s = "rat";
        t = "car";
        output = false;

        assertEquals(output, isAnagram(s, t));

        s = "ratrcainre";
        t = "re";
        output = true;

        assertEquals(output, isAnagram(s, t));

    }

    @Test
    public void isAnagram_nureeTest() {
        String s = "anagram";
        String t = "nagram";
        Boolean output = true;

        assertEquals(output, isAnagram_nuree(s, t));

        s = "rat";
        t = "car";
        output = false;

        assertEquals(output, isAnagram_nuree(s, t));

        s = "ratrcainre";
        t = "re";
        output = true;

        assertEquals(output, isAnagram_nuree(s, t));

    }
}
