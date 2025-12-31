package A5DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class A02동전문제 {
    public static void main(String[] args) {
//        1, 4, 5의 동전이 있을때, 조합하여 13을 만들 수 있는 최소의 개수
        int[] arr = {1, 4, 5};
        int target = 13;
//        현재 기준으로 봤을 때, 과거 값을 어떻게 활용할 수 있을까?
//        동전을 하나만 추가 했을 때 13이 되는 경우
//        1. 1원 사용 : 12 -> 13
//        2. 4원 사용 : 9 -> 13
//        3. 5원 사용 : 8 -> 13

//        n원을 만드는 최소동전수 : min(dp[n-a], dp[n-b], dp[n-c]) + 1(동전 1개)
        int[] dp = new int[target+1];

        for(int i=1; i<target+1; i++){
            int min = Integer.MAX_VALUE;
            for(int j=0; j<arr.length; j++){
                if(i-arr[j] >= 0 && dp[i-arr[j]] < min){
                    min = dp[i-arr[j]];
                }
            }
            dp[i] = min + 1;
        }

//        dp[1] = 1;
//        dp[2] = 2;
//        dp[3] = 3;
//        dp[4] = 1;
//        dp[5] = 1;
//        for(int i=6; i<target+1; i++){
//            dp[i] = 1000;
//            for(int a : arr){
//                dp[i] = Math.min(dp[i], dp[i-a]+1);
//            }
//        }
        System.out.println(Arrays.toString(dp));
    }
}

// 1이 포함되지 않을 수 있고, target을 못 만들 수도 있는 경우의 동전문제
// 동전2(2294) : 백준
