import java.util.*;
import java.io.*;

public class _5034 {
    static int n;
    static boolean[] gns;
    static int[] a;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        gns = new boolean[n];
        a = new int[n];
        in.nextToken(); char[] s = in.sval.toCharArray();
        for (int i = 0; i < n; ++i) gns[i] = s[i] == 'B';
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] ls = new int[n], rs = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken(); a[i] = (int) in.nval;
            ls[i] = i - 1; rs[i] = i + 1;
            if (i > 0 && (gns[i] ^ gns[i - 1])) {
                pq.offer(new int[]{Math.abs(a[i] - a[i - 1]), i - 1, i});
            }
        }
        Set<Integer> teamd = new HashSet<>();
        List<int[]> teams = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int x = t[1], y = t[2];
            if (teamd.contains(x) || teamd.contains(y)) continue;
            teamd.add(x); teamd.add(y);
            teams.add(t);
            if (ls[x] >= 0 && rs[y] < n) {
                if (gns[ls[x]] ^ gns[rs[y]])
                    pq.offer(new int[]{Math.abs(a[ls[x]] - a[rs[y]]), ls[x], rs[y]});
                rs[ls[x]] = rs[y];
                ls[rs[y]] = ls[x];
            }
        }
        System.out.println(teams.size());
        for (int[] team : teams) {
            System.out.println(team[1] + 1 + " " + (team[2] + 1));
        }
    }
}
