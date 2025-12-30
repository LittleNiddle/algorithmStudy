package A3bfs;

import java.util.*;

public class A01BFS최단거리 {
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
        Queue<int[]> myQue = new LinkedList<>();
        myQue.add(new int[]{0,0}); // int 배열 안에는 {노드번호, 거리}
        visited[0] = true;
        int answer = -1;
        loop1:
        while(!myQue.isEmpty()){
            int[] temp = myQue.poll();
            for (int target : adjList.get(temp[0])) {
                if(!visited[target]){
                    myQue.offer(new int[]{target, temp[1]+1});
//                     bfs에서 visited는 queue에 add하는 시점에 true 세팅
                    visited[target] = true;
                    if(target == 4) {
                        answer = temp[1]+1;
                        break loop1;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
