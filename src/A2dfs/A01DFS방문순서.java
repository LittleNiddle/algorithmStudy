package A2dfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class A01DFS방문순서 {
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) {
//        출발은 0부터 시작했을 때 dfs로 방문할 경우 방문 순서
        int[][] nodes = {{0,1}, {2,0}, {1,3}, {2,3}, {2,4}};
        visited = new boolean[5];
        for(int i=0; i<5; i++){
            adjList.add(new ArrayList<>());
        }

//        인접 리스트에 인접해 있는 노드 값 담기
        for(int[] node : nodes){
//            양방향 간선인 경우
            adjList.get(node[0]).add(node[1]);
            adjList.get(node[1]).add(node[0]);
        }
//        정점 번호가 작은 것부터 방문하기 위한 정렬 작업
        for(List<Integer> l : adjList){
            l.sort(Comparator.naturalOrder());
        }
        dfs(0);
    }
    static void dfs(int start){
        System.out.println(start);
        visited[start] = true;
        for(int target : adjList.get(start)){
            if(visited[target]) continue;
            dfs(target);
        }
    }
}

// 관련문제
// DFSBFS(1260) : 백준
// 트리의 부모 찾기(11725) : 백준
// 연결 요소의 개수(11724) : 백준
