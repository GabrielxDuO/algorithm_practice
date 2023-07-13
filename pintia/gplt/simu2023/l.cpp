#include <cstdio>
#include <cstring>
#include <vector>
#include <algorithm>

using namespace std;

const int N = 510, INF = 0x3f3f3f3f;
int n, k;
int g[N][N];
char s[2];
vector<int> sexs[2];
int w[N];

void floyd() {
    for (int k = 1; k <= n; ++k) {
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                g[i][j] = min(g[i][j], g[i][k] + g[k][j]);
            }
        }
    }
}

int main() {
    scanf("%d", &n);
    memset(g, 0x3f, sizeof(g));
    for (int u = 1; u <= n; ++u) g[u][u] = 0;
    for (int u = 1; u <= n; ++u) {
        scanf("%s %d", s, &k);
        sexs[s[0] == 'M'].push_back(u);
        int v, w;
        while (k--) {
            scanf("%d:%d", &v, &w);
            g[u][v] = min(g[u][v], w);
        }
    }
    floyd();
    for (int i = 0; i < 2; ++i) {
        int mn = INF;
        for (int u : sexs[i]) {
            int mx = 0;
            for (int v : sexs[!i]) {
                mx = max(mx, g[v][u]);
                if (mx > mn) goto out;
            }
            mn = w[u] = mx;
            out:;
        }
        bool is_first = true;
        for (int u : sexs[i]) {
            if (w[u] == mn) {
                if (!is_first) printf(" ");
                else is_first = false;
                printf("%d", u);
            }
        }
        puts("");
    }


    return 0;
}