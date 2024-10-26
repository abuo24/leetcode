package uz.coder.leetcode_75.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
/**
 * 199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class RightSideWindow {

    // Function to perform BFS (level-order traversal) on a binary tree
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> els = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            System.out.print(currentNode.val + " "); // Process the node

            // Enqueue the left child if it exists
//            if (currentNode.left != null) {
//                queue.add(currentNode.left);
//            }
            els.add(currentNode.val);
            // Enqueue the right child if it exists
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return els;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        RightSideWindow bfsExample = new RightSideWindow();
        bfsExample.rightSideView(root);
    }
}

