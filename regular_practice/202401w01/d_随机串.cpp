#include <cstdio>
#include <queue>

using namespace std;

const int N = 6e3 + 10, K = 26, M = 110, MOD = 1e4 + 7;
int n, m;
char pat[N];
int sons[N][K], idx, fail[N];
bool has[N];
int f[M][N][2];

void insert(char* s) {
    int p = 0;
    for (int k = 0; s[k]; ++k) {
        int i = s[k] - 'A';
        if (!sons[p][i]) sons[p][i] = ++idx;
        p = sons[p][i];
    }
    has[p] = true;
}

void build() {
    queue<int> que;
    for (int i = 0; i < K; ++i) {
        if (sons[0][i]) que.push(sons[0][i]);
    }
    while (!que.empty()) {
        int u = que.front(); que.pop();
        for (int i = 0; i < K; ++i) {
            int v = sons[u][i];
            if (v) {
                fail[v] = sons[fail[u]][i];
                que.push(v);
            } else sons[u][i] = sons[fail[u]][i];
        }
    }
}

int main() {
    scanf("%d%d", &n, &m);
    while (n--) {
        scanf("%s", pat);
        insert(pat);
    }
    build();
    f[0][0][0] = 1;
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j <= idx; ++j) {
            for (int k = 0; k < 2; ++k) {
                for (int c = 0; c < K; ++c) {
                    int v = sons[j][c];
                    f[i + 1][v][k | has[v]] = (f[i + 1][v][k | has[v]] + f[i][j][k]) % MOD;
                }
            }
        }
    }
    int ans = 0;
    for (int i = 0; i <= idx; ++i) ans = (ans + f[m][i][1]) % MOD;
    printf("%d\n", ans);

    return 0;
}