package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// https://leetcode.com/problems/climbing-stairs/

// You are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//    Example 1:
//
//        Input: n = 2
//        Output: 2
//        Explanation: There are two ways to climb to the top.
//        1. 1 step + 1 step
//        2. 2 steps

//    Example 2:
//
//        Input: n = 3
//        Output: 3
//        Explanation: There are three ways to climb to the top.
//        1. 1 step + 1 step + 1 step
//        2. 1 step + 2 steps
//        3. 2 steps + 1 step
//
//    Constraints:
//
//        1 <= n <= 45

public class Climbing_Stairs {
    // n = 44 -> Time Limit Exceeded
    public int climbStairs_1(int n) {
        if (n == 1) return 1;
        int cnt = 0;
        int rem = 0;
        for (int i=1; i<=2; i++) {
            rem = n - i;
            if (rem > 1)
                cnt += climbStairs(rem);
            else
                cnt ++;
        }
        return cnt;
    }

    // 1. Brute Force
    public int climbStairs_2(int n) {
        return climb_Stairs(0, n);
    }
    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }

    // Approach 2: Recursion with Memoization
    public int climbStairs_3(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    public int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }

    // Approach 4: Fibonacci Number
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    @Test
    public void test() {
        Climbing_Stairs test = new Climbing_Stairs();

        // 2
        // 1-1
        int n = 2;
        int output = 2;
        assertEquals(output, test.climbStairs(n));

        // 2-1
        // 1-2
        // 1-1-1
        n = 3;
        output = 3;
        assertEquals(output, test.climbStairs(n));

        // 2-2
        // 2-1-1
        // 1-1-2
        // 1-1-1-1
        // 1-2-1
        n = 4;
        output = 5;
        assertEquals(output, test.climbStairs(n));

        // 2-2-1
        // 2-1-2
        // 2-1-1-1
        // 1-2-2
        // 1-2-1-1
        // 1-1-2-1
        // 1-1-1-2
        // 1-1-1-1-1
        n = 5;
        output = 8;
        assertEquals(output, test.climbStairs(n));

        n = 1;
        output = 1;
        assertEquals(output, test.climbStairs(n));

        n = 44;
        output = 1134903170;
        assertEquals(output, test.climbStairs(n));

    }
}
