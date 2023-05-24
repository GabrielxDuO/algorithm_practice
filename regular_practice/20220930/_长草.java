import java.util.*;
import java.io.*;

public class _长草 {
    static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int n, m;
    static char[][] g;
    static int k;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(Reader.next());
        m = Integer.parseInt(Reader.next());
        g = new char[n][m];
        for (int i = 0; i < n; ++i) {
            g[i] = Reader.nextLine().toCharArray();
        }
        char[][] helper = new char[n][m];
        for (int i = 0; i < n; ++i) helper[i] = Arrays.copyOf(g[i], m);
        k = Integer.parseInt(Reader.next());
        while (k-- > 0) {
            for (int i = 0; i < n; ++i) g[i] = Arrays.copyOf(helper[i], m);
            for (int row = 0; row < n; ++row) {
                for (int col = 0; col < m; ++col) {
                    if (g[row][col] == '.') continue;
                    for (int[] d : DIRECTIONS) {
                        int x = row + d[0], y = col + d[1];
                        if (x < 0 || x >= n || y < 0 || y >= m) continue;
                        helper[x][y] = 'g';
                    }
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char[] line : helper) {
            ans.append(String.valueOf(line)).append("\n");
        }
        System.out.print(ans);
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

        static String nextLine() throws IOException { return BR.readLine(); }
    }
}
