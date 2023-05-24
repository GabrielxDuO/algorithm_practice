import java.util.*;
import java.io.*;

public class I_砝码称重 {
    static int n;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        Set<Integer> st = new HashSet<>();
        st.add(0);
        while (n-- > 0) {
            int w = in.nextInt();
            Set<Integer> ns = new HashSet<>();
            for (int x : st) {
                ns.add(w + x);
                ns.add(Math.abs(w - x));
            }
            st.addAll(ns);
        }
        st.remove(0);
        System.out.println(st.size());
    }
}
