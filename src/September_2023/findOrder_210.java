package September_2023;

import java.util.ArrayList;
import java.util.List;
/*

 */
public class findOrder_210 {
    List<List<Integer>> edges;
    int[] visited;             // 标记每个节点状态 —— 0：未搜索  1：搜索中  2：已完成
    int[] course;
    boolean valid = true;
    int index;                 // 栈下标

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges  = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<Integer>());
        }
        course = new int[numCourses];
        visited = new int[numCourses];
        index = numCourses - 1;
        for(int[] prerequisite : prerequisites){
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        for(int i = 0; i < numCourses && valid; i++){
            if(visited[i] == 0){
                dfs(i);
            }
        }
        if(!valid){
            return new int[]{};
        }
        return course;
    }

    public void dfs(int u){
        visited[u] = 1;
        // 搜索其相邻节点
        for(int v : edges.get(u)){
            if(visited[v] == 0){
                dfs(v);
                if(!valid){
                    return;
                }
            }else if(visited[v] == 1){
                valid = false;
                return;
            }
        }
        visited[u] = 2;
        course[index--] = u;
    }
}
