import java.util.*;
import java.io.*;

public class _蓝肽子序列 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str1 = in.readLine();
        String str2 = in.readLine();
        str1 += 'A';
        str2 += 'A';
        List<Integer> a = new ArrayList<>(), b = new ArrayList<>();
        int begin = 0;
        for (int i = 1; i < str1.length(); ++i) {
            char ch = str1.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                a.add(str1.substring(begin, i).hashCode());
                begin = i;
            }
        }
        begin = 0;
        for (int i = 1; i < str2.length(); ++i) {
            char ch = str2.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                b.add(str2.substring(begin, i).hashCode());
                begin = i;
            }
        }
        int n = a.size(), m = b.size();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (a.get(i - 1).equals(b.get(j - 1))) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(dp[n][m]);
    }
}
