package April_2024;

import java.util.*;

public class ThroneInheritance_1600 {
    Map<String, List<String>> edges;
    Set<String> dead;
    String king;

    public ThroneInheritance_1600(String kingName) {
        edges = new HashMap<String, List<String>>();
        dead = new HashSet<String>();
        king = kingName;
    }

    public void birth(String parentName, String childName) {
        List<String> children = edges.getOrDefault(parentName, new ArrayList<String>());
        children.add(childName);
        edges.put(parentName, children);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<String>();
        preorder(res, king);
        return res;
    }

    private void preorder(List<String> res, String name) {
        if (!dead.contains(name)) {
            res.add(name);
        }
        List<String> children = edges.getOrDefault(name, new ArrayList<String>());
        for (String childName : children) {
            preorder(res, childName);
        }
    }
}
