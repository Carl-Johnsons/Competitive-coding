
public class Majority_Element {
    public static void main(String[] args) {
        int arr[] = { 2, 2, 3, 1 };
        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] nums) {
        int times_appear = nums.length / 2;
        int count = 0, candidate = -1;
        for (int i : nums) {
            if (count == 0) {
                candidate = i;
                count++;
            } else {
                if (i == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        count = 0;
        for (int i : nums) {
            if (i == candidate) {
                count++;
            }
        }
        if (count > times_appear)
            return candidate;
        return -1;
    }
}
