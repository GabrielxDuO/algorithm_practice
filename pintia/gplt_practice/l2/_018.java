import java.io.*;
import java.util.*;

public class _018 {
    static ArrayList<Double> a, b, res;
    static int n, amx, bmx;

    public static void calc() {
        for (int i = amx; i >= bmx; --i) {
            int e = i - bmx;
            double c = a.get(i) / b.get(bmx);
            res.set(e, c);
            for (int j = bmx - 1; j >= 0; --j) {
                a.set(j + e, a.get(j + e) - c * b.get(j));
            }
        }
    }

    public static boolean check(String s) {
        return !s.equals("0.0") && !s.equals("-0.0");
    }

    public static void print(ArrayList<Double> p, int mx) {
        int len = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = mx; i >= 0; --i) {
            String str = String.format("%.1f", p.get(i));
            if (check(str)) {
                ++len;
            }
        }
        sb.append(len).append(' ');
        if (len == 0) {
            sb.append("0 0.0");
            System.out.println(sb.toString());
            return;
        }
        for (int i = mx; i >= 0; --i) {
            String str = String.format("%.1f", p.get(i));
            if (check(str)) {
                sb.append(i).append(' ').append(str);
                if (--len > 0) {
                    sb.append(' ');
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);

        in.nextToken();
        n = (int) in.nval;
        int e, c;
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            e = (int) in.nval;
            in.nextToken();
            c = (int) in.nval;
            if (i == 0) {
                a = new ArrayList<>(e + 1);
                for (int j = 0; j <= e; ++j) a.add(0.0);
                amx = e;
            }
            a.set(e, (double) c);
        }

        in.nextToken();
        n = (int) in.nval;
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            e = (int) in.nval;
            in.nextToken();
            c = (int) in.nval;
            if (i == 0) {
                b = new ArrayList<>(e + 1);
                for (int j = 0; j <= e; ++j) {
                    b.add(0.0);
                }
                bmx = e;
            }
            b.set(e, (double) c);
        }

        if (bmx > amx) {
            print(b, -1);
            print(a, amx);
            out.flush();
            return;
        }
        res = new ArrayList<>(Math.max(amx - bmx + 1, 1));
        for (int i = 0; i < Math.max(amx - bmx + 1, 1); i++) res.add(0.0);
        calc();
        print(res, res.size() - 1);
        print(a, bmx - 1);

        out.flush();
    }
}
