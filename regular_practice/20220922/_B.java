import java.util.*;
import java.io.*;

public class _B {
    static String origin, target;
    static Map<String, Integer> map = new HashMap<>();
    static Queue<String> que = new LinkedList<>();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        origin = in.readLine();
        target = in.readLine();
        n = origin.length();
        que.offer(origin);
        System.out.println(bfs());
    }

    static int bfs() {
        while (!que.isEmpty()) {
            String state = que.poll();
            int step = map.getOrDefault(state, 0);
            if (state.equals(target)) return step;
            int pos = state.indexOf('*');
            for (int offset = -3; offset <= 3; ++offset) {
                if (offset == 0) continue;
                int targetPos = pos + offset;
                if (targetPos >= 0 && targetPos < n) {
                    state = swap(state, pos, targetPos);
                    if (!map.containsKey(state)) {
                        map.put(state, step + 1);
                        que.offer(state);
                    }
                    state = swap(state, pos, targetPos);
                }
            }
        }
        return -1;
    }

    static String swap(String str, int i, int j) {
        char[] chs = str.toCharArray();
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
        return String.valueOf(chs);
    }
}
