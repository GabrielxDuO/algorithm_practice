import java.util.*;
import java.io.*;

public class _特殊时间 {
    static final int[] M = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int C1 = 0, C3 = 0;
    static boolean check(int x) {
        int[] cnts = new int[10];
        for (int i = 0; i < 4; ++i) {
            ++cnts[x % 10];
            x /= 10;
        }
        int c1 = -1, c3 = -1;
        for (int d = 0; d < 10; ++d) {
            if (cnts[d] == 1) c1 = d;
            else if (cnts[d] == 3) c3 = d;
        }
        C1 = c1;
        C3 = c3;
        return c1 != -1 && c3 != -1;
    }

    public static void main(String[] args) throws IOException {
        int cnt = 0;
        for (int yy = 0; yy < 10000; ++yy) {
            if (!check(yy)) continue;
            int yc1 = C1, yc3 = C3;
            for (int md = 1; md < 10000; ++md) {
                if (!check(md)) continue;
                if (C1 != yc1 || C3 != yc3) continue;
                int MM = md / 100, dd = md % 100;
                if (MM <= 0 || MM > 12 || dd <= 0 || MM != 2 && dd > M[MM]) continue;
                if (MM == 2) {
                    int o = yy % 4 == 0 && yy % 100 != 0 || yy % 400 == 0 ? 1 : 0;
                    if (dd > M[MM] + o) continue;
                }
                for (int hm = 1; hm < 10000; ++hm) {
                    if (!check(hm)) continue;
                    if (C1 != yc1 || C3 != yc3) continue;
                    int hh = hm / 100, mm = hm % 100;
                    if (hh <= 0 || hh > 24 || mm <= 0 || mm > 60) continue;
                    ++cnt;
                    // System.out.println(C1 + ", " + C3);
                    // System.out.printf("%04d%04d%04d\n", yy, md, hm);
                }
            }
        }
        System.out.println(cnt);
    }
}
