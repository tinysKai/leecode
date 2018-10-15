package priorityQuque;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 描述: 给定一组数,求滑动窗口为K内的最大值
 *
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * Example:
         Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
         Output: [3,3,5,5,6,7]
 *
 * 思路 :
 *        1.使用优先级队列,维护窗口大小为K的堆,MaxHeap
 *          优先级队列堆顶保持最大值,删除操作依赖于给定的原数组,依次删除
 *          时间复杂度 : O(N * logK)
 *
 *        2.使用大小为K的双向队列,队列的左节点一直维持着窗口内的最大值
 *          时间复杂度 : O(N)
 *
 * 此类先使用优先队列来解决这个问题
 *
 * 2018-10-15
 */
public class MaxSlidingWindow {
    private static PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 > o2 ? -1:(o1 == o2 ? 0 : 1));




    public static  int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];

        //声明一个返回数组
        int[] result = new int[nums.length - k + 1];

        //先将窗口填满
        for(int i = 0; i < k; i ++){
            queue.add(nums[i]);
        }
        //返回填满的第一个最大值
        result[0] = queue.peek();

        //窗口移动
        for(int i = k; i < nums.length; i ++){
            queue.remove(nums[i - k]); //nums[i - k],依次删除窗口外的数据
            queue.add(nums[i]);        //添加新添加的元素
            result[i - k + 1] = queue.peek();   //设置新的最大值
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums,3)));
    }
}
