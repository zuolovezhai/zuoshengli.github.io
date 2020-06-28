package datastructure.tree;

import apple.laf.JRSUIUtils;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @author zuoshengli
 **/
public class TraverseTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node5.left = node7;
        node5.right = node8;
        node6.left = node9;
        //前序递归实现
        System.out.println("------前序遍历-递归------");
        preorder_r(node1);
        //前序迭代实现
        System.out.println("\n------前序遍历-迭代------");
        preorder_iterate(node1);
        //中序递归实现
        System.out.println("------中序遍历-递归------");
        inorder_r(node1);
        //中序迭代实现
        System.out.println("\n------中序遍历-迭代------");
        inorder_iterate(node1);
        //后序递归实现
        System.out.println("\n------后序遍历-递归------");
        postorder_r(node1);
        //后序迭代实现
        System.out.println("\n------后序遍历-迭代------");
        postorder_iterate(node1);
        //广度遍历实现
        System.out.println("\n------广度遍历------");
        bfs(node1);
    }

    public static void preorder_r(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        preorder_r(root.left);

        preorder_r(root.right);
    }

    public static void preorder_iterate(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            System.out.print(tmp.val);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }

            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
    }

    public static void inorder_r(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder_r(root.left);
        System.out.print(root.val);
        inorder_r(root.right);
    }

    public static void inorder_iterate(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode subRoot = stack.pop();
            System.out.print(subRoot.val);
            root = subRoot.right;
        }
    }

    public static void postorder_r(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder_r(root.left);
        postorder_r(root.right);
        System.out.print(root.val);
    }

    public static void postorder_iterate(TreeNode root) {
        Map<TreeNode, Boolean> visited = new HashMap<>();
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode subRoot = stack.peek();
            if (subRoot.right == null || visited.get(subRoot.right) != null) {
                stack.pop();
                System.out.print(subRoot.val);
                visited.put(subRoot, true);
            } else {
                root = subRoot.right;
            }
        }
    }

    public static void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            System.out.print(tmp.val);
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


