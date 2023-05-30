#include <cstdio>
#include <cstring>
#include <queue>

using namespace std;

const int N = 700, M = 1e5 + 10, L = 1e3 + 10;
const double EPS = 1e-4;
int n;
char s[L];
int h[N], w[M], e[M], ne[M], idx;
double dists[N];
bool has[N];
int cnts[N];

void add(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

bool spfa_jdg(double m) {
    int entry = 0;
    memset(dists, 0, sizeof(dists));
    queue<int> que;
    memset(has, false, sizeof(has));
    memset(cnts, 0, sizeof(cnts));
    for (int u = 0; u < 676; ++u) que.push(u), has[u] = true;
    while (!que.empty()) {
        int u = que.front(); que.pop();
        has[u] = false;
        for (int i = h[u]; ~i; i = ne[i]) {
            int v = e[i];
            if (dists[u] + w[i] - m > dists[v]) {
                dists[v] = dists[u] + w[i] - m;
                cnts[v] = cnts[u] + 1;
                if (cnts[v] >= 676) return true;
                if (++entry > 1e4) return true;
                if (!has[v]) {
                    que.push(v);
                    has[v] = true;
                }
            }
        }
    }
    return false;
}

int main() {
    while (~scanf("%d", &n) && n) {
        memset(h, -1, sizeof(h));
        idx = 0;
        for (int i = 1; i <= n; ++i) {
            scanf("%s", s);
            int len = strlen(s);
            if (len < 2) continue;
            int st = (s[0] - 'a') * 26 + s[1] - 'a';
            int ed = (s[len - 2] - 'a') * 26 + s[len - 1] - 'a';
            add(st, ed, len);
        }
        if (!spfa_jdg(0)) {
            puts("No solution");
            continue;
        }
        double l = 0.0, r = 1000.0;
        while (r - l > EPS) {
            double m = (l + r) / 2;
            if (spfa_jdg(m)) l = m;
            else r = m;
        }
        printf("%lf\n", l);
    }

    return 0;
}