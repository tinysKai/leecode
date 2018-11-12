package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述: Depth First Search 深度优先搜索
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * For example:
     Given binary tree [3,9,20,null,null,15,7],
     3
     / \
     9  20
     /  \
     15   7
     return its level order traversal as:
     [
     [3],
     [9,20],
     [15,7]
     ]
 *
 * 思路 :
 *        使用递归的方式
 *
 *        先根节点,再递归左子树,最后递归右子树
 *
 *
 * 2018-11-12
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);
        return res;
    }


    /**
     * 递归方法
     * 利用二维数组来保存结果
     * @param res 保存结果的结合
     * @param root 二叉树节点
     * @param height 当前层级
     */
    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;

        //若到了下一层则添加新的数组来保存这一层的数据
        if (height >= res.size()) {
            res.add(new LinkedList<>());
        }

        //获取当前层的数据集合并保存数据
        res.get(height).add(root.val);

        //开始递归,注意层数加一
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }
}
