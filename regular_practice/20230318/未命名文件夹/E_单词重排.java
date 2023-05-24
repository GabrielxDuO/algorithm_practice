import java.util.*;
import java.io.*;

public class Main {
    static int n = 7;
    static char[] a = "LABQIAO".toCharArray();
    static boolean[] vis = new boolean[n];
    static char[] b = new char[n];
    static Set<String> st = new HashSet<>();

    static void dfs(int pos) {
        if (pos == n) {
            st.add(String.valueOf(b));
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                b[pos] = a[i];
                vis[i] = true;
                dfs(pos + 1);
                vis[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        dfs(0);
        System.out.println(st.size());
    }
}
