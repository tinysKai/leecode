package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述: 计算一个三角形,求其从顶端到末端值的最小值
 *
 * https://leetcode.com/problems/triangle/
 *
 * Given a triangle, find the minimum path sum from top to bottom.
   Each step you may move to adjacent numbers on the row below.
   For example, given the following triangle
     [
         [2],
         [3,4],
         [6,5,7],
         [4,1,8,3]
     ]

  The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 思路 :
    动态规划
    https://leetcode.com/problems/triangle/discuss/38730/DP-Solution-for-Triangle

    从三角形末端开始计算 ,
    最底层的最优解为其自己,
        minpath[k][i] =  triangle[k][i];
    依次往上层迭代,则新的一层的每个节点对应最小路径该节点下层的左右两个节点的最小节点加上其自身
         minpath[k][i] = min( minpath[k+1][i], minpath[k+1][i+1]) + triangle[k][i];

    当然,由于当遍历到K层,其上一层K+1层的数据已无用,故可声明一个一维数组即可
        minpath[i] = min( minpath[i], minpath[i+1]) + triangle[k][i];

 * 2018-11-25
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        //首先声明最下一层的最短路径,也就是对应其自己
        int[] mini = new int[triangle.get(length-1).size()];
        for (int i = 0; i < triangle.get(length-1).size(); i++) {
            mini[i] = triangle.get(length-1).get(i);
        }

        //从倒数第二层开始,也就是(triangle.size() - 2)数组下标开始
        for (int i = length-2; i >= 0; i--){
            //遍历每一层的每一个元素
            for (int j = 0; j < triangle.get(i).size(); j++) {
                //当前行的最小路径值为其自身加上其下层左右相邻元素
                mini[j] = Math.min(mini[j],mini[j+1]) + triangle.get(i).get(j);
            }
        }
        return mini[0];
    }


    /**
     * https://leetcode.com/problems/triangle/discuss/38724/7-lines-neat-Java-Solution
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        //声明一个mini数组,值全为0,大小为最底层数字数加1
        int[] mini = new int[triangle.size()+1];
        //从倒数最后一层开始,这里的灵活处理是可以加上下一层的0,使得最后一层的数字无需自声明
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                mini[j] = Math.min(mini[j],mini[j+1])+triangle.get(i).get(j);
            }
        }
        return mini[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);

        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        System.out.println(new Triangle().minimumTotal2(triangle));
    }

}
