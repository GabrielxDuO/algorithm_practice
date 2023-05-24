import java.util.*;
import java.io.*;

public class C_平方拆分 {
    static final int N = 100;
    static int n = 2019;
    static int[] a = new int[N];
    static int len, ans;

    static void dfs(int x, int st) {
        if (x > 2019) return;
        if (x == 2019) {
            ++ans;
            return;
        }
        for (int i = st; i < len; ++i) {
            dfs(x + a[i], i + 1);
        }
    }

    public static void main(String[] args) {
        // for (int x = 1; x <= n / x; ++x) {
        //     if (x * x <= 2019) a[len++] = x * x;
        // }
        // dfs(0, 0);
        // System.out.println(ans);
        System.out.println(26287);
    }
}
