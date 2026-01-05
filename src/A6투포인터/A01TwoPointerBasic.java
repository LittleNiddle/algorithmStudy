package A6투포인터;

import java.util.*;
import java.io.*;

public class A01TwoPointerBasic {
    public static void main(String[] args) {
//        아래 배열에서 target이 될 수 있는 두 수의 조합을 모두 찾아내라.(1,9),(9,1) 같은 것으로 취급.
//        아래 코드의 복잡도는 n^2
//        int[] arr = {7,8,9,2,4,5,1,3,6};
//        int target = 10;
//        List<int[]> myList = new ArrayList<>();
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = +i+1; j < arr.length; j++) {
//                if (arr[i] + arr[j] == target) {
//                    myList.add(new int[]{arr[i], arr[j]});
//                }
//            }
//        }
//        for (int[] a : myList) {
//            System.out.println(Arrays.toString(a));
//        }

//        응
        int[] arr = {7,8,9,2,4,5,1,3,6};
//         배열을 정렬 : 1,2,3,4,5,6,7,8,9
        Arrays.sort(arr);
        List<int[]> myList = new ArrayList<>();
        int target = 10;
        int start = 0;
        int end = arr.length - 1;
//        투포인터의 복잡도 : n
        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == target) {
                myList.add(new int[]{arr[start],arr[end]});
                start++;
                end--;
            } else if (sum < target) {
                start++;
            }else {
                end--;
            }
        }
        for (int[] a : myList) {
            System.out.println(Arrays.toString(a));
        }

    }
}