import java.util.*;
import java.io.*;

public class A_巧克力 {
    static class Choco {
        int price, expire, cnt;

        public Choco(int a, int b, int c) {
            price = a;
            expire = b;
            cnt = c;
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int x = (int) in.nval;
        in.nextToken(); int n = (int) in.nval;
        Choco[] chocos = new Choco[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken(); int a = (int) in.nval;
            in.nextToken(); int b = (int) in.nval;
            in.nextToken(); int c = (int) in.nval;
            chocos[i] = new Choco(a, b, c);
        }
        Arrays.sort(chocos, (a, b) -> b.expire - a.expire);
        Queue<Choco> pq = new PriorityQueue<>((a, b) -> a.price - b.price);
        int idx = 0;
        long cost = 0L;
        while (x > 0) {
            while (idx < n && chocos[idx].expire >= x) pq.offer(chocos[idx++]);
            if (pq.isEmpty()) break;
            Choco top = pq.peek();
            cost += top.price;
            if (--top.cnt == 0) pq.poll();
            --x;
        }
        System.out.println(x == 0 ? cost : -1);
    }
}
