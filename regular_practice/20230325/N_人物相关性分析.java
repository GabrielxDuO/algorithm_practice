import java.util.*;
import java.io.*;

public class N_人物相关性分析 {
    static boolean isLetter(char ch) {
        return ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        in.nextToken();
        int k = (int) in.nval;
        char[] s = br.readLine().toCharArray();
        int n = s.length;
        List<Integer> alices = new ArrayList<>();
        List<Integer> bobs = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (i - 1 >= 0 && isLetter(s[i - 1])) continue;
            if (s[i] == 'A') {
                if (i + 1 >= n || s[i + 1] != 'l') continue;
                if (i + 2 >= n || s[i + 2] != 'i') continue;
                if (i + 3 >= n || s[i + 3] != 'c') continue;
                if (i + 4 >= n || s[i + 4] != 'e') continue;
                if (i + 5 < n && isLetter(s[i + 5])) continue;
                alices.add(i);
            } else if (s[i] == 'B') {
                if (i + 1 >= n || s[i + 1] != 'o') continue;
                if (i + 2 >= n || s[i + 2] != 'b') continue;
                if (i + 3 < n && isLetter(s[i + 3])) continue;
                bobs.add(i);
            }
        }
        int sz = bobs.size();
        if (bobs.size() == 0 || sz == 0) {
            System.out.println(0);
            return;
        }
        long cnt = 0;
        for (int a : alices) {
            int lb = a - 3 - k, ub = a + 5 + k;
            int l = 0, r = sz - 1;
            while (l < r) {
                int m = l + r >> 1;
                if (bobs.get(m) >= lb) r = m;
                else l = m + 1;
            }
            int t1 = l, x = bobs.get(t1);
            if (x < lb || x > ub) continue;
            l = 0;
            r = sz - 1;
            while (l < r) {
                int m = l + r + 1 >> 1;
                if (bobs.get(m) <= ub) l = m;
                else r = m - 1;
            }
            int t2 = l, y = bobs.get(t2);
            if (y > ub || y < lb) continue;
            cnt += t2 - t1 + 1;
        }
        System.out.println(cnt);
    }
}

