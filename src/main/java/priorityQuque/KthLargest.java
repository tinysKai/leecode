package priorityQuque;

import java.util.PriorityQueue;

/**
 * 描述:  给定一组数,求其第K大的元素
 *
 * https://leetcode.com/problems/kth-largest-element-in-a-stream
 *
 * 比如,K=3时,一组数为{6,8,9,7,1,5},给出其中第三大的数应该为7
 *
 * 思路 :
 *          方式1 :
 *              I.保存一个大小为K的列表并维持有序,每次有元素时判断其最小的一个元素是否比其大,
 *                  若新增的元素比第K大元素大,则入列表,并删除原有第K大元素,最终再排序
 *                  时间复杂度为 : N * (k.logK)
 *
 *          方式2 :
 *              I.创建一个大小为K的优先级队列,并维持最小值在堆顶.
 *                  每次新元素进来时判断其与最小值的大小
 *                  时间复杂度为 : N * logK
 *
 * 2018-10-15
 */
public class KthLargest {
    //定义返回第三大元素
    private static int K = 3;

    private static PriorityQueue<Integer> queue = new PriorityQueue<Integer>();


    /**
     * 每次添加时返回当前第K大的元素
     * @param val
     * @return
     */
    public static  Integer add(int val){
        if (queue.size() < K){
            queue.add(val);
        }else{
            int minVal = queue.peek();
            if(minVal < val){
                queue.remove(minVal);
                queue.add(val);
            }
        }

        //判断列表个数大于3才返回
        if (queue.size() >= K){
            return queue.peek();
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        int[] array = {3,8,9,4,2,3,1,7,6,5};
        for (int i : array) {
            System.out.println(add(i));
        }
    }
}
