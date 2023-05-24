import java.util.*;
import java.io.*;
import java.math.*;

public class _产生数 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        char[] s = in.next().toCharArray();
        int k = in.nextInt();
        List<Integer>[] trans = new ArrayList[10];
        for (int i = 0; i < 10; ++i) trans[i] = new ArrayList<>();
        while (k-- > 0) {
            int x = in.nextInt(), y = in.nextInt();
            trans[x].add(y);
        }
        BigInteger ans = BigInteger.valueOf(1);
        for (char c : s) {
            Set<Integer> choice = new HashSet<>();
            choice.add(c - '0');
            while (true) {
                Set<Integer> nc = new HashSet<>();
                for (int x : choice) {
                    for (int y : trans[x]) {
                        if (!choice.contains(y)) nc.add(y);
                    }
                }
                if (nc.isEmpty()) break;
                choice.addAll(nc);
            }
            ans = ans.multiply(BigInteger.valueOf(choice.size()));
        }
        System.out.println(ans);
    }
}
