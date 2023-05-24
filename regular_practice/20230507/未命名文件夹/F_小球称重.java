import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int m = (int) in.nval;
        Set<Integer> aff = new HashSet<>(), sus = new HashSet<>();
        while (m-- > 0) {
            in.nextToken(); int k = (int) in.nval;
            Set<Integer> l = new HashSet<>(), r = new HashSet<>();
            for (int i = 0; i < k; ++i) {
                in.nextToken(); l.add((int) in.nval);
            }
            for (int i = 0; i < k; ++i) {
                in.nextToken(); r.add((int) in.nval);
            }
            char cmp = br.readLine().charAt(0);
            if (cmp == '<') {
                if (sus.isEmpty()) sus.addAll(l);
                else sus.retainAll(l);
            } else if (cmp == '>') {
                if (sus.isEmpty()) sus.addAll(r);
                else sus.retainAll(r);
            } else {
                aff.addAll(l);
                aff.addAll(r);
                sus.removeAll(l);
                sus.removeAll(r);
            }
        }
        System.out.println(sus.isEmpty() ? n - aff.size() : sus.size());
    }
}
