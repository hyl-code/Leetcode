package March_2022;

import java.util.ArrayList;
import java.util.List;

public class preorder_589 {
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

    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null){
            return res;
        }
        res.add(root.val);
        for(Node i : root.children){
            preorder(i);
        }
        return res;
    }
}
