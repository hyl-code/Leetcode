package October_2023;

import java.util.*;

/*
    有一棵根节点为 0 的家族树, 总共包含 n 个节点, 节点编号为 0 到 n - 1.
    给你一个下标从 0 开始的整数数组 parents, 其中 parents[i] 是节点 i 的父节点.
    由于节点 0 是根, 所以 parents[0] == -1.
    总共有 105 个基因值, 每个基因值都用闭区间 [1, 105] 中的一个整数表示.
    给你一个下标从 0 开始的整数数组 nums, 其中 nums[i] 是节点 i 的基因值, 且基因值互不相同.
    请你返回一个数组 ans, 长度为 n, 其中 ans[i] 是以节点 i 为根的子树内缺失的最小基因值.
    节点 x 为根的子树包含节点 x 和它所有的后代节点.
 */
public class smallestMissingValueSubtree_2003 {
    // DFS
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        List<Integer>[] children = new List[n];
        for(int i = 0; i < n; i++){
            children[i] = new ArrayList<Integer>();
        }
        for(int i = 1; i < n; i++){
            children[parents[i]].add(i);
        }
        int[] res = new int[n];
        Arrays.fill(res, 1);
        Set<Integer>[] geneSet = new Set[n];
        for(int i = 0; i < n; i++){
            geneSet[i] = new HashSet<Integer>();
        }
        dfs(0, res, nums, children, geneSet);
        return res;
    }

    public int dfs(int node, int[] res, int[] nums, List<Integer>[] children, Set<Integer>[] geneSet){
        geneSet[node].add(nums[node]);
        for(int child : children[node]){
            res[node] = Math.max(res[node], dfs(child, res, nums, children, geneSet));
            if(geneSet[node].size() < geneSet[child].size()){
                Set<Integer> temp = geneSet[node];
                geneSet[node] = geneSet[child];
                geneSet[child] = temp;
            }
            // 一个节点的基因值集合等于所有子节点的基因值集合的并集（包含该节点的基因值）
            geneSet[node].addAll(geneSet[child]);
        }
        while(geneSet[node].contains(res[node])){
            res[node]++;
        }
        return res[node];
    }
}
