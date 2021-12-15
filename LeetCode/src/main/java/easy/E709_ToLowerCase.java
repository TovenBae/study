package easy;

// https://leetcode.com/problems/to-lower-case/

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
//   Example 1:
//        Input: s = "Hello"
//        Output: "hello"
//   Example 2:
//        Input: s = "here"
//        Output: "here"
//   Example 3:
//        Input: s = "LOVELY"
//        Output: "lovely"
//   Constraints:
//        1 <= s.length <= 100
//        s consists of printable ASCII characters.
public class E709_ToLowerCase {
    public String toLowerCase(String s) {
        if (s == null)  return "";

        String rtn = "";
        char [] arrRtn = s.toCharArray();
        for (char c : arrRtn) {
            if (c >= 65 && c <= 90) {
                c = (char) (c + 32);
            }
            rtn = rtn + Character.toString(c);
        }

        return rtn;
    }

    public String nuree(String s) {
//        Scanner Scanner = new Scanner(System.in);                    //문자열 입력 받아서
        String input_str = s;                        //입력 받은 문자열을 변수에 할당해주고
        char[] char_arr = input_str.toCharArray();                    //문자열을 Char형태의 배열로 변환
        String result = "";
        for(int i=0; i<char_arr.length; ++i){
            if(65<=char_arr[i] && char_arr[i]<=90){                    //문자열의 아스키코드의 값이 65~90의 알파벳 대문자라면
                char_arr[i]=(char)(char_arr[i]+32);                    //32를 더해 소문자로 변환
            result = result+Character.toString(char_arr[i]);    //결과를 담아준다
            }
        }
        System.out.println(result);
        return result;
    }

    @Test
    public void testToLowerCase() {
        String s = "Hello";
        String output = "hello";
        assertEquals(output, toLowerCase(s));
        assertEquals(output, nuree(s));

        s = "here";
        output = "here";
        assertEquals(output, toLowerCase(s));
        assertEquals(output, nuree(s));

        s = "LOVELY";
        output = "lovely";
        assertEquals(output, toLowerCase(s));
        assertEquals(output, nuree(s));
    }
}
