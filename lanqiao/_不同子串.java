import java.util.*;
import java.io.*;

public class _不同子串 {
    public static void main(String[] args) throws IOException {
        String s = "0100110001010001";
        int n = s.length();
        Set<String> st = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                st.add(s.substring(i, j));
            }
        }
        System.out.println(st.size());
    }
}
