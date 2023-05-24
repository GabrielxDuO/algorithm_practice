import java.util.*;
import java.io.*;

public class _01唯一成对的数 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            nums[i] = (int) in.nval;
        }
        // 输入完成
        // 哈希表
        // int[] cnts = new int[n];
        // for (int num : nums) {
        //     if (++cnts[num] == 2) {
        //         System.out.println(num);
        //         return;
        //     }
        // }

        // 数学
        // int sum = 0;
        // for (int num : nums) sum += num;
        // int tmp = (n - 1) * n / 2;
        // System.out.println(sum - tmp);

        // 位运算
        int ans = 0;
        for (int i = 1; i < n; ++i) ans ^= i;
        for (int num : nums) ans ^= num;
        System.out.println(ans);
    }
}
