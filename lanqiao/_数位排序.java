import java.util.*;
import java.io.*;

public class _数位排序 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        int[][] nums = new int[n + 1][2];
        for (int i = 1; i <= n; ++i) {
            nums[i][0] = i;
            for (int j = i; j > 0; j /= 10) nums[i][1] += j % 10;
        }
        Arrays.sort(nums, (a, b) -> {
            return a[1] == b[1] ? a[0] - b[0] : a[1] - b[1];
        });
        System.out.println(nums[m][0]);
    }
}
