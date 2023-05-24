import java.util.*;
import java.io.*;

public class _小木棍 {
    static int n;
    static Integer[] a;
    static boolean[] used;

    static boolean dfs(int each, int tot, int curr, int cnt, int st) {
        if (cnt == tot) return true;
        if (curr == each) return dfs(each, tot, 0, cnt + 1, 0);
        for (int i = st; i < n; ++i) {
            if (!used[i] && curr + a[i] <= each) {
                used[i] = true;
                if (dfs(each, tot, curr + a[i], cnt, i + 1)) return true;
                used[i] = false;
                if (curr == 0 || curr + a[i] == each) return false;
                while (i + 1 < n && a[i] == a[i + 1]) ++i;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        a = new Integer[n];
        used = new boolean[n];
        int sum = 0, mx = 0;
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
            sum += a[i];
            mx = Math.max(mx, a[i]);
        }
        Arrays.sort(a, Comparator.reverseOrder());
        for (int i = mx; i <= sum / 2; ++i) {
            if (sum % i == 0 && dfs(i, sum / i, 0, 0, 0)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(sum);
    }
}
