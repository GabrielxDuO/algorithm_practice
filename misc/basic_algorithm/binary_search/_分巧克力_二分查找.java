import java.io.*;

public class _分巧克力_二分查找 {
    static int N, K;
    static int[][] chocos;
    
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        N = (int) in.nval;
        in.nextToken();
        K = (int) in.nval;
        chocos = new int[N][2];
        int l = 0, r = 0;
        for (int i = 0; i < N; ++i) {
            in.nextToken();
            int H = (int) in.nval;
            in.nextToken();
            int W = (int) in.nval;
            r = Math.max(r, Math.max(H, W));
            chocos[i][0] = H;
            chocos[i][1] = W;
        }
        while (l < r) {
            int c = l + (r - l + 1 >> 1);
            if (check(c)) l = c;
            else r = c - 1;
        }
        System.out.println(l);
    }
    
    static boolean check(int n) {
        int cnt = 0;
        for (int[] choco : chocos) {
            cnt += (choco[0] / n) * (choco[1] / n);
            if (cnt >= K) return true;
        }
        return false;
    }
}
