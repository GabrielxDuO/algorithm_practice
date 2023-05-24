import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] s = in.readLine().toCharArray();
        Map<Character, List<Integer>> poses = new HashMap<>();
        int n = s.length;
        for (int i = 0; i < n; ++i) {
            poses.putIfAbsent(s[i], new ArrayList<>());
            List<Integer> lst = poses.get(s[i]);
            if (lst.isEmpty()) lst.add(-1);
            lst.add(i);
        }
        for (List<Integer> v : poses.values()) v.add(n);
        long ans = n;
        for (char c = 'a'; c <= 'z'; ++c) {
            if (poses.containsKey(c)) {
                List<Integer> lst = poses.get(c);
                for (int j = 1; j < lst.size() - 1; ++j) {
                    ans += lst.get(j) - lst.get(j - 1) - 1 + 
                           lst.get(j + 1) - lst.get(j) - 1 + 
                           1L * (lst.get(j) - lst.get(j - 1) - 1) *
                           (lst.get(j + 1) - lst.get(j) - 1);
                }
            }
        }
        System.out.println(ans);
    }
}
