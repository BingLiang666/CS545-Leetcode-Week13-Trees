import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solutions {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /* Problem 199. #Binary Tree Right Side View# #MEDIUM#
     * https://leetcode.com/problems/binary-tree-right-side-view/
     *  Problem description:
     *  Given the root of a binary tree, imagine yourself standing on the right side of it,
     *  return the values of the nodes you can see ordered from top to bottom.
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null) return res;
        Queue<TreeNode> que = new LinkedList();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = que.poll();
                if (i == size - 1) {
                    res.add(tempNode.val);
                }
                if (tempNode.left != null) que.offer(tempNode.left);
                if (tempNode.right != null) que.offer(tempNode.right);
            }
        }
        return res;
    }

    /* Problem 515. #Find Largest Value in Each Tree Row# # #MEDIUM#
     * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
     *  Problem description:
     *  Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = que.poll();
                if (tempNode.val > max) {
                    max = tempNode.val;
                }
                if (tempNode.left != null) que.offer(tempNode.left);
                if (tempNode.right != null) que.offer(tempNode.right);
            }
            res.add(max);
        }
        return res;
    }
}
