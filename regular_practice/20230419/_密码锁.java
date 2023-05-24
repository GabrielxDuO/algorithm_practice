import java.util.*;
import java.io.*;

public class _密码锁 {
    static void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        Set<String> vis = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        que.offer(s);
        vis.add(s);
        int step = 0;
        while (!que.isEmpty()) {
            int sz = que.size();
            while (sz-- > 0) {
                String curr = que.poll();
                if (curr.contains("2012")) {
                    System.out.println(step);
                    return;
                }
                char[] chs = curr.toCharArray();
                for (int i = 0; i < n - 1; ++i) {
                    swap(chs, i, i + 1);
                    String ns = String.valueOf(chs);
                    if (!vis.contains(ns)) {
                        que.offer(ns);
                        vis.add(ns);
                    }
                    swap(chs, i, i + 1);
                }
            }
            ++step;
        }
        System.out.println(-1);
    }
}
