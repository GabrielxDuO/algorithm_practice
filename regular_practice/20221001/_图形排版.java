import java.util.*;
import java.io.*;

public class _图形排版 {
    static int M, N;
    static Image[] imgs;
    static int[] f;

    static class Image {
        int w, h;

        Image(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }

    static class Line {
        int w, h;

        Line() { this(0, 0); }

        Line(int w, int h) {
            this.w = w;
            this.h = h;
        }

        Line(Line line) { this(line.w, line.h); }

        void add(Image img) {
            int imgW = img.w, imgH = img.h;
            if (w + imgW > M) {
                imgH = ((M - w) * imgH + imgW - 1) / imgW;
                imgW = M - w;
            }
            w = imgW + w;
            h = Math.max(h, imgH);
        }

        boolean isFull() { return w == M; }

        boolean isEmpty() { return w == 0 && h == 0; }

        void clear() {
            w = 0;
            h = 0;
        }
    }

    static int addTillFull(Line line, int k) {
        for (; !line.isFull() && k < N; ++k) line.add(imgs[k]);
        return k < N ? line.h + f[k] : line.h;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        M = (int) in.nval;
        in.nextToken();
        N = (int) in.nval;
        imgs = new Image[N];
        for (int i = 0; i < N; ++i) {
            in.nextToken();
            int w = (int) in.nval;
            in.nextToken();
            int h = (int) in.nval;
            imgs[i] = new Image(w, h);
        }
        f = new int[N];
        for (int i = N - 1; i >= 0; --i) f[i] = addTillFull(new Line(), i);
        int minHeight = Integer.MAX_VALUE, totalHeight = 0;
        Line curr = new Line();
        for (int i = 0; i < N; ++i) {
            int newHeight;
            if (curr.isEmpty() && i + 1 < N) newHeight = totalHeight + f[i + 1];
            else newHeight = totalHeight + addTillFull(new Line(curr), i + 1);
            minHeight = Math.min(minHeight, newHeight);
            curr.add(imgs[i]);
            if (curr.isFull()) {
                totalHeight += curr.h;
                curr.clear();
            }
        }
        System.out.println(minHeight);
    }
}
