package November_2023;

import java.util.ArrayList;
import java.util.List;
/*
    给定一个二叉树：
        struct Node {
          int val;
          Node *left;
          Node *right;
          Node *next;
        }

    填充它的每个 next 指针, 让这个指针指向其下一个右侧节点. 如果找不到下一个右侧节点, 则将 next 指针设置为 NULL.
    初始状态下, 所有 next 指针都被设置为 NULL.
 */
public class connect_117 {
    private final List<Node> pre = new ArrayList<>();

    public Node connect(Node root) {
        dfs(root, 0);
        return root;
    }

    private void dfs(Node node, int depth){
        if(node == null){
            return;
        }
        if(depth == pre.size()){
            pre.add(node);
        }else{
            pre.get(depth).next = node;
            pre.set(depth, node);
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
