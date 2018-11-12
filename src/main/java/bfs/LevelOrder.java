package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 描述: Breadth First Search 广度优先搜索
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
 *      按照层次来依次遍历树
 *
 *      使用一个队列来保存每一层的节点(先将root节点放进去,再依次遍历其它节点)
 *      循环队列来遍历{
 *          声明一个列表来保存当前层并将当前层的左右子节点保存到队列里面去
 *      }
 *
 *
 * 2018-11-12
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            //保存输出结果的集合
            List<Integer> list = new ArrayList<>();

            //当前层保存的节点数
            int currentLevelNodesNum = queue.size();

            //遍历队列里面的节点
            for (int i = 0; i < currentLevelNodesNum; i++) {
                //获取当前层的节点并保存其值
                TreeNode node = queue.poll();
                list.add(node.val);

                //添加其左右子节点
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }

            result.add(list);

        }
        return result;
    }
}
