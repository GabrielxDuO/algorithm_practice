import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] s, t, p;
    static int[] alls;
    static int len;
    static List<int[]>[] goods;
    static List<int[]>[] stTimes, edTimes;
    static TreeMap<Integer, Integer>[] sts;

    static void unique() {
        Arrays.sort(alls);
        int i = 0, j = 0;
        for (; j < len; ++j) {
            if (alls[i] != alls[j]) alls[++i] = alls[j];
        }
        len = i + 1;
    }

    static int get(int x) {
        int l = 0, r = len - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (alls[m] >= x) r = m;
            else l = m + 1;
        }
        return l;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int m = (int) in.nval;
        s = new int[m];
        t = new int[m];
        p = new int[m];
        alls = new int[m * 2];
        goods = new ArrayList[m];
        for (int i = 0; i < m; ++i) {
            in.nextToken(); s[i] = (int) in.nval;
            in.nextToken(); t[i] = (int) in.nval;
            in.nextToken(); p[i] = (int) in.nval;
            in.nextToken(); int c = (int) in.nval;
            alls[len++] = s[i]; alls[len++] = t[i] + 1;
            goods[i] = new ArrayList<>();
            while (c-- > 0) {
                in.nextToken(); int a = (int) in.nval;
                in.nextToken(); int b = (int) in.nval;
                goods[i].add(new int[]{a, b});
            }
        }
        unique();
        stTimes = new ArrayList[len];
        edTimes = new ArrayList[len];
        for (int i = 0; i < len; ++i) {
            stTimes[i] = new ArrayList<>();
            edTimes[i] = new ArrayList<>();
        }
        sts = new TreeMap[n + 1];
        for (int i = 1; i <= n; ++i) sts[i] = new TreeMap<>();
        for (int i = 0; i < m; ++i) {
            int st = get(s[i]), ed = get(t[i] + 1);
            for (int[] good : goods[i]) {
                int a = good[0], b = good[1];
                int dc = (int) (1L * b * p[i] / 100);
                sts[a].put(b, sts[a].getOrDefault(b, 0) + 1);
                stTimes[st].add(new int[]{a, dc});
                edTimes[ed].add(new int[]{a, dc});
            }
        }
        long tot = 0;
        for (int i = 1; i <= n; ++i) tot += sts[i].firstKey();
        long ans = tot;
        for (int i = 0; i < len; ++i) {
            long diff = 0;
            for (int[] good : stTimes[i]) {
                int a = good[0], b = good[1];
                diff -= sts[a].firstKey();
                sts[a].put(b, sts[a].getOrDefault(b, 0) + 1);
                diff += sts[a].firstKey();
            }
            for (int[] good : edTimes[i]) {
                int a = good[0], b = good[1];
                diff -= sts[a].firstKey();
                int cnt = sts[a].get(b) - 1;
                if (cnt == 0) sts[a].remove(b);
                else sts[a].put(b, cnt);
                diff += sts[a].firstKey();
            }
            tot += diff;
            ans = Math.min(ans, tot);
        }
        System.out.println(ans);
    }
}
