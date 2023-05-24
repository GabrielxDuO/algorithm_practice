import java.util.*;
import java.io.*;
import java.math.*;

public class A_斐波那契与7 {
    public static void main(String[] args) throws IOException {
        // BigInteger a = BigInteger.valueOf(1), b = a;
        // ArrayList<Integer> lst = new ArrayList<>();
        // lst.add(a.intValue());
        // lst.add(b.intValue());
        // for (int i = 0; i < 1000; ++i) {
        //     BigInteger c = a.add(b);
        //     lst.add(c.mod(BigInteger.valueOf(10)).intValue());
        //     a = b;
        //     b = c;
        // }
        // int rep = 2;
        // outer: for (; ; ++rep) {
        //     for (int i = 0; i < rep; ++i) {
        //         if (lst.get(i) != lst.get(i + rep)) continue outer;
        //     }
        //     break;
        // }
        // // System.out.println(rep); // 60
        // int cnt = 0;
        // for (int i = 0; i < rep; ++i) {
        //     if (lst.get(i) == 7) ++cnt;
        // }
        // // System.out.println(cnt); // 8
        // long ans = 202202011200L / rep * 8;
        // int rem = (int) (202202011200L % rep);
        // for (int i = 0; i < rem; ++i) {
        //     if (lst.get(i) == 7) ++ans;
        // }
        // System.out.println(ans);
        // System.out.println("26960268160");
        int a = 1, b = 1;
        long cnt = 0L;
        for (long i = 3; i <= 202202011200L; ++i) {
            int c = (a + b) % 10;
            if (c == 7) ++cnt;
            a = b; b = c;
        }
        System.out.println(cnt);
    }
}
