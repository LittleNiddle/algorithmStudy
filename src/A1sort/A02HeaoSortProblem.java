package A1sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class A02HeaoSortProblem {
//    명예의 전당 : 프로그래머스
    public static void main(String[] args) {
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        int[] answer = new int[score.length];
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<score.length; i++){
            pq.offer(score[i]);
            if(pq.size()>k){
                pq.poll();
            }
            answer[i] = pq.peek();
        }
        System.out.println(Arrays.toString(answer));
    }
//    야근 지수 : 프로그래머스
    class Solution {
        public long solution(int n, int[] works) {
            long answer = 0;
            Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for(int w : works){
                pq.offer(w);
            }
            for(int i=n-1; i>=0; i--){
                int w = pq.poll();
                w = (w>0) ? w-1: 0;
                pq.offer(w);
            }
            while(!pq.isEmpty()){
                int w = pq.poll();
                answer += w * w;
            }
            return answer;
        }
    }
}
