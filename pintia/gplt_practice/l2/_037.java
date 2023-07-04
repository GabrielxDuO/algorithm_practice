import java.util.*;
import java.io.*;

public class _037 {
    static final int N = 110;
    static int n, m, s;
    static Queue<Character>[] tracks = new Queue[N];
    static Stack<Character> stk = new Stack<>();
    static StringBuilder ans = new StringBuilder();

    static void exec(int x) {
        if (x != 0) {
            if (!tracks[x].isEmpty()) {
                if (stk.size() == s)
                    exec(0);
                stk.push(tracks[x].peek());
                tracks[x].poll();
            }
        } else {
            if (!stk.isEmpty()) {
                ans.append(stk.peek());
                stk.pop();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = in.readLine().split(" ");
        n = Integer.parseInt(ss[0]);
        m = Integer.parseInt(ss[1]);
        s = Integer.parseInt(ss[2]);
        for (int i = 1; i <= n; ++i) {
            char[] chs = in.readLine().toCharArray();
            tracks[i] = new LinkedList<>();
            for (char c : chs) tracks[i].offer(c);
        }
        ss = in.readLine().split(" ");
        for (String ns : ss) {
            if (Integer.parseInt(ns) == -1) break;
            else exec(Integer.parseInt(ns));
        }
        System.out.println(ans);
    }
}
