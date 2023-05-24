import java.util.*;
import java.io.*;

public class _Fibonacci集合 {
    public static void main(String[] args) {
        TreeSet<Long> f = new TreeSet<>();
        Set<Long> nf = new HashSet<Long>(){{
            this.add(1L);
            this.add(2L);
            this.add(3L);
            this.add(5L);
            this.add(8L);
        }};
        while (f.size() < 1000000) {
            Set<Long> tmp = new HashSet<>();
            for (long x : nf) {
                f.add(x);
                tmp.add((long) (3 * x + 2));
                tmp.add((long) (5 * x + 3));
                tmp.add((long) (8 * x + 5));
            }
            nf.clear();
            nf.addAll(tmp);
        }
        List<Long> lst = new ArrayList(f);
        System.out.println(lst.get(2019));
    }
}
