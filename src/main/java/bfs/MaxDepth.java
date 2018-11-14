package bfs;

/**
 * 描述: 求一颗二叉树的最大深度
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 *
 * 使用递归的方式
 *
 * 思路 :
 *  每次比较左右子树的最大值
 *
 *  当然也可以使用广度搜索的方式来遍历
 * 2018-11-14
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        // 1代表这一层加1
        //下面的意思是 取父节点下的左子树的层数与右子树的层数的最大值,然后加1,
        //然后单独分析左子树,左子树也分别计算其左右子树的最大层数,其最大值要么是有下一层则接着递归,要么是木有则返回0
        //所以最终的结果是 1 + 2层返回的1 + 3层返回的1 + 4层返回的1 + ...
        return 1 +  Math.max(maxDepth(root.left),maxDepth(root.right));

    }
}
