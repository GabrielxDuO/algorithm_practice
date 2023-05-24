import java.util.*;
import java.io.*;

public class P506 {
    static int n, m, k, t;
    static int[] pt, spent;
    static boolean[] has;
    static Map<Integer, List<int[]>> mp = new HashMap<>();

    static int dfs(int c) {
        if (has[c]) return spent[c];
        for (int[] arr : mp.get(c)) {
            int a = arr[0], b = arr[1];
            if (!has[a]) dfs(a);
            if (!has[b]) dfs(b);
            spent[c] = Math.min(spent[c], arr[2] + Math.max(spent[a], spent[b]));
        }
        has[c] = true;
        return spent[c];
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;
        in.nextToken();
        k = (int) in.nval;
        in.nextToken();
        t = (int) in.nval;
        pt = new int[n + 1];
        spent = new int[n + 1];
        Arrays.fill(spent, 0x3f3f3f3f);
        has = new boolean[n + 1];
        for (int i = 1; i <= n; ++i) {
            in.nextToken();
            pt[i] = (int) in.nval;
        }
        while (m-- > 0) {
            in.nextToken();
            int x = (int) in.nval;
            has[x] = true;
            spent[x] = 0;
        }
        while (k-- > 0) {
            in.nextToken();
            int a = (int) in.nval;
            in.nextToken();
            int b = (int) in.nval;
            in.nextToken();
            int c = (int) in.nval;
            mp.putIfAbsent(c, new ArrayList<>());
            mp.get(c).add(new int[]{a, b, Math.max(pt[a], pt[b])});
        }
        System.out.println(dfs(t));
    }
}
