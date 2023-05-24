import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C;
        List<Integer> N = new ArrayList<>();
        A.add(0);
        B.add(0);
        for (int i = 1; i <= n; i++) {
            A.add(0);
            A.add(1);
            B.add(2);
        }
        int x = n;
        while (x != 0) {
            N.add(x % 10);
            x /= 10;
        }
        C = del(mul(sub(add(A, N), B), 4), 9);
        StringBuilder ans = new StringBuilder();
        for (int i = C.size() - 1; i >= 0; i--) ans.append(C.get(i));
        PrintWriter pw = new PrintWriter(System.out);
        pw.println(ans);
        pw.flush();
        pw.close();
    }

    public static List<Integer> add(List<Integer> A, List<Integer> B) {
        List<Integer> C = new ArrayList<>();
        if (A.size() < B.size()) return add(B, A);
        int t = 0;
        for (int i = 0; i < A.size(); i++) {
            if (i < B.size()) t += B.get(i);
            t += A.get(i);
            C.add(t % 10);
            t /= 10;
        }

        if (t != 0) C.add(t);
        return C;
    }

    public static List<Integer> sub(List<Integer> A, List<Integer> B) {
        List<Integer> C = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < A.size(); i++) {
            t = A.get(i) - t;
            if (i < B.size()) t -= B.get(i);
            C.add((t + 10) % 10);
            if (t >= 0) t = 0;
            else t = 1;
        }
        while (C.size() > 1 && C.get(C.size() - 1) == 0) {
            C.remove(C.size() - 1);
        }
        return C;
    }

    public static List<Integer> mul(List<Integer> A, int b) {
        List<Integer> C = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < A.size() || t != 0; i++) {
            if (i < A.size()) t += b * A.get(i);
            C.add(t % 10);
            t /= 10;
        }
        return C;
    }

    public static List<Integer> del(List<Integer> A, int b) {
        List<Integer> C = new ArrayList<>();
        int r = 0;
        for (int i = A.size() - 1; i >= 0; i--) {
            r = r * 10 + A.get(i);
            C.add(r / b);
            r %= b;
        }
        Collections.reverse(C);
        while (C.size() > 1 && C.get(C.size() - 1) == 0) {
            C.remove(C.size() - 1);
        }
        return C;
    }
}