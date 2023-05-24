import java.util.*;
import java.io.*;

public class _爱找事的小Z {
    static final int N = 1010, M = N * 1000;
    static int[][] sons = new int[N][26];
    static int[] cnts = new int[N];
    static int idx;

    static boolean insert(String s) {
        int p = 0;
        for (char ch : s.toCharArray()) {
            int curr = ch - 'a';
            if (sons[p][curr] == 0) sons[p][curr] = ++idx;
            p = sons[p][curr];
        }
        return ++cnts[p] == 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            String s = in.readLine();
            if (insert(s)) {
                System.out.println(1 + ": " + s);
                return;
            }
        }
        System.out.println(0);
    }
}
