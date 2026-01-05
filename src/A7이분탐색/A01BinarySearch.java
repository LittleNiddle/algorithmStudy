package A7이분탐색;

public class A01BinarySearch {
    public static void main(String[] args) {
////        이분탐색은 사전에 정렬된 데이터를 대상으로 log(n)의 복잡도의 검색을 수행하는 알고리즘
//        int[] arr = {1,3,5,7,9,11,13,15,17,19};
//        int target = 17;
////        start, end, index를 두고 mid값 계산 (start+end)/2 = mid
////        mid의 값이 target보다 크다면 end=mid-1
////        mid의 값이 target보다 작다면 start=mid+1
////        mid의 값이 target과 일치하면 answer = mid; break;
//        int start=0;
//        int end=arr.length-1;
//        int answer = -1;
//        while(start <= end){
//            int mid = (start+end)/2;
//            if(arr[mid] < target){
//                start = mid+1;
//            } else if(arr[mid] > target) {
//                end = mid-1;
//            } else if(arr[mid] == target){
//                answer = mid;
//                break;
//            }
//        }

//        응용상황 : target이 arr에 있다면 index값을 리턴하고, arr에 없다면 있어야할 자리index를 리턴
//        answer가 == 뿐만아니라 > 또는 < 의 상황에서도 세팅될수 있음
        int[] arr = {1,3,5,7,9,11,13,15,17,19};
        int target = 4;
        int start=0;
        int end=arr.length-1;
        int answer = -1;
        while(start <= end){
            int mid = (start+end)/2;
            if(arr[mid] < target){
                start = mid+1;
            } else if(arr[mid] > target) {
                end = mid-1;
                answer = mid;   //arr에 없는값인데 있어야할 곳
            } else if(arr[mid] == target){
                answer = mid;
                break;
            }
        }
        System.out.println(answer);
    }
}