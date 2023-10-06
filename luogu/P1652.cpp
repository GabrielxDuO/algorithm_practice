#include <cstdio>
#include <vector>

using namespace std;

const int N = 55;
int n;
int x[N], y[N], r[N];
int x1, y1, x2, y2;
vector<int> a;

int squ_dist(int x1, int y1, int x2, int y2) {
    int dx = x1 - x2, dy = y1 - y2;
    return dx * dx + dy * dy;
}

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d", &x[i]);
    for (int i = 0; i < n; ++i) scanf("%d", &y[i]);
    for (int i = 0; i < n; ++i) scanf("%d", &r[i]);
    scanf("%d%d%d%d", &x1, &y1, &x2, &y2);
    int ans = 0;
    for (int i = 0; i < n; ++i) {
        bool b1 = squ_dist(x1, y1, x[i], y[i]) < r[i] * r[i];
        bool b2 = squ_dist(x2, y2, x[i], y[i]) < r[i] * r[i];
        if (b1 ^ b2) ++ans;
    }
    printf("%d\n", ans);

    return 0;
}