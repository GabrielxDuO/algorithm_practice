import java.io.*;
public class _A {
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

        void add(Image img) {
            int imgWidth = img.w, imgHeight = img.h;
            if (w + imgWidth > M) {
                imgHeight = (imgHeight * (M - w) + imgWidth - 1) / imgWidth;
                imgWidth = M - w;
            }
            this.w += imgWidth;
            this.h = Math.max(this.h, imgHeight);
        }

        boolean isFull() {
            return this.w == M;
        }

        boolean isEmpty() {
            return this.w == 0 && this.h == 0;
        }

        void clear() {
            this.w = 0;
            this.h = 0;
        }

        Line copy() {
            return new Line(this.w, this.h);
        }
    }

    static int M, N;
    static Image[] imgs;
    static int[] f;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        M = (int) in.nval;
        in.nextToken();
        N = (int) in.nval;
        imgs = new Image[N];
        f = new int[N];
        for (int i = 0; i < N; ++i) {
            in.nextToken();
            int w = (int) in.nval;
            in.nextToken();
            int h = (int) in.nval;
            imgs[i] = new Image(w, h);
        }
        for (int i = N - 1; i >= 0; --i) {
            f[i] = addTillFull(new Line(), i);
        }
        /*
         * 
         */
        Line line = new Line();
        int minHeight = Integer.MAX_VALUE, totalHeight = 0;
        for (int del = 0; del < N; ++del) {
            int newHeight = totalHeight + (line.isEmpty() && del + 1 < N ?
                f[del + 1] : addTillFull(line.copy(), del + 1));
            minHeight = Math.min(minHeight, newHeight);
            line.add(imgs[del]);
            if (line.isFull()) {
                totalHeight += line.h;
                line.clear();
            }
        }
        System.out.println(minHeight);
    }

    static int addTillFull(Line line, int k) {
        for (; k < N && !line.isFull(); ++k) {
            line.add(imgs[k]);
        }
        return k < N ? line.h + f[k] : line.h;
    }
}