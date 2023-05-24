import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 6, 8, 7, 1, 2, 3, 9};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int split = partition(nums, start, end);
            quickSort(nums, start, split - 1);
            quickSort(nums, split + 1, end);
        }
    }

    static int partition(int[] nums, int start, int end) {
        int pivot = nums[start], left = start + 1, right = end;
        while (left <= right) {
            while (left <= right && nums[left] <= pivot) ++left;
            while (left <= right && nums[right] > pivot) --right;
            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        int tmp = nums[start];
        nums[start] = nums[right];
        nums[right] = tmp;
        return right;
    }
}
