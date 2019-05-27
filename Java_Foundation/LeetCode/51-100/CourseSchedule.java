package stage.two.klaus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 207.
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 *
 * Hints:
 * 1.This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists
 * and therefore it will be impossible to take all courses.
 *
 * 2.There are several ways to represent a graph. For example, the input prerequisites is a graph represented by a list of edges.
 * Is this graph representation appropriate?
 *
 * 3.Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
 *
 * 4.Topological sort could also be done via BFS.
 *
 */
public class CourseSchedule {

    //BFS
    //我们定义二维数组graph来表示这个有向图，一位数组in来表示每个顶点的入度。我们开始先根据输入来建立这个有向图，并将入度数组也初始化好。
    // 然后我们定义一个queue变量，将所有入度为0的点放入队列中，然后开始遍历队列，从graph里遍历其连接的点，每到达一个新节点，将其入度减一，
    // 如果此时该点入度为0，则放入队列末尾。直到遍历完队列中所有的值，若此时还有节点的入度不为0，则说明环存在，返回false，反之则返回true。

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses]; //构建有向图，入度数
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            int goal = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if(graph[pre][goal] == 0)
                indegree[goal]++;
            graph[pre][goal] = 1;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        while(!queue.isEmpty()){
            int course = queue.poll();
            count++;
            for(int i = 0; i < numCourses; i++){
                if(graph[course][i] != 0){
                    indegree[i]--;
                    if(indegree[i] == 0){
                        queue.offer(i);
                    }
                }
            }
        }

        return count == numCourses;
    }

    //DFS  https://www.youtube.com/watch?v=M6SBePBMznU
    //DFS的解法，也需要建立有向图，还是用二维数组来建立，和BFS不同的是，我们像现在需要一个一维数组visit来记录访问状态，这里有三种状态，
    // 0表示还未访问过，1表示已经访问了，-1表示有冲突。大体思路是，先建立好有向图，然后从第一个门课开始，找其可构成哪门课，
    // 暂时将当前课程标记为已访问，然后对新得到的课程调用DFS递归，直到出现新的课程已经访问过了，则返回false，没有冲突的话返回true，
    // 然后把标记为已访问的课程改为未访问

    public boolean canFinish02(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for(int i=0; i<numCourses; i++){
            if(!dfs(graph,visited,i))
                return false;
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
        if(visited[course])
            return false;
        else
            visited[course] = true;

        for(int i=0; i<graph[course].size();i++){
            if(!dfs(graph,visited,(int)graph[course].get(i)))
                return false;
        }
        visited[course] = false;
        return true;
    }

}
