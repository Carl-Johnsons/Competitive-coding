import java.util.HashMap;
import java.util.Map;

public class Most_Frequent_Even_Element {
    public static void main(String[] args) {
        int arr[] = { 29,47,21,41,13,37,25,7};
        System.out.println(mostFrequentEven(arr));
    }

    public static int mostFrequentEven(int[] nums) {
        int number = -1;
        Map<Integer, Integer> occurences = new HashMap<>();
        int maxOccurence = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                occurences.merge(nums[i], 1, Integer::sum);
                if (occurences.get(nums[i]) > maxOccurence) {
                    number = nums[i];
                    maxOccurence = occurences.get(nums[i]);
                } else if (occurences.get(nums[i]) == maxOccurence) {
                    if (number > nums[i]) {
                        number = nums[i];
                    }
                }
            }
        }

        return number;
    }
}
