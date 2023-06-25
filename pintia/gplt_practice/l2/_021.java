import java.io.*;
import java.util.*;

public class _021 {
    static class Info implements Comparable<Info> {
        String name;
        int cnt;
        double avg = 0.0;

        public int compareTo(Info o) {
            if (cnt != o.cnt) return Integer.compare(o.cnt, cnt);
            return Double.compare(avg, o.avg);
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken(); int n = (int) in.nval;
        Info[] infos = new Info[n];
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            infos[i] = new Info();
            in.nextToken(); infos[i].name = in.sval;
            in.nextToken(); int k = (int) in.nval;
            mp.clear();
            while (k-- > 0) {
                in.nextToken(); int x = (int) in.nval;
                mp.put(x, mp.getOrDefault(x, 0) + 1);
                if (mp.get(x) == 1) ++infos[i].cnt;
            }
            for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
                infos[i].avg += entry.getValue();
            }
            infos[i].avg /= mp.size();
        }
        Arrays.sort(infos);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < Math.min(n, 3); ++i) {
            if (i > 0) ans.append(' ');
            ans.append(infos[i].name);
        }
        for (int i = Math.min(n, 3); i < 3; ++i) {
            if (i > 0) ans.append(' ');
            ans.append('-');
        }
        out.println(ans);
        out.flush();
        out.close();
    }
}
