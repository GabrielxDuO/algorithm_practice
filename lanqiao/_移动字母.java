import java.util.*;
import java.io.*;

public class _移动字母 {
    static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static Map<String, Integer> mp = new HashMap<>();
    static {
        String s = "ABCDE*";
        Queue<String> que = new LinkedList<>();
        que.offer(s);
        mp.put(s, 5);
        while (!que.isEmpty()) {
            String curr = que.poll();
            int pos = mp.get(curr);
            int x = pos / 3, y = pos % 3;
            for (int[] DIR : DIRS) {
                int nx = x + DIR[0], ny = y + DIR[1];
                if (nx < 0 || nx >= 2 || ny < 0 || ny >= 3) continue;
                int npos = nx * 3 + ny;
                char[] nchs = curr.toCharArray().clone();
                nchs[pos] = nchs[npos];
                nchs[npos] = '*';
                String ns = String.valueOf(nchs);
                if (mp.containsKey(ns)) continue;
                que.offer(ns);
                mp.put(ns, npos);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        while (n-- > 0) {
            String t = in.nextLine();
            System.out.println(mp.containsKey(t) ? 1 : 0);
        }
    }
}
