package bfs;

/**
 * 描述: 求一颗二叉树的最小深度
 *
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 *
 *
 * 使用递归的方式
 *
 * 思路 :
 *      递归
 *      分而治之的思想
 *      分别计算左右子树的最小值
 *
 * 2018-11-14
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if (leftDepth == 0 || rightDepth == 0){
            //说明至少一边树为空,注意这里的子树空的处理
            return  leftDepth + rightDepth + 1;
        }else{
            //左右子树都存在,求其最小的一边
            return 1 + Math.min(leftDepth,rightDepth);
        }
    }
}
