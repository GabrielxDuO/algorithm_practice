import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 6, 8, 7, 1, 2, 3, 9};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = 0; j < nums.length - i - 1; ++j) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }
}