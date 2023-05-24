import java.util.*;
import java.io.*;

public class _CLZ银行问题 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int m = (int) in.nval;
        Deque<String> v = new LinkedList<>(), n = new LinkedList<>();
        while (m-- > 0) {
            in.nextToken();
            String op = in.sval;
            if (op.equals("IN")) {
                in.nextToken();
                String name = in.sval;
                in.nextToken();
                String q = in.sval;
                (q.equals("V") ? v : n).offer(name);
            } else {
                in.nextToken();
                String q = in.sval;
                (q.equals("V") ? v : n).poll();
            }
        }
        while (!v.isEmpty()) System.out.println(v.pollFirst());
        while (!n.isEmpty()) System.out.println(n.pollFirst());
    }
}
