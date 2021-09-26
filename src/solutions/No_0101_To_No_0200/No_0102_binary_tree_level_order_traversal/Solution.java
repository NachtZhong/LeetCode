package solutions.No_0101_To_No_0200.No_0102_binary_tree_level_order_traversal;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 二叉树层级遍历, 利用队列辅助进行遍历
 * 1. 根节点入队
 * 2. 出队所有当前队列元素
 * 3. 获取当前队列元素的值, 加入一个列表, 并把该列表加入结果集
 * 4. 遍历当前队列元素, 按顺序将各个元素的左节点和右节点入队
 * 5. 循环2-4, 直至队列为空
 * 6. 返回结果集
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return list;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> layerList = new ArrayList<>();
            List<TreeNode> currentNodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                currentNodeList.add(queue.poll());
            }
            currentNodeList.forEach(node -> {
                layerList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            });
            list.add(layerList);
        }
        return list;
    }
}
