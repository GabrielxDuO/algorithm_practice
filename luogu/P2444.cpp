#include <cstdio>
#include <queue>

using namespace std;

const int N = 3e4 + 10, K = 2;
int n;
char pat[N];
int sons[N][K], idx, fail[N];
bool bad[N];
int stat[N];

void insert(char* s) {
    int p = 0;
    for (int k = 0; s[k]; ++k) {
        int i = s[k] - '0';
        if (!sons[p][i]) sons[p][i] = ++idx;
        p = sons[p][i];
    }
    bad[p] = true;
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
                bad[v] |= bad[fail[v]];
            } else sons[u][i] = sons[fail[u]][i];
        }
    }
}

bool dfs(int u) {
    if (stat[u] == 1) return true;
    if (stat[u] == -1) return false;
    stat[u] = 1;
    for (int i = 0; i < K; ++i) {
        int v = sons[u][i];
        if (!bad[v] && dfs(v)) return true;
    }
    stat[u] = -1;
    return false;
}

int main() {
    scanf("%d", &n);
    while (n--) {
        scanf("%s", pat);
        insert(pat);
    }
    build();
    puts(dfs(0) ? "TAK" : "NIE");

    return 0;
}