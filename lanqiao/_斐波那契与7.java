import java.util.*;
import java.io.*;
import java.math.*;

public class _斐波那契与7 {
    public static void main(String[] args) throws IOException {
        // int n = 10000;
        // int[] fib = new int[n];
        // fib[0] = fib[1] = 1;
        // final BigInteger TEN = BigInteger.valueOf(10);
        // BigInteger a = BigInteger.valueOf(1), b = BigInteger.valueOf(1);
        // for (int i = 2; i < n; ++i) {
        //     BigInteger c = a.add(b);
        //     fib[i] = c.mod(TEN).intValue();
        //     a = b; b = c;
        // }
        // int len = 3;
        // outer: for (; ; ++len) {
        //     for (int i = 0; i < len; ++i) {
        //         if (fib[i] != fib[len + i]) continue outer;
        //     }
        //     break;
        // }
        // int rem = (int) (202202011200L % len);
        // long cnt = 0, remCnt = 0;
        // for (int i = 0; i < len; ++i) {
        //     if (fib[i] == 7) {
        //         ++cnt;
        //         if (i < rem) ++remCnt;
        //     }
        // }
        // cnt = cnt * (202202011200L / len) + remCnt;
        // System.out.println(cnt); // 26960268160
        System.out.println(26960268160L);
    }
}
