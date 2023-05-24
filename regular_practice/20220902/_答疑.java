import java.io.*;
import java.util.Arrays;

public class _答疑 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        Answering[] anss = new Answering[n];
        while (n-- > 0) {
            in.nextToken();
            int s = (int) in.nval;
            in.nextToken();
            int a = (int) in.nval;
            in.nextToken();
            int e = (int) in.nval;
            anss[n] = new Answering(s + a, e);
        }
        Arrays.sort(anss);
        long total = 0, time = 0;
        for (Answering ans : anss) {
            time += ans.a;
            total += time;
            time += ans.b;
        }
        System.out.println(total);
    }

    static class Answering implements Comparable<Answering> {
        int a, b;

        public Answering(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Answering ans) {
            return this.a + this.b == ans.a + ans.b ?
                this.a - ans.a : this.a + this.b - (ans.a + ans.b);
        }
    }
}
