import java.util.*;
import java.io.*;

public class P1451 {
    static Map<Integer, List<Integer>> mp = new HashMap<>();

    static int dfs(int node) {
        if (!mp.containsKey(node)) return 0;
        List<Integer> children = mp.get(node);
        int h = 0;
        for (int child : children) h = Math.max(h, dfs(child));
        return h + children.size();
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        for (int i = 2; i <= n; ++i) {
            in.nextToken();
            int p = (int) in.nval;
            mp.putIfAbsent(p, new ArrayList<>());
            mp.get(p).add(i);
        }
        System.out.println(dfs(1));
    }
}
