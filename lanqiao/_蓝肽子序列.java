import java.util.*;
import java.io.*;

public class _蓝肽子序列 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        List<String> a = new ArrayList<>(), b = new ArrayList<>();
        a.add("");
        b.add("");
        String s = in.readLine();
        int prev = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) <= 'Z') {
                a.add(s.substring(prev, i));
                prev = i;
            }
        }
        a.add(s.substring(prev));
        s = in.readLine();
        prev = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) <= 'Z') {
                b.add(s.substring(prev, i));
                prev = i;
            }
        }
        b.add(s.substring(prev));
        int n = a.size() - 1, m = b.size() - 1;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (a.get(i).equals(b.get(j))) f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
            }
        }
        System.out.println(f[n][m]);
    }
}
