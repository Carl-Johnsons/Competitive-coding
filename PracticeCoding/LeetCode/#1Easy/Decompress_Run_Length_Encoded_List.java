import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Decompress_Run_Length_Encoded_List {
    public static void main(String[] args) {
        int arr[] = { 10, 2, 5, 4 };
        System.out.println(Arrays.toString(decompressRLElist(arr)));
    }

    public static int[] decompressRLElist(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        int first, second;
        for (int i = 0; i < nums.length; i += 2) {
            first = nums[i];
            second = nums[i + 1];
            for (int j = 0; j < first; j++) {
                list.add(second);
            }
        }

        // convert list to array
        int arr[] = new int[list.size()];
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = iterator.next();
        }
        return arr;
    }
}
