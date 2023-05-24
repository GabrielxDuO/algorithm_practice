import java.util.*;
import java.io.*;

public class I_gen {
    static final int N = 500, T = 100, P = 100, B = (int) 1e4;
    static Random rand = new Random();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("i.in")));
        int n = rand.nextInt(N), m = rand.nextInt(N);
        bw.write(n + " " + m);
        bw.newLine();
        while (m-- > 0) {
            int s = rand.nextInt(T), t = rand.nextInt(T - s) + s;
            int p = rand.nextInt(P - 2) + 2, c = rand.nextInt(n);
            bw.write(s + " " + t + " " + p + " " + c);
            bw.newLine();
            Set<Integer> as = new HashSet<>();
            while (c-- > 0) {
                int a, b = rand.nextInt(B) + 1;
                while (true) {
                    a = rand.nextInt(n) + 1;
                    if (!as.contains(a)) {
                        as.add(a);
                        break;
                    }
                }
                bw.write(a + " " + b);
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
