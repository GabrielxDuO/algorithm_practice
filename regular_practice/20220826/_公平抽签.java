import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _公平抽签 {
    static int n, m;
    static String[] names;
    static List<Integer> chosen;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(Reader.next());
        m = Integer.parseInt(Reader.next());
        names = new String[n];
        for (int i = 0; i < n; ++i) names[i] = Reader.next();
        chosen = new ArrayList<>();
        dfs(0);
    }

    static void dfs(int x) {
        if (chosen.size() > m || chosen.size() + (n - x) < m) return;
        if (x == n) {
            boolean flag = true;
            for (int idx : chosen) {
                if (flag) flag = false;
                else System.out.print(" ");
                System.out.print(names[idx]);
            }
            System.out.print("\n");
            return;
        }
        chosen.add(x);
        dfs(x + 1);
        chosen.remove(chosen.size() - 1);
        dfs(x + 1);
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
