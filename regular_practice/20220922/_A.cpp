#include <iostream>

using namespace std;

const int MAX_N = 1e5 + 10;
int N, M;
int f[MAX_N];

struct Image {
    int w, h;
} imgs[MAX_N];

struct Line {
    int w, h;

    Line(int w = 0, int h = 0): w(w), h(h) { }

    Line operator+(const Image& img) {
        int img_w = img.w, img_h = img.h;
        if (w + img_w > M) {
            img_h = (img_h * (M - w) + img_w - 1) / img_w;
            img_w = M - w;
        }
        return Line(w + img_w, max(h, img_h));
    }

    Line operator+=(const Image& img) {
        return *this = *this + img;
    }

    bool full() {
        return w == M;
    }

    bool empty() {
        return w == 0 && h == 0;
    }

    void clear() {
        w = 0;
        h = 0;
    }
};

int addTillFull(Line line, int k) {
    for (; !line.full() && k < N; ++k) line += imgs[k];
    return line.h + f[k];
}

int main() {
    scanf("%d%d", &M, &N);
    for (int i = 0; i < N; ++i) scanf("%d%d", &imgs[i].w, &imgs[i].h);
    for (int i = N - 1; i >= 0; --i) f[i] = addTillFull(Line(), i);
    Line line; 
    int min_height = 0x3f3f3f3f, total_height = 0;
    for (int del = 0; del < N; ++del) {
        int new_height = total_height + (line.empty() ?
            f[del + 1] : addTillFull(line, del + 1));
        min_height = min(min_height, new_height);
        line += imgs[del];
        if (line.full()) {
            total_height += line.h;
            line.clear();
        }
    }
    printf("%d\n", min_height);

    return 0;
}