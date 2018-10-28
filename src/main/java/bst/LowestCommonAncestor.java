package bst;

/**
 * 描述: 寻找二叉树(无序)的最近公共祖先
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

         _______3______
         /              \
         ___5__          ___1__
         /      \        /      \
         6      _2       0       8
         /  \
         7   4
         Example 1:

         Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
         Output: 3
         Explanation: The LCA of of nodes 5 and 1 is 3.
         Example 2:

         Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
         Output: 5
 *
 *
 * 思路 :
 *        使用递归的方式.
 *        如果两个值分别位于root节点的两边,则返回root
 *        如果两个值都位于root的左边,则使用root.left当做root节点再查找
 *        如果两个值都位于root的右边,则使用root,right当做root节点再查找
 * 2018-10-28
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //空节点返回null
        if (root == null){
            return null;
        }
        //查找得到返回值
        if (root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        //左子树不存在说明两个节点都在右子树
        if (left == null){
          return right;
        }
        //右子树不存在说明两个节点都在左子树
        if (right == null){
            return left;
        }

        //左右子树都存在说明就是当前节点是最早祖先
        return  root;

    }

}
