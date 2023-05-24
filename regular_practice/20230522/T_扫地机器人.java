import java.util.*;
import java.io.*;

public class T_扫地机器人 {
    static int n, k;
    static int[] a;

    static boolean check(int m) {
        int cleaned = 0;
        for (int pos : a) {
            if (pos - (cleaned + 1) <= m) {
                if (pos - (cleaned + 1) < 0) {
                    cleaned += m - (cleaned - pos);
                } else cleaned += m + 1;
            } else return false;
        }
        return cleaned >= n;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); k = (int) in.nval;
        a = new int[k];
        for (int i = 0; i < k; ++i) {
            in.nextToken(); a[i] = (int) in.nval;
        }
        Arrays.sort(a);
        int l = 1, r = n;
        while (l < r) {
            int m = l + r >> 1;
            if (check(m)) r = m;
            else l = m + 1;
        }
        System.out.println(l * 2);
    }
}
