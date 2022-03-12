package March_2022;

import java.util.LinkedList;
import java.util.List;

/*
    给定一个 n 叉树的根节点 root, 返回其节点值的后序遍历 .
    n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔 .
 */

public class postorder_590 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> postorder(Node root) {
        List<Integer> res = new LinkedList<>();
        traversal(res, root);
        return res;
    }

    public void traversal(List<Integer> list, Node node){
        if(node == null)
            return;
        for(Node child : node.children){
            traversal(list, child);
        }
        list.add(node.val);
    }
}
