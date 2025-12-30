package A1sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// 트리 탐색 + 재귀적 호출을 통한 힙정렬
public class A01HeapSort구현 {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};
//        1. 최초 힙 구성
//        1-1) 부모 노드(n/2)와 자식 노드(n/2) 분리하여 부모 노드를 대상으로 heapify 수행
//        1-2) 자식 노드의 왼쪽 노드 : 부모 노드 X 2 + 1, 자식 노드의 오른쪽 노드 : 부모 노드 X 2 + 2
//        1-3) heapify 과정이 재귀 호출로 이루어짐
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
//        최초힙 결과 : 1, 3, 5, 6, 7, 5, 9, 8, 6
        System.out.println(Arrays.toString(arr));

//        2) 루트 노드와 최하위 노드를 자리 change해가면서 재 heapify
//        2-1) 자리 change 한 마지막 노드는 heapify 대상에서 제외
//        2-2) 최소힙 -> 내림차순 정렬, 최대힙 -> 오름차순 정렬
        for(int i=arr.length-1; i>=0; i--){
            int temp = arr[0];
            arr[0] = arr[i]; // 마지막 자리값 감소
            arr[i] = temp;
            heapify(arr, 0, i); // 전체 길이 감소
        }
        System.out.println(Arrays.toString(arr));

////        pq를 통한 정렬 방법
////        pq를 가지고 직접 정렬을 수행하기 보다는 지속적으로 값을 add하고 poll해 나가는 상황에서 사용
////        최초힙 구성 : n * log*n()

//        Queue<Integer> pq = new PriorityQueue<>(Arrays.asList(7, 6, 5, 8, 3, 5, 9, 1, 6));
//        System.out.println(pq); // 최초힙
//
//        System.out.println(pq.poll()); // poll의 복잡도 log(n)
//        pq.add(2); // add의 복잡도 log(n)

    }
    static void heapify(int[] arr, int parentIndex, int length){
//        자식 노드와의 비교, 만약 자식 노드가 더 작으면 자리 change
//        자리가 change 된다면, 재귀호출
//        heapify(arr, 자식 노드의 index);

        int leftIndex = parentIndex * 2 + 1;
        int rightIndex = parentIndex * 2 + 2;
//        int minIndex = (arr[leftIndex] > arr[rightIndex]) ? rightIndex : leftIndex;
//        if(arr[parentIndex] > arr[minIndex]){ // 부모 자식 스왑
//            int temp = arr[minIndex];
//            arr[minIndex] = arr[parentIndex];
//            arr[parentIndex] = temp;
//            if(minIndex < arr.length/2 -1) { // minIndex가 parent일 때 heapify
//                System.out.println(minIndex);
//                heapify(arr, minIndex);
//            }
//            System.out.println("heapify");
        int smallestIndex = parentIndex;
        if (leftIndex < length && arr[leftIndex] < arr[smallestIndex]) {
            smallestIndex = leftIndex;
        }
        if(rightIndex < length && arr[rightIndex] < arr[smallestIndex]){
            smallestIndex = rightIndex;
        }
//        가장 작은 index가 부모노드가 아니라면 자리 change 및 heapify
        if(parentIndex != smallestIndex){
            int temp = arr[parentIndex];
            arr[parentIndex] = arr[smallestIndex];
            arr[smallestIndex] = temp;
            heapify(arr, smallestIndex, length);
        }

    }
}
