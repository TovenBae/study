package easy;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// https://leetcode.com/problems/two-sum/

//  Given an array of integers nums and an integer target,
//  return indices of the two numbers such that they add up to target.
//  You may assume that each input would have exactly one solution, and you may not use the same element twice.
//  You can return the answer in any order.

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int [] rtn = {0, 0};

        for (int i=0; i<nums.length; i++) {
            int b = target - nums[i];
            for (int j=(i+1); j<nums.length; j++) {
                if (b == nums[j]) {
                    return new int[] {i, j};
                }
            }
        }
        return rtn;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum_sk(int[] nums, int target) {
        int [] rtn = {0, 0};
        System.out.println((target%2));
// TODO, implimentation logic
        // array to arrayList
        ArrayList<Integer> numsList = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
        // 짝수면 /2, 홀수면 /2 +  1
        int target_for = (target%2) == 1 ? (target/2) + 1 : (target/2);
        for (int i = 1; i <= target_for ; i++) {
            int a = i;
            int b = target - i;
            int a_index = 0;
            int b_index = 0;
            if(numsList.contains(i)) {
                a_index = numsList.indexOf(i);
                if (i != b) {
                    if ( numsList.contains(b)) {
                        b_index = numsList.indexOf(b);
                    }
                } else {
                    // 비교 숫자가 같을떼
                    // 해당 숫자 갯수 확인
                    int sameSize = numsList.stream() .filter(d -> d == a) .collect(Collectors.toList()).size();
                    if (sameSize < 2) {
                        // 2개미만이면 다음으로
                        continue;
                    } else {
                        // 2개 이상이면 2번째  index
                        for(int j = a_index + 1; j < numsList.size(); j++) {
                            if (numsList.get(j) == i) {
                                b_index = j;
                                break;
                            }
                        }
                    }
                }
                // index 순서
                rtn[0] = a_index > b_index ? b_index : a_index;
                rtn[1] = a_index > b_index ? a_index : b_index;
                break;
            }
        }
        return rtn;
    }

    @Test
    public void testTowSum() {
        TwoSum ts = new TwoSum();
        int [] nums = {2,7,11,15};
        int target = 9;
        int [] output = {0,1};
        assertArrayEquals(output, ts.twoSum(nums, target));
//        assertEquals(output, ts.twoSum(nums, target));

        nums = new int[]{3, 2, 4};
        target = 6;
        output = new int[]{1,2};
        assertArrayEquals(output, ts.twoSum(nums, target));

        nums = new int[]{3, 3};
        target = 6;
        output = new int[] {0,1};
        assertArrayEquals(output, ts.twoSum(nums, target));
    }

    @Test
    public void testTowSum_sk() {
        TwoSum ts = new TwoSum();
        int [] nums = {2,7,11,15};
        int target = 9;
        int [] output = {0,1};
        assertArrayEquals(output, ts.twoSum_sk(nums, target));
//        assertEquals(output, ts.twoSum(nums, target));

        nums = new int[]{3, 2, 4};
        target = 6;
        output = new int[]{1,2};
        assertArrayEquals(output, ts.twoSum_sk(nums, target));

        nums = new int[]{3, 3};
        target = 6;
        output = new int[] {0,1};
        assertArrayEquals(output, ts.twoSum_sk(nums, target));
    }

}
