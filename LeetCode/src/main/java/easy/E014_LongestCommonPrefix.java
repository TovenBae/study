package easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

// https://leetcode.com/problems/longest-common-prefix/

// Write a function to find the longest common prefix string amongst an array of strings.
//If there is no common prefix, return an empty string "".
public class E014_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String rtn = "";

        int i= 0;
        boolean matched = true;
        try {
            while(true) {
                char ch = 0;
                for (int j=0; j < strs.length; j++) {
                    if (j == 0) {
                        ch = strs[j].charAt(i);
                    } else {
                        if (ch != strs[j].charAt(i)) {
                            return rtn;
                        }
                    }
                }
                rtn += ch;
                i++;
            }
        } catch (Exception e) {
            return rtn;
        }
    }

    // Approach 1: Horizontal scanning
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    // Approach 2: Vertical scanning
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    // Approach 3: Divide and conquer
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return getCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String getCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   getCommonPrefix(strs, l , mid);
            String lcpRight =  getCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    // Approach 4: Binary search
    public String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }



    public String longestCommonPrefix_nuri(String[] strs) {
        String result = "";
        Arrays.sort(strs, new Comparator<String>() {  //빠른 문자열 분석을 위해 입력된 문자 배열의 길이별 오름차순으로 정렬
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        String input = strs[0];
        ArrayList<String> split_str = new ArrayList<String>();
        for(int i=0; i<input.length(); i++) {         //제일 짧은 길이의 문자열을 나눌 수 있는 최소한의 단위로 나누어 ArrayList에 저장
            for(int j=i+1; j<input.length()+1; j++) {
                split_str.add(input.substring(i,j));
            }
        }
        for(int i=0; i<split_str.size(); i++) {       //최초 입력된 단어 배열들과 분석된 ArrayList와 비교
            int result_count=0;                         //입력된 단어 개수와 포함되어 있는 부분 문자열의 갯수가 같으면 정답
            for(int j=0; j<strs.length; j++) {          //최초 입력된 단어 배열들과 분석된 부분 문자열 비교
                if(strs[j].contains(split_str.get(i))) {  //최초 입력된 단어 안에 분석된 부분 문자열이 있다면 result_count 더해준다.
                    result_count=result_count+1;
                }else{                                    //한개라도 포함되어 있지 않다면 바로 다음 단계로
                    break;
                }
                if(result_count==strs.length) {           //분석된 부분 문자열 중 1개를 포함할 수도 있고, 그 이상의 경우의 수도 있으니 해당 부분 처리
                    if(result.length()<=split_str.get(i).length()) {
                        result = split_str.get(i);
                    }
                }
            }
        }
        return result;
    }

    public String longestCommonPrefix_sk (String[] strs) {
        // 리턴 값
        String returnStr = "";
        // 첫번째 단어 분할
        for (int i=0; i<strs[0].length(); i++) {
            // 1~ 알파벳 조합
            for (int j=i+1; j<=strs[0].length();j++){
                boolean flag2 = false;

                String prefix = strs[0].substring(i,j);
                // 전체 단어들 contain 검사
                for(int k = 0; k<strs.length; k++){
                    // 포함x => 다음 알파벳
                    if (!strs[k].contains(prefix)){
                        // 다음 알파벳
                        flag2 = true;
                        break;
                    } else {
                        // 마지막 단어까지 포함 되있을 경우 returnStr로 지정
                        if(k == strs.length-1){
                            returnStr = prefix.length() > returnStr.length() ? prefix : returnStr;
                        }
                    }
                }
                if(flag2){
                    break;
                }
            }
        }
        return returnStr;
    }

    @Test
    public void test() {
        E014_LongestCommonPrefix test = new E014_LongestCommonPrefix();
        String [] strs = {"flower", "flow", "flight"};
        String Output = "fl";
        assertEquals(Output, test.longestCommonPrefix(strs));

        strs = new String[] {"dog", "racecar", "car"};
        Output = "";
        assertEquals(Output, test.longestCommonPrefix(strs));

    }

    @Test
    public void test1() {
        E014_LongestCommonPrefix test = new E014_LongestCommonPrefix();
        String [] strs = {"flower", "flow", "flight"};
        String Output = "fl";
        assertEquals(Output, test.longestCommonPrefix_nuri(strs));

        strs = new String[] {"dog", "racecar", "car"};
        Output = "";
        assertEquals(Output, test.longestCommonPrefix_nuri(strs));

    }
}
