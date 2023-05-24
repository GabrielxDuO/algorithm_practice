import java.util.*;
import java.io.*;

public class _B {
    static int cnt = 0;

    static void dfs(int a, int b) {
        if (a == 0 || b == 0) return;
        ++cnt;
        if (a > b) {
            System.out.println(b + "x" + b);
            a -= b;
            dfs(b, a);
        } else {
            System.out.println(a + "x" + a);
            b -= a;
            dfs(a, b);
        }
    }

    public static void main(String[] args) {
        int a = 2019, b = 324;
        dfs(a, b);
        // dfs(5, 3);
        System.out.println(cnt);
    }
}
