package solutions.No_0201_To_No_0300.No_0257_binary_tree_paths;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 *
 * A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 * Example 2:
 *
 * Input: root = [1]
 * Output: ["1"]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 100].
 * -100 <= Node.val <= 100
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 给一棵二叉树, 返回所有根节点到叶子节点的路径
 * 解题思路:
 * 深度遍历+回溯
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, paths, path);
        return paths;
    }

    /**
     * 对某个节点进行深度遍历
     * @param node
     * @param paths
     * @param path
     */
    private void dfs(TreeNode node, List<String> paths, List<Integer> path) {
        /*将当前节点添加到路径中*/
        path.add(node.val);
        /*如果当前节点已经是叶子节点, 拼接路径添加到集合中*/
        if(node.left == null && node.right == null) {
            String pathStr = path.stream().map(String::valueOf).collect(Collectors.joining("->"));
            paths.add(pathStr);
        }else{
            if(node.left != null){
                dfs(node.left, paths, path);
            }
            if(node.right != null){
                dfs(node.right, paths, path);
            }
        }
        /*回溯, 将当前节点从路径中移除*/
        path.remove(path.size() - 1);
    }
}
