package dp;

/**
 * 描述: 从底层爬楼梯到楼梯顶端,每次只能爬1格或者2格.求爬到顶端的方式次数
 *
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 *      You are climbing a stair case. It takes n steps to reach to the top.

         Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

         Note: Given n will be a positive integer.

         Example 1:

         Input: 2
         Output: 2
         Explanation: There are two ways to climb to the top.
         1. 1 step + 1 step
         2. 2 steps

 *
 * 思路:
 *    动态规划
 *
 *    动态方程为 : f(n) = f(n-1) + f(n-2)
 *
 *
 * 2018-11-25
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if(n <= 2) return n;

        //声明一个数组来保存前面的计算值,当然这里可以只使用三个变量来保存,空间复杂度可以为O(1)
        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;

        for (int i = 2; i < n; i++) {
            mem[i] = mem[i-1] + mem[i-2];
        }

        return mem[n-1];
    }
}
