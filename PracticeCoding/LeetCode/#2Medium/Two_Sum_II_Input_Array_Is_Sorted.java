import java.util.Arrays;

public class Two_Sum_II_Input_Array_Is_Sorted {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 3, 9, 10 };
        int target = 6;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int low, high, mid, curNum;
        int arr[] = new int[2];
        arr[0] = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (arr[0] != -1)
                break;
            curNum = numbers[i];
            low = i;
            high = numbers.length - 1;
            while (low <= high) {
                mid = (low + high) / 2;
                if (mid != i && numbers[mid] == target - curNum) {
                    arr[0] = i + 1;
                    arr[1] = mid + 1;
                    break;
                }
                if (low != high && numbers[low] + numbers[high] == target) {
                    arr[0] = low + 1;
                    arr[1] = high + 1;
                    break;
                }
                if (numbers[mid] < target - curNum) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return arr;
    }
}
