package easy;

// https://leetcode.com/problems/factorial-trailing-zeroes/

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 Given an integer n, return the number of trailing zeroes in n!.
 Follow up: Could you write a solution that works in logarithmic time complexity?

 수학에서, 자연수의 계승 또는 팩토리얼(階乘, 문화어: 차례곱, 영어: factorial)은 그 수보다 작거나 같은 모든 양의 정수의 곱이다.
 n이 하나의 자연수일 때, 1에서 n까지의 모든 자연수의 곱을 n에 상대하여 이르는 말이다.
 기호는 !을 쓰며 팩토리얼이라고 읽는다.
 공식적이지는 않지만 팩토리얼을 줄여서 팩이라고 읽기도 한다.

 이번 문제는 주어진 숫자 n에 대해서 n!(팩토리얼)의 trailing zeroes가 몇개인지를 구하는 문제입니다.
 Trailing zeroes란 예를 들면 56000이면 trailing zeroes의 수는 3개이고, 44400이면 2개입니다.

 Example 1:
     Input: n = 3
     Output: 0
     Explanation: 3! = 6, no trailing zero.
 Example 2:
     Input: n = 5
     Output: 1
     Explanation: 5! = 120, one trailing zero.
 Example 3:
     Input: n = 0
     Output: 0

 Constraints:
     0 <= n <= 10^4
 */
public class E172_FactorialTrailingZeroes {
    // factorial 변수 MAX_VALUE 제한에 따라 정상 결과가 나오지 않을 수 있음.
    public int trailingZeroes_(int n) {
        int output = 0;
        long factorial = 1;
        for (int i=1; i<=n; i++) {
            factorial = factorial * i;
        }

        while(factorial > 1) {
            if (factorial % 10 == 0)
                output++;
            else
                return output;

            factorial /= 10;
        }
        return output;
    }

    public int trailingZeroes(int n) {
        int output = 0;

        while(n / 5 > 0) {
            output += n / 5;
            n /= 5;
        }

        return output;
    }

    // Solution 1
    //  ref : https://smlee729.wordpress.com/2018/03/26/algorithm-%EB%AC%B8%EC%A0%9C-factorial-trailing-zeroes/
    public int trailingZeroes_sol(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes_sol(n / 5);
    }
    @Test
    public void test() {
        E172_FactorialTrailingZeroes test = new E172_FactorialTrailingZeroes();

        assertThat(test.trailingZeroes(3), equalTo(0));

        assertThat(test.trailingZeroes(5), equalTo(1));

        assertThat(test.trailingZeroes(0), equalTo(0));

        // factorial 계산 변수(int) 자리수로 인해 결과 오류
        assertThat(test.trailingZeroes(13), equalTo(2));

        assertThat(test.trailingZeroes(7), equalTo(1));

        // factorial 계산 변수(long) 자리수로 인해 결과 오류
        assertThat(test.trailingZeroes(30), equalTo(7));

        assertThat(test.trailingZeroes(50), equalTo(12));

        assertThat(test.trailingZeroes(75), equalTo(18));

        assertThat(test.trailingZeroes(200), equalTo(49));

    }
}

