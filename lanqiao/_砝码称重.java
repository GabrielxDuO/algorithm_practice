import java.util.*;
import java.io.*;

public class P1447 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        Set<Integer> ans = new HashSet<>();
        while (n-- > 0) {
            in.nextToken();
            int x = (int) in.nval;
            Set<Integer> st = new HashSet<>();
            for (int y : ans) {
                st.add(x + y);
                st.add(Math.abs(x - y));
            }
            ans.add(x);
            ans.addAll(st);
        }
        System.out.println(ans.size() - (ans.contains(0) ? 1 : 0));
    }
}
