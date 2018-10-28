package set;

import java.util.*;
import java.util.logging.Level;

/**
 * 描述: 给定一组数,求是否其中任意三个数相加能等于0,不能出现重复解
 *
 * https://leetcode.com/problems/3sum/description/
 *
 *  Example:

         Given array nums = [-1, 0, 1, 2, -1, -4,-1],

         A solution set is:
         [
         [-1, 0, 1],
         [-1, -1, 2]
         ]
 *
 *
 * 思路 :
 *      1.先排序,再查找
 *          排序完遍历
 *              左指针指向剩余数组第一个,右指针指向右边最右一个..
 *              依次将遍历数 + 左指针数 + 右指针数相加
 *
 *              相等  , 是一组解,
 *              大于0 , 右指针向左移
 *              小于0,左指针向右移
 *
 *
 *
 * 2018-10-27
 */
public class SumOfThreeNums {
    public static  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resutl = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            int start = i + 1;                  //左指针
            int end  = nums.length - 1;         //右指针
            if (i > 0 && nums[i] != nums[i-1]){ //过滤重复解
                continue;
            }
            while (start < end ){
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0){
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    resutl.add(list);
                    break;
                }else if (sum > 0){
                    end = end - 1;
                }else if (sum < 0){
                    start = start + 1;
                }
            }
            }
        return resutl;
    }

    public static void main(String[] args) {
        int[] arrays = {-1, 0, 1, 2, -1, -4,-1};
        System.out.print(threeSum(arrays));

    }
}
