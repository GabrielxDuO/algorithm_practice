import java.util.*;
import java.io.*;

public class _H {
    static Set<Set<Integer>> st = new HashSet<>();
    static Map<Set<Integer>, Set<Integer>> mp = new HashMap<>();

    static void dfs(int n, int curr, Set<Integer> ws, Set<Integer> fs) {
        if (curr > n) {
            st.add(new TreeSet<>(ws));
            mp.put(ws, fs);
            return;
        }
        for (int i = 1; i <= 30; ++i) {
            if (ws.contains(i)) continue;
            Set<Integer> nw = new HashSet<>();
            Set<Integer> nf = new HashSet<>();
            nw.add(i);
            nf.addAll(fs);
            nf.add(i);
            for (int w : ws) {
                nw.add(i + w);
                nw.add(Math.abs(i - w));
            }
            nw.addAll(ws);
            dfs(n, curr + 1, nw, nf);
        }
    }

    static void test(int n) {
        st.clear();
        dfs(n, 1, new HashSet<>(), new HashSet<>());
        int mx = 0;
        Set<Integer> f = new HashSet<>();
        for (Set<Integer> s : st) {
            List<Integer> lst = new ArrayList(s);
            int sz = lst.size();
            if (lst.get(lst.size() - 1) == sz) {
                if (sz > mx) {
                    mx = sz;
                    f = mp.get(s);
                }
            }
        }
        System.out.println(n + " - " + mx + " - " + f);
    }

    public static void main(String[] args) throws IOException {
        // for (int i = 1; i <= 5; ++i) test(i); // 找规律用
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int x = 0, cnt = 0;
        while (x < n) {
            ++cnt;
            x = x * 3 + 1;
        }
        System.out.println(cnt);
    }
}
