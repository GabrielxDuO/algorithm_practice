#include <cstdio>

using namespace std;

const int N = 1e5 + 10;
int n;
struct Polygen {
    int x, y;
} p[N];

int main() {
    scanf("%d", &n);
    if (n & 1) {
        puts("NO");
        return 0;
    }
    for (int i = 0; i < n; ++i) scanf("%d%d", &p[i].x, &p[i].y);
    double xx, yy;
    for (int i = 0; i < n / 2; ++i) {
        double cx = (p[i].x + p[i + n / 2].x) / 2.0;
        double cy = (p[i].y + p[i + n / 2].y) / 2.0;
        if (i == 0) xx = cx, yy = cy;
        else if (cx != xx || cy != yy) {
            puts("NO");
            return 0;
        }
    }
    puts("YES");

    return 0;
}