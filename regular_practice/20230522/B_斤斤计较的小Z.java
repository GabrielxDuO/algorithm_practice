import java.util.*;
import java.io.*;

public class B_斤斤计较的小Z {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        char[] s = ('\0' + in.nextLine()).toCharArray();
        char[] p = ('\0' + in.nextLine()).toCharArray();
        int n = s.length - 1, m = p.length - 1;
        int[] ne = new int[m + 1];
        for (int i = 2, j = 0; i <= m; ++i) {
            while (j > 0 && p[i] != p[j + 1]) j = ne[j];
            if (p[i] == p[j + 1]) ++j;
            ne[i] = j;
        }
        int cnt = 0;
        for (int i = 1, j = 0; i <= n; ++i) {
            while (j > 0 && s[i] != p[j + 1]) j = ne[j];
            if (s[i] == p[j + 1]) ++j;
            if (j == m) {
                ++cnt;
                j = ne[j];
            }
        }
        System.out.println(cnt);
    }
}
