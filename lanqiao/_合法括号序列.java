import java.util.*;
import java.io.*;

public class _合法括号序列 {
    static int n = 4, ans = 0;

    static void dfs(int l, int r) {
        if (l < r || l + r > n * 2) return;
        if (l == n && r == n) {
            ++ans;
            return;
        }
        dfs(l + 1, r);
        dfs(l, r + 1);
    }

    public static void main(String[] args) throws IOException {
        dfs(0, 0);
        System.out.println(ans);
    }
}
