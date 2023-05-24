import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 6, 8, 7, 1, 2, 3, 9};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            int tmp = nums[i], j = i;
            while (j > 0 && nums[j - 1] > tmp) {
                nums[j] = nums[--j];
            }
            if (i != j) {
                nums[j] = tmp;
            }
        }
    }
}