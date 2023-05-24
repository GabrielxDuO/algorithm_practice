import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _座次问题 {
    static int N;
    static String[] names;
    static int[] nums = new int[20];
    static boolean[] isUsed = new boolean[20];
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(Reader.next());
        names = new String[N];
        for (int i = 0; i < N; ++i) names[i] = Reader.next();
        dfs(0);
    }

    static void dfs(int x) {
        if (x == N) {
            for (int i = 0; i < N; ++i) {
                if (i > 0) System.out.print(" ");
                System.out.print(names[nums[i]]);
            }
            System.out.print("\n");
            return;
        }
        for (int i = 0; i < N; ++i) {
            if (!isUsed[i]) {
                nums[x] = i;
                isUsed[i] = true;
                dfs(x + 1);
                nums[x] = 0;
                isUsed[i] = false;
            }
        }
    }

    static class Reader {
        static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer in = new StringTokenizer("");

        static String next() throws IOException {
            while (!in.hasMoreTokens()) {
                in = new StringTokenizer(BR.readLine());
            }
            return in.nextToken();
        }

        static String nextLine() throws IOException {
            return BR.readLine();
        }
    }
}
