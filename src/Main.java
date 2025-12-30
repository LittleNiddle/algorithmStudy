import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// DFS
public class Main {
    static int N = 5;
    static int[][] grid = new int[N][N];
    static Set<String> answer = new HashSet<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void dfs(int x, int y, int index, int[] temp){
        temp[index] = grid[x][y];
        if(index == 5){
            answer.add(Arrays.toString(temp));
            return;
        }
        for(int k=0; k<4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                dfs(nx, ny, index+1, temp);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i<N; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                grid[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                dfs(i, j, 0, new int[6]);
            }
        }
        System.out.println(answer);
        System.out.println(answer.size());
    }
}