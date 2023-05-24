import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 6, 8, 7, 1, 2, 3, 9};
        shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void shellSort(int[] nums) {
        int n = nums.length;
        for (int interval = n / 2; interval > 0; interval /=2) {
            for (int i = interval; i < n; i += interval) {
                int tmp = nums[i], j = i;
                while (j > 0 && nums[j - interval] > tmp) {
                    nums[j] = nums[j - interval];
                    j -= interval;
                }
                if (i != j) {
                    nums[j] = tmp;
                }
            } 
        }
    }
}