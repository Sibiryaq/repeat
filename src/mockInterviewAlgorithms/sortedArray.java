package mockInterviewAlgorithms;

public class sortedArray {
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 4, 5, 6, 8};
        int target = 8;
        System.out.println(found(sortedArray, target));
    }

    static int found(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2 / 2;

            if(target > array[mid]) {
                left = mid + 1;
            } else if (target < array[mid])  {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;

    }




}
