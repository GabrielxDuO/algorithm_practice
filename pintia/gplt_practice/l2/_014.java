import java.io.*;
import java.util.*;

public class _014 {
    static final int N = (int) 1e5 + 10;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        TreeSet<Integer> st = new TreeSet<>();
        for (int i = n; i > 0; --i) {
            in.nextToken(); int x = (int) in.nval;
            Integer higher = st.higher(x);
            if (higher != null) st.remove(higher);
            st.add(x);
        }
        System.out.println(st.size());
    }
}
