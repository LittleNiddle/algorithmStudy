package A3bfs;

import java.util.*;

public class A01BFS방문순서 {
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] nodes = {{0,1}, {2,0}, {1,3}, {2,3}, {2,4}};
        visited = new boolean[5];
        for(int i=0; i<5; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] node : nodes){
            adjList.get(node[0]).add(node[1]);
            adjList.get(node[1]).add(node[0]);
        }
        for(List<Integer> l : adjList){
            l.sort(Comparator.naturalOrder());
        }
        Queue<Integer> myQue = new LinkedList<>();
        myQue.add(0);
        visited[0] = true;
        while(!myQue.isEmpty()){
            int temp = myQue.poll();
            System.out.println(temp);
            for (int target : adjList.get(temp)) {
                if(!visited[target]){
                    myQue.offer(target);
//                     bfs에서 visited는 queue에 add하는 시점에 true 세팅
                    visited[target] = true;
                }
            }
        }
    }
}
