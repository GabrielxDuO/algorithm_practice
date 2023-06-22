import java.io.*;
import java.util.*;

public class _019 {
    static int n, m;
    static Set<String> subs = new HashSet<>();
    static Map<String, Integer> mp = new HashMap<>();
    static Set<String> ans = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        for (int i = 0; i < n; ++i) {
            in.nextToken(); String s = in.sval;
            subs.add(s);
        }
        in.nextToken(); m = (int) in.nval;
        mp = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < m; ++i) {
            in.nextToken(); String s = in.sval;
            in.nextToken(); int x = (int) in.nval;
            mp.put(s, mp.getOrDefault(s, 0) + x);
            sum += x;
        }
        double avg = sum * 1.0 / m;
        ans = new TreeSet<>();
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            String id = entry.getKey();
            int cnt = entry.getValue();
            if (subs.contains(id)) continue;
            if (cnt > avg) ans.add(id);
        }
        if (ans.isEmpty()) System.out.println("Bing Mei You");
        else {
            StringBuilder sb = new StringBuilder();
            for (String s : ans) sb.append(s).append('\n');
            System.out.print(sb);
        }
    }
}
