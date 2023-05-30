#include <iostream>
#include <cstring>
#include <vector>

using namespace std;

const int N = 110, M = 10010, K = M / 2 * 4;
const int DIRS[][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
int n, t;
bool g[N][N];
vector<int> half;
int h[M], e[K], ne[K], idx;
bool vis[M];
int match[M];

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

bool find(int u) {
    for (int i = h[u]; ~i; i = ne[i]) {
        int v = e[i];
        if (vis[v]) continue;
        vis[v] = true;
        if (!match[v] || find(match[v])) {
            match[v] = u;
            return true;
        }
    }
    return false;
}

int main() {
    scanf("%d%d", &n, &t);
    while (t--) {
        int x, y;
        scanf("%d%d", &x, &y);
        g[x][y] = true;
    }
    memset(h, -1, sizeof(h));
    for (int x = 1; x <= n; ++x) {
        for (int y = 1 + (x & 1); y <= n;y += 2) {
            if (g[x][y]) continue;
            int a = (x - 1) * n + y;
            half.push_back(a);
            for (auto& DIR : DIRS) {
                int nx = x + DIR[0], ny = y + DIR[1];
                if (nx <= 0 || nx > n || ny <= 0 || ny > n || g[nx][ny]) continue;
                int b = (nx - 1) * n + ny;
                add(a, b);
            }
        }
    }
    int ans = 0;
    for (int u : half) {
        memset(vis, false, sizeof(vis));
        if (find(u)) ++ans;
    }
    printf("%d\n", ans);

    return 0;
}