import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _公平抽签_组合型枚举 {
    static int N, M;
    static List<String> lst;
    static List<Integer> chosen;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(Reader.next());
        M = Integer.parseInt(Reader.next());
        lst = new ArrayList<>();
        chosen = new ArrayList<>();
        for (int i = 0; i < N; ++i) lst.add(Reader.next());
        choose(1);
    }

    static void choose(int x) {
        if (chosen.size() > M || chosen.size() + (N - x + 1) < M) return;
        if (x == N + 1) {
            boolean flag = true;
            for (int num : chosen) {
                if (flag) flag = false;
                else System.out.print(" ");
                System.out.print(lst.get(num - 1));
            }
            System.out.println();
            return;
        }
        chosen.add(x);
        choose(x + 1);
        chosen.remove(chosen.size() - 1);
        choose(x + 1);
    }

    static class Reader {
        static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer in = new StringTokenizer("");

        static String next() throws IOException {
            while (!in.hasMoreTokens()) {
                in = new StringTokenizer(BR.readLine());
            }
            return in.nextToken();
        }
    
        static String nextLine() throws IOException {
            return BR.readLine();
        }
    }
}