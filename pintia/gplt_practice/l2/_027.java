import java.util.*;
import java.io.*;

public class _027 {
    static class Stu implements Comparable<Stu> {
        String acc;
        int s;

        public Stu(String acc, int s) {
            this.acc = acc;
            this.s = s;
        }

        @Override
        public int compareTo(Stu other) {
            if (this.s != other.s) {
                return other.s - this.s;
            } else {
                return this.acc.compareTo(other.acc);
            }
        }
    }

    static int n, g, k;
    static Stu[] stus;
    static int tot = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); g = (int) in.nval;
        in.nextToken(); k = (int) in.nval;
        stus = new Stu[n];
        for (int i = 0; i < n; ++i) {
            String[] s = br.readLine().split(" ");
            stus[i] = new Stu(s[0], Integer.parseInt(s[1]));
            if (stus[i].s >= g) tot += 50;
            else if (stus[i].s >= 60) tot += 20;
        }
        StringBuilder ans = new StringBuilder();
        ans.append(tot).append('\n');
        Arrays.sort(stus);
        int prev = -1, rk = 0;
        for (int i = 0; i < n; ++i) {
            String acc = stus[i].acc;
            int s = stus[i].s;
            if (s != prev) {
                rk = i + 1;
                if (rk > k) break;
            }
            ans.append(rk).append(' ').append(acc).append(' ').append(s).append('\n');
            prev = s;
        }
        out.print(ans);
        out.flush();
        out.close();
    }
}
