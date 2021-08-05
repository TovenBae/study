package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/palindrome-number/

// Given an integer x, return true if x is palindrome integer.
// An integer is a palindrome when it reads the same backward as forward.
// For example, 121 is palindrome while 123 is not.
//
//    Example 1:
//        Input: x = 121
//        Output: true
//    Example 2:
//        Input: x = -121
//        Output: false
//        Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
//        Therefore it is not a palindrome.
//    Example 3:
//        Input: x = 10
//        Output: false
//        Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
//    Example 4:
//        Input: x = -101
//        Output: false
//
//    Constraints:
//        -2E31 <= x <= 2E31 - 1
//
//    Follow up: Could you solve it without converting the integer to a string?

public class PalindromeNumber {
    public boolean isPalindrome_(int x) {
        if (x < 0) return false;

        String sx = "" + x;
        for (int i=0; i<sx.length()/2; ++i) {
            if (sx.charAt(i) != sx.charAt(sx.length()-i-1))
                return false;
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        boolean rev = false;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
//            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
//            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
//            rev = rev * 10 + pop;
        }
        return rev;
    }

    public boolean isPalindrome3(int x) {
        if(x<0) return false;
        int rev=0;
        int rem;
        int orig=x;
        while(x!=0){
            rem=x%10;
            rev= rev*10 + rem;
            x /=10;
        }
        return orig==rev;
    }

    public boolean isPalindrome(int x) {
        // 변수 x -> 양의 값만
        int absNum = Math.abs(x);
        // 최종 결과 값
        int resultNum = 0;
        // 자리수
        int divNum = 10;
        // 숫자 담는 array
        int [] arrX = new int [10] ;
        // 자리수 별 숫자 추출 (범위 -> 10자리)
        for(int i =0; i<10; i++){
            // 나머지 값으로 자리수 추출
            int num = absNum % divNum;
            // 양의변수에서 다음 자리수 추출을 위한 나머지 제거
            absNum = absNum - num;
            if (divNum > 10){
                // ex) 1000의 자리 -> 2000 -> 2000/1000 = 2
                num = num/(divNum/10);
            }
            // 배열에 추출 숫자 넣기
            arrX[i] = num;
            // 모든 자리수 추출 -> break
            if (absNum == 0) {
                break;
            }
            // 다음 자리수를 위해
            divNum *= 10;
        }
        // 반대 숫자 구하기
        for (int i = 0; i<10; i++){
            // 위에서 나머지로 추출해서 한자리가 크게 셋팅되어있어 /10을 한다
            divNum = divNum/10;
            int reverseNum = arrX[i] * divNum;
            resultNum += reverseNum;
        }
        return resultNum == x;
    }

    @Test
    public void test() {
        PalindromeNumber pn = new PalindromeNumber();
        int x = 121;
        boolean Output = true;
        assertEquals(Output, pn.isPalindrome(x));

        x = 12345;
        Output = false;
        assertEquals(Output, pn.isPalindrome(x));

        x = -121;
        Output = false;
        assertEquals(Output, pn.isPalindrome(x));

        x = 10;
        Output = false;
        assertEquals(Output, pn.isPalindrome(x));

        x = -101;
        Output = false;
        assertEquals(Output, pn.isPalindrome(x));

    }

    @Test
    public void test3() {
        PalindromeNumber pn = new PalindromeNumber();
        int x = 121;
        boolean Output = true;
        assertEquals(Output, pn.isPalindrome3(x));

        x = 12345;
        Output = false;
        assertEquals(Output, pn.isPalindrome3(x));


        x = -121;
        Output = false;
        assertEquals(Output, pn.isPalindrome3(x));

        x = 10;
        Output = false;
        assertEquals(Output, pn.isPalindrome3(x));

        x = -101;
        Output = false;
        assertEquals(Output, pn.isPalindrome3(x));

    }
}
