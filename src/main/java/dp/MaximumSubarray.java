package dp;

/**
 * 描述: 求一个数组的最大子数组的乘积
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
     Example 1:
         Input: [2,3,-2,4]
         Output: 6
         Explanation: [2,3] has the largest product 6.
     Example 2:
         Input: [-2,0,-1]
         Output: 0
         Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


 * 思路 :
 *      声明两个变量,一个来保存最大值,一个保存最小值
 *
 *      https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity
 *
 * 2018-11-25
 */
public class MaximumSubarray {
    public int maxProduct(int[] nums) {
        //返回最大值先假设是
        int result = nums[0];
        for (int i = 1,min =result,max = result; i < nums.length; i++) {
            //负数的话交换最大值与最小值
            if (nums[i] < 0){
                int temp = min;
                min = max;
                max = temp;
            }

            //max值永远是正的,max取值为当前值或当前值与max的乘积
            max = Math.max(nums[i],max * nums[i]);
            //min值作用主要体现在有负数时保存当前负数的结果
            min = Math.min(nums[i],min * nums[i]);

            result = Math.max(result,max);
        }
        return result;
    }
}
