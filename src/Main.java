import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// DP
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        int[] dp = new int[N];
        int[][] prev = new int[N][2];
        // prev[0] = new int[]{, -1};
        for(int i=0; i<N; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i] && dp[j] > max){
                    max = dp[j];
                    prev[i] = new int[]{arr[j], j};
                }
            }
            dp[i] = max + 1;
        }

        // max값과 index 찾기
        int index = 0;
        int max = 0;
        for(int i=0; i<N; i++){
            if(dp[i] > max){
                max = dp[i];
                index = i;
            }
        }
        sb.append(max+"\n");

//        역추적
        List<Integer> result = new ArrayList<>();
        result.add(arr[index]);
        while(true){
            int[] pr = prev[index];
            int value = pr[0];
            if(value == 0) break;
            result.add(value);
            index = pr[1];
        }

//        출력
        for(int i=result.size()-1; i>=0; i--){
            sb.append(result.get(i)+" ");
        }
        System.out.println(sb);
    }
}
