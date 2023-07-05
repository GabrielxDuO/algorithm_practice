#include <cstdio>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 510, INF = 0x3f3f3f3f;
int n;
vector<int> sexs[2];
int g[N][N];
char s[2];
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
    for (int i = 1; i <= n; ++i) g[i][i] = 0;
    for (int u = 1; u <= n; ++u) {
        int k, v, w;
        scanf("%s %d", s, &k);
        sexs[s[0] == 'M'].push_back(u);
        while (k--) {
            scanf("%d:%d", &v, &w);
            g[u][v] = min(g[u][v], w);
        }
    }
    floyd();
    for (int i = 0; i < 2; ++i) {
        int mn = INF;
        for (const int& u : sexs[i]) {
            int mx = 0;
            for (const int& v : sexs[!i]) {
                mx = max(mx, g[v][u]);
                if (mx > mn) goto out;
            }
            w[u] = mx;
            mn = mx;
            out:;
        }
        bool first = true;
        for (const int& u : sexs[i]) {
            if (w[u] == mn) {
                if (!first) printf(" ");
                else first = false;
                printf("%d", u);
            }
        }
        puts("");
    }

    return 0;
}