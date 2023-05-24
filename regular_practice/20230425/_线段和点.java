import java.util.*;
import java.io.*;

public class _线段和点 {
    static int n, m;
    static int[][] segs;
    static int[] pts;

    static int search(int x) {
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (pts[mid] <= x) l = mid;
            else r = mid - 1;
        }
        return r;
    }

    static void del(int idx) {
        for (int i = idx; i < n - 1; ++i) pts[i] = pts[i + 1];
        --n;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        pts = new int[n];
        segs = new int[m][2];
        for (int i = 0; i < n; ++i) {
            in.nextToken(); pts[i] = (int) in.nval;
        }
        for (int i = 0; i < m; ++i) {
            in.nextToken(); segs[i][0] = (int) in.nval;
            in.nextToken(); segs[i][1] = (int) in.nval;
        }
        Arrays.sort(segs, (a, b) -> a[1] - b[1]);
        Arrays.sort(pts);
        int p = -1, cnt = 0;
        for (int[] seg : segs) {
            int l = seg[0], r = seg[1];
            if (p < l) {
                int idx = search(r);
                p = pts[idx];
                if (p < l || p > r) {
                    System.out.println(-1);
                    return;
                }
                ++cnt;
                del(idx);
            }
        }
        System.out.println(cnt);
    }
}
