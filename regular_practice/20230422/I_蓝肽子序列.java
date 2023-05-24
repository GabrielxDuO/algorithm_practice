import java.util.*;
import java.io.*;

public class I_蓝肽子序列 {
    static final int N = 1010;
    static String[] a = new String[N], b = new String[N];

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int n = 0;
        for (int i = 1; i < line.length(); ++i) {
            int st = i - 1;
            while (i < line.length() && line.charAt(i) >= 'a') ++i;
            a[++n] = line.substring(st, i);
        }
        if (line.charAt(line.length() - 1) <= 'Z') a[++n] = line.substring(line.length() - 1);
        line = in.nextLine();
        int m = 0;
        for (int i = 1; i < line.length(); ++i) {
            int st = i - 1;
            while (i < line.length() && line.charAt(i) >= 'a') ++i;
            b[++m] = line.substring(st, i);
        }
        if (line.charAt(line.length() - 1) <= 'Z') b[++m] = line.substring(line.length() - 1);
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (a[i].equals(b[j])) f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
            }
        }
        System.out.println(f[n][m]);
    }
}
