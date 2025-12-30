package A2dfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class A03DFS모든경우의수와백트래킹 {
    static List<List<Integer>> adjList = new ArrayList<>();
    static List<List<Integer>> answer = new ArrayList<>();

    public static void main(String[] args) {
        int[][] nodes = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3,7}, {4,8}, {4,9}, {5,10}};
        for(int i=0; i<11; i++){
            adjList.add(new ArrayList<>());
        }

//        여기서는 1번이 루트노드라고 가정했기에, visited를 제외하고 단방향 노드로 설계
        for(int[] node : nodes){
            adjList.get(node[0]).add(node[1]);
        }

        for(List<Integer> l : adjList){
            l.sort(Comparator.naturalOrder());
        }
        dfs(1, new ArrayList<>());
        System.out.println(answer);
    }
//    answer : [[1,2,4,8], [1,2,4,9]. [1,2,5,10], [1,3,6], [1,3,7]]
    static void dfs(int start, List<Integer> temp){
        temp.add(start);
        if(adjList.get(start).isEmpty()){
            answer.add(new ArrayList<>(temp));
        }
        for(int target : adjList.get(start)){
            dfs(target, temp);
            temp.remove(temp.size() - 1);
        }
    }
}

// 관련문제(완전탐색 & 백트래킹) : 피로도 - 프로그래머스

