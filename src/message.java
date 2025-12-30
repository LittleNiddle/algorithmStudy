import java.util.*;

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