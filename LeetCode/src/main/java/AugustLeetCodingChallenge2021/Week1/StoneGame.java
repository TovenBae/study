package AugustLeetCodingChallenge2021.Week1;

// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3870/

//Alex and Lee play a game with piles of stones.
// There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
//        The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.
//        Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.
//        This continues until there are no more piles left, at which point the person with the most stones wins.
//        Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
//
//        Example 1:
//
//        Input: piles = [5,3,4,5]
//        Output: true
//        Explanation:
//        Alex starts first, and can only take the first 5 or the last 5.
//        Say he takes the first 5, so that the row becomes [3, 4, 5].
//        If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
//        If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
//        This demonstrated that taking the first 5 was a winning move for Alex, so we return true.
//
//
//        Constraints:
//
//        2 <= piles.length <= 500
//        piles.length is even.
//        1 <= piles[i] <= 500
//        sum(piles) is odd.

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int sumAlex = 0;
        int sumLee = 0;
        return helper(piles, sumAlex, sumLee, 0, true)
                || helper(piles, sumAlex, sumLee, piles.length-1, false);
    }

    public boolean helper(int [] piles, int sumAlex, int sumLee, int pos, boolean isFront) {
        sumAlex += piles[pos];
        if (isFront) {
            sumLee += piles[piles.length - pos - 1];
        } else {
            sumLee += piles[piles.length - pos + 1];
        }
        if (pos * 2 == piles.length || pos * 2 + 2 == piles.length) {
            if (sumAlex > sumLee)
                return true;
            else
                return false;
        }
        if (!isFront) {
            pos = piles.length - pos + 1;
        }
        return helper(piles, sumAlex, sumLee, pos+1, true)
                || helper(piles, sumAlex, sumLee, piles.length-pos-2, false);
    }

    @Test
    public void test() {
        StoneGame test = new StoneGame();

        assertThat(test.stoneGame(new int[]{5,3,4,5}), equalTo(true));
    }
}
