package September_2023;

import java.util.ArrayList;
import java.util.List;
/*
    你这个学期必须选修 numCourses 门课程, 记为 0 到 numCourses - 1.
    在选修某些课程之前需要一些先修课程.
    先修课程按数组 prerequisites 给出, 其中 prerequisites[i] = [ai, bi], 表示如果要学习课程 ai 则必须先学习课程 bi.
    例如, 先修课程对 [0, 1] 表示：想要学习课程 0, 你需要先完成课程 1.
    请你判断是否可能完成所有课程的学习？如果可以, 返回 true; 否则, 返回 false.
 */
public class canFinish_207 {
    List<List<Integer>> edges;
    int[] visited;      // 0：未搜索, 1：搜索中, 2：已完成
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges  = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for(int[] prerequisite : prerequisites){
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        for(int i = 0; i < numCourses && valid; i++){
            if(visited[i] == 0){
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u){
        visited[u] = 1;
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
    }
}
