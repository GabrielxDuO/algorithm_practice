import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class CLZ的银行循环队列 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in =
                new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int M = (int) in.nval;
        System.out.println(M);
        Queue<String> V = new LinkedList<>(), N = new LinkedList<>();
        String ope, name, type;
        while (M-- > 0) {
            in.nextToken();
            ope = in.sval;
            if ("IN".equals(ope)) {
                in.nextToken();
                name = in.sval;
                in.nextToken();
                type = in.sval;
                if ("V".equals(type)) V.offer(name);
                else if ("N".equals(type)) N.offer(name);
            } else {
                in.nextToken();
                type = in.sval;
                if ("V".equals(type)) V.poll();
                else if ("N".equals(type)) N.poll();
            }
        }
        while (!V.isEmpty()) System.out.println(V.poll());
        while (!N.isEmpty()) System.out.println(N.poll());
    }
}
