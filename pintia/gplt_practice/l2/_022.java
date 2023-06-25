import java.io.*;
import java.util.*;

public class _022 {
    static final int N = 100010;
    static int n;
    static int head, tail;
    static int[] ne = new int[N];
    static int[] pr = new int[N];
    static int[] mp = new int[N];

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        in.nextToken();
        head = (int) in.nval;
        in.nextToken();
        n = (int) in.nval;
        int curr;
        pr[head] = -1;
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            curr = (int) in.nval;
            in.nextToken();
            mp[curr] = (int) in.nval;
            in.nextToken();
            ne[curr] = (int) in.nval;
            if (ne[curr] != -1) pr[ne[curr]] = curr;
            else tail = curr;
        }
        curr = tail;
        ne[100001] = head;
        head = 100001;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; ; ++i) {
            if (i != 0) ans.append(String.format("%05d\n", curr));
            ans.append(String.format("%05d %d ", curr, mp[curr]));
            if ((i & 1) == 1) curr = tail = pr[tail];
            else curr = head = ne[head];
            if (head == tail) break;
        }
        ans.append("-1");
        out.println(ans);
        out.flush();
        out.close();
    }
}
