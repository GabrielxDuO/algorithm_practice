import java.util.*;
import java.io.*;

public class B_轨道炮 {
    static int n;
    static int[] xs, ys, vxs, vys;
    static int ans;
    static Map<Integer, Integer> mp = new HashMap<>();

    static void clac(int[] poses, int[] vs) {
        for (int i = 0; i < n; ++i) {
            mp.clear();
            int cnt = 1;
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                if (vs[i] == vs[j]) {
                    if (poses[i] == poses[j]) ++cnt;
                    ans = Math.max(ans, cnt);
                    continue;
                }
                int dd = poses[i] - poses[j];
                int dv = vs[j] - vs[i];
                int t = dd / dv;
                if (dd % dv != 0 || t < 0) continue;
                mp.put(t, mp.getOrDefault(t, 0) + 1);
                ans = Math.max(ans, cnt + mp.get(t));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        xs = new int[n];
        ys = new int[n];
        vxs = new int[n];
        vys = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken(); xs[i] = (int) in.nval;
            in.nextToken(); ys[i] = (int) in.nval;
            in.nextToken(); int v = (int) in.nval;
            in.nextToken(); char d = in.sval.charAt(0);
            if (d == 'U') vys[i] = v;
            else if (d == 'D') vys[i] = -v;
            else if (d == 'L') vxs[i] = -v;
            else if (d == 'R') vxs[i] = v;
        }
        clac(xs, vxs); clac(ys, vys);
        System.out.println(ans);
    }
}
