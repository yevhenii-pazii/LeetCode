package problem.p1900_1999;


import structure.WeightedQuickUnion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    DFS - depth
    BFS - breadth
    Union Find
    Graph
 */
class P1971 {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        return false;
    }


    /*
        Time Complexity O(N + M) 80% -> transitions O(M) & queue(N)
        Space Complexity O(N + M) 76% -> transitions O(M) & visited O(N) & queue O(N)
     */
    public boolean validPathBFS(int n, int[][] edges, int source, int destination) {
        List<Integer>[] transitions = new List[n];
        for (var i = 0; i < n; i++) {
            transitions[i] = new ArrayList<>();
        }

        for (var edge : edges) {
            transitions[edge[0]].add(edge[1]);
            transitions[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == destination) {
                return true;
            }
            if (!visited[cur]) {
                queue.addAll(transitions[cur]); // if add here at the beginning (stack) then it would be DFS
                visited[cur] = true;
            }
        }

        return false;
    }

    /*
        Time Complexity O(N + M) 52% -> transitions O(M) & call stack(N)
        Space Complexity O(N + M) 54% -> transitions O(M) & visited O(N) & call stack O(N)
     */
    public boolean validPathRecursion(int n, int[][] edges, int source, int destination) {
        List<Integer>[] transitions = new List[n];
        for (var i = 0; i < n; i++) {
            transitions[i] = new ArrayList<>();
        }

        for (var edge : edges) {
            transitions[edge[0]].add(edge[1]);
            transitions[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        return recursion(transitions, visited, source, destination);
    }

    private static boolean recursion(List<Integer>[] transitions, boolean[] visited, int source, int destination) {
        if (source == destination) {
            return true;
        }

        if (visited[source]) {
            return false;
        }

        visited[source] = true;
        for (var transition : transitions[source]) {
            if(recursion(transitions, visited, transition, destination)) {
                return true;
            }

        }
        return false;
    }

    /*
        Time Complexity O(M LogN) 91%
            -> initialize UF O(N), but simple & unions O(N LogN)
        Space Complexity O(N) 90%
            -> UF parents O(N), but smaller than others & UF size O(N) smaller than others
     */
    public boolean validPathUnionFind(int n, int[][] edges, int source, int destination) {
        WeightedQuickUnion uf = new WeightedQuickUnion(n); //At first implemented locally, then dropped

        for (var edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.find(destination) == uf.find(source);
    }
}
