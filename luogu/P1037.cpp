#include <cstdio>
#include <cstring>

using namespace std;

const int N = 35, M = 15;
char s[N];
int k;
int h[N], e[N], ne[N], idx;
bool vis[M];
int cnts[M];
__int128 ans = 1LL;

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

int dfs(int u) {
    vis[u] = true;
    int cnt = 1;
    for (int i = h[u]; ~i; i = ne[i]) {
        int v = e[i];
        if (!vis[v]) cnt += dfs(v);
    }
    return cnt;
}

void print(__int128 x) {
    if (x < 0) putchar('-'), x = -x;
    if (x > 9) print(x / 10);
    putchar(x % 10 + '0');
}

int main() {
    scanf("%s%d", s, &k);
    memset(h, -1, sizeof(h));
    while (k--) {
        int a, b;
        scanf("%d%d", &a, &b);
        add(a, b);
    }
    for (int i = 0; i < 10; ++i) {
        memset(vis, false, sizeof(vis));
        cnts[i] = dfs(i);
    }
    for (int i = 0; s[i]; ++i) ans *= cnts[s[i] - '0'];
    print(ans);

    return 0;
}