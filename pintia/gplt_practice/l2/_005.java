import java.io.*;
import java.util.*;

public class _005 {
    static int n, k;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        Set<Integer>[] sts = new HashSet[n + 1];
        for (int i = 1; i <= n; ++i) {
            sts[i] = new HashSet<>();
            in.nextToken();
            int cnt = (int) in.nval;
            while (cnt-- > 0) {
                in.nextToken();
                int x = (int) in.nval;
                sts[i].add(x);
            }
        }
        in.nextToken(); k = (int) in.nval;
        StringBuilder ans = new StringBuilder();
        while (k-- > 0) {
            in.nextToken(); int a = (int) in.nval;
            in.nextToken(); int b = (int) in.nval;
            int same = 0;
            for (int c : sts[a]) {
                if (sts[b].contains(c)) {
                    ++same;
                }
            }
            int total = sts[a].size() + sts[b].size() - same;
            ans.append(String.format("%.2f%%\n", same * 100.0 / total));
        }
        System.out.print(ans);
    }
}
