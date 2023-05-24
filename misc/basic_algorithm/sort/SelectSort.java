import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 6, 8, 7, 1, 2, 3, 9};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int minIdx = i;
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] < nums[minIdx]) minIdx = j;
            }
            if (minIdx != i) {
                int tmp = nums[i];
                nums[i] = nums[minIdx];
                nums[minIdx] = tmp;
            }
        }
    }
}