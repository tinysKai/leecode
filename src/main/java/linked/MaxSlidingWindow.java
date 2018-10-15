package linked;

import java.util.LinkedList;

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
 *          优先级队列堆顶保持最大值
 *          时间复杂度 : O(N * logK)
 *
 *        2.使用大小为K的双向队列,队列的左节点一直维持着窗口内的最大值
 *          时间复杂度 : O(N) //只是在队列两端进行操作,单次操作的时间复杂度为O(1)
 *
 * 此类使用双向队列来解决这个问题
 *
 * 2018-10-15
 */
public class MaxSlidingWindow {
    private static LinkedList<Integer> deque = new LinkedList();


    public static  void maxSlidingWindow(int[] nums, int k) {
        if(nums==null || k>nums.length || k<0) return;
        if(k==0 || nums.length==0) return;

        for (int num : nums) {
            if (deque.size() == 0){
                deque.addFirst(num);
            }else{
                //每当元素个数等于3时进行删除最左元素
                if (deque.size() == 3){
                    deque.removeLast();
                }
                //删除此前的未满足旧元素
                while(deque.peekLast()!= null && deque.peekLast() < num){
                    deque.removeLast();
                }
                //添加新元素
                deque.addFirst(num);
            }
            System.out.println(deque.getLast());
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(nums,3);
    }
}
