import java.util.*;
import java.io.*;

public class M_爱找事的小Z {
    static final int N = 1010, M = (int) 1e6 + 10;
    static int[][] sons = new int[M][26];
    static int idx;
    static int[] cnts = new int[N];

    static boolean insert(String s) {
        int p = 0;
        for (char c : s.toCharArray()) {
            int u = c - 'a';
            if (sons[p][u] == 0) sons[p][u] = ++idx;
            p = sons[p][u];
        }
        return ++cnts[p] == 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        in.nextToken(); int n = (int) in.nval;
        while (n-- > 0) {
            String s = br.readLine();
            if (!insert(s)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}
