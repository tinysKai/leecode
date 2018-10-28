package bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 描述: 判断一颗树是否是二叉搜索树
 *
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Example 1:

         Input:
         2
         / \
         1   3
         Output: true
         Example 2:

         5
         / \
        1   4
            / \
           3   6
         Output: false
         Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
         is 5 but its right child's value is 4.


    思路 : 中序遍历这棵树
             中序遍历顺序 : 左子树,根节点,右子树
 * 2018-10-28
 */
public class ValidBst {

    /**
     * 判断是否是二叉搜索树
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    /**
     * 使用堆栈中序遍历二叉搜索树
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }


    /**
     * 寻找二叉搜索树第几大的数
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0) break;
            root = root.right;
        }
        return root.val;
    }


}
