package A4greedy;

import java.util.Arrays;
import java.util.Comparator;

// greedy(탐욕법) : 현재로써 최적의 해를 선택했을 때, 전체의 최적 해를 보장하는 알고리즘.
public class A01GreedyBasic {
    public static void main(String[] args) {
//        1,5,10,20 짜리의 동전이 있을 때, 이를 조합하여 99를 만들 수 있는 조합 중에 최소 개수를 구하라.
        int[] arr = {10, 5, 1, 20};
        int total = 0;
        int num = 99;

        Arrays.sort(arr);
        int index = arr.length-1;

        while(num >0) {
            //System.out.println(index);
            total += num / arr[index];
            num = num%arr[index];
            index--;
        }

        System.out.println(total);
    }
}
