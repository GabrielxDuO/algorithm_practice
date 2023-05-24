import java.util.*;
import java.io.*;

public class _斤斤计较的小Z {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] str = in.readLine().toCharArray();
        char[] pat = in.readLine().toCharArray();
        int n = str.length, m = pat.length;
        int[] nexts = new int[m];
        nexts[0] = -1;
        for (int i = 1, j = -1; i < m; ++i) {
            while (j >= 0 && pat[j + 1] != pat[i]) j = nexts[j];
            if (pat[j + 1] == pat[i]) ++j;
            nexts[i] = j;
        }
        int cnt = 0;
        for (int i = 0, j = -1; i < n; ++i) {
            while (j >= 0 && pat[j + 1] != str[i]) j = nexts[j];
            if (pat[j + 1] == str[i]) ++j;
            if (j + 1 == m) {
                ++cnt;
                j = nexts[j];
            }
        }
        System.out.println(cnt);
    }
}
