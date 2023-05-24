import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class _排列型枚举 {
    static int N;
    static int[] nums = new int[20];
    static boolean[] used = new boolean[20];
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        N = (int) in.nval;
        dfs(1);
    }

    static void dfs(int x) {
        if (x == N + 1) {
            for (int i = 1; i <= N; ++i) {
                if (i > 1) System.out.print(" ");
                System.out.print(nums[i]);
            }
            System.out.print("\n");
            return;
        }
        for (int i = 1; i <= N; ++i) {
            if (!used[i]) {
                nums[x] = i;
                used[i] = true;
                dfs(x + 1);
                nums[x] = 0;
                used[i] = false;
            }
        }
    }
}
