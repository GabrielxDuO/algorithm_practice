import java.util.*;
import java.io.*;

public class _卡片 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        // in.nextToken();
        // int n = (int) in.nval;
        for (int n = 1; n <= 30; ++n) {
            for (int i = 1; i <= n; ++i) {
                Set<Set<Integer>> st = new HashSet<>();
                for (int j = 1; j <= i; ++j) {
                    for (int k = 1; k <= i; ++k) {
                        Set<Integer> pr = new HashSet<>();
                        pr.add(j);
                        pr.add(k);
                        st.add(pr);
                    }
                }
                if (st.size() >= n) {
                    // System.out.println(st);
                    System.out.println(n + ": " + i);
                    break;
                }
            }
        }
    }
}
