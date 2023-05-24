import java.util.*;
import java.io.*;

public class _卡片换位 {
    static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = 2, m = 3;
        String s = in.nextLine(); s += in.nextLine();
        char[] chs = s.toCharArray();
        Map<String, Integer> mp = new HashMap<>();
        int a = 0, b = 0;
        for (int i = 0; i < 6; ++i) {
            if (chs[i] == 'A') a = i;
            else if (chs[i] == 'B') b = i;
            else if (chs[i] == ' ') mp.put(s, i);
        }
        chs[a] = 'B'; chs[b] = 'A';
        String t = String.valueOf(chs);
        Queue<String> que = new LinkedList<>();
        que.offer(s);
        int step = 0;
        while (!que.isEmpty()) {
            int sz = que.size();
            while (sz-- > 0) {
                String curr = que.poll();
                if (curr.indexOf('A') == b && curr.indexOf('B') == a) {
                    System.out.println(step);
                    return;
                }
                int pos = mp.get(curr);
                int x = pos / m, y = pos % m;
                for (int[] DIR : DIRS) {
                    int nx = x + DIR[0], ny = y + DIR[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    int npos = nx * m + ny;
                    char[] nchs = curr.toCharArray();
                    nchs[pos] = nchs[npos];
                    nchs[npos] = ' ';
                    String ns = String.valueOf(nchs);
                    if (mp.containsKey(ns)) continue;
                    mp.put(ns, npos);
                    que.offer(ns);
                }
            }
            ++step;
        }
    }
}
