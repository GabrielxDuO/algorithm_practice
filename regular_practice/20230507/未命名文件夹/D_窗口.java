import java.util.*;
import java.io.*;

public class Main {
    static class Window {
        int top, left, height, width, level;

        public Window(int top, int left, int height, int width, int level) {
            this.top = top;
            this.left = left;
            this.height = height;
            this.width = width;
            this.level = level;
        }

        @Override
        public String toString() {
            return String.format("{%d, %d, %d, %d, %d}", top, left, height, width, level);
        }
    }

    static Map<Integer, Window> mp = new HashMap<>();
    static List<Window> wins;
    static char[][] g;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int m = (int) in.nval;
        in.nextToken(); int k = (int) in.nval;
        g = new char[n][m];
        for (char[] arr : g) Arrays.fill(arr, '.');
        int level = 0;
        while (k-- > 0) {
            in.nextToken(); String op = in.sval;
            in.nextToken(); int pid = (int) in.nval;
            if (op.equals("new")) {
                in.nextToken(); int t = (int) in.nval;
                in.nextToken(); int l = (int) in.nval;
                in.nextToken(); int h = (int) in.nval;
                in.nextToken(); int w = (int) in.nval;
                mp.put(pid, new Window(t, l, h, w, level++));
            } else if (op.equals("move")) {
                in.nextToken(); int v = (int) in.nval;
                in.nextToken(); int h = (int) in.nval;
                Window win = mp.get(pid);
                win.top += v;
                win.left += h;
                win.level = level++;
            } else if (op.equals("resize")) {
                in.nextToken(); int h = (int) in.nval;
                in.nextToken(); int w = (int) in.nval;
                Window win = mp.get(pid);
                win.height = h;
                win.width = w;
                win.level = level++;
            } else if (op.equals("close")) {
                mp.remove(pid);
            } else {
                mp.get(pid).level = level++;
            }
        }
        wins = new ArrayList<>(mp.values());
        wins.sort((a, b) -> a.level - b.level);
        // System.out.println(wins);
        for (Window win : wins) {
            int t = win.top, l = win.left;
            int h = win.height, w = win.width;
            for (int i = t; i < t + h; ++i) {
                for (int j = l; j < l + w; ++j) {
                    if (i >= 0 && i < n && j >= 0 && j < m) g[i][j] = ' ';
                }
            }
            for (int i = t; i < t + h; ++i) {
                if (i < 0 || i >= n) continue;
                if (l >= 0 && l < m) g[i][l] = '|';
                if (l + w - 1 >= 0 && l + w - 1 < m) g[i][l + w - 1] = '|';
            }
            for (int j = l; j < l + w; ++j) {
                if (j < 0 || j >= m) continue;
                if (t >= 0 && t < n) g[t][j] = '-';
                if (t + h - 1 >= 0 && t + h - 1 < n) g[t + h - 1][j] = '-';
            }
            int x = t, y = l;
            if (x >= 0 && x < n && y >= 0 && y < m) g[x][y] = '+';
            x += h - 1;
            if (x >= 0 && x < n && y >= 0 && y < m) g[x][y] = '+';
            y += w - 1;
            if (x >= 0 && x < n && y >= 0 && y < m) g[x][y] = '+';
            x -= h - 1;
            if (x >= 0 && x < n && y >= 0 && y < m) g[x][y] = '+';
        }
        for (char[] line : g) {
            System.out.println(String.valueOf(line));
        }
    }
}
