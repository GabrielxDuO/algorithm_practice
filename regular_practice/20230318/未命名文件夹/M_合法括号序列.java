import java.util.*;
import java.io.*;

public class Main {
    static int n = 4, cnt = 0;

    static void dfs(int l, int r) {
        if (r > l) return;
        if (l == 4) {
            ++cnt;
            return;
        }
        dfs(l + 1, r);
        dfs(l, r + 1);
    }

    public static void main(String[] args) throws IOException {
        dfs(0, 0);
        System.out.println(cnt);
    }
}