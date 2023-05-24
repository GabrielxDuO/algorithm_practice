import java.util.*;
import java.io.*;

public class _扫地机器人 {
    static int n, k;
    static int[] bots;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        k = (int) in.nval;
        bots = new int[k];
        for (int i = 0; i < k; ++i) {
            in.nextToken();
            bots[i] = (int) in.nval;
        }
        Arrays.sort(bots);
        int l = 1, r = n;
        while (l < r) {
            int m = l + r >> 1;
            if (check(m)) r = m;
            else l = m + 1;
        }
        System.out.println((l - 1) * 2);
    }

    static boolean check(int x) {
        int cleaned = 0;
        for (int b : bots) {
            if (b - x <= cleaned) {
                if (b <= cleaned) cleaned = b + x - 1;
                else cleaned += x;
            } else return false;
        }
        return cleaned >= n;
    }
}
