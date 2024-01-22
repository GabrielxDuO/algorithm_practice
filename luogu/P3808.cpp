#include <cstdio>
#include <queue>

using namespace std;

const int N = 1e6 + 10, M = 1e6 + 10, K = 26;
int t;
char pat[N], str[M];
int sons[N][K], cnts[N], idx, fail[N];

void insert(char* s) {
    int p = 0;
    for (int k = 0; s[k]; ++k) {
        int i = s[k] - 'a';
        if (!sons[p][i]) sons[p][i] = ++idx;
        p = sons[p][i];
    }
    ++cnts[p];
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
            if (v) fail[v] = sons[fail[u]][i], que.push(v);
            else sons[u][i] = sons[fail[u]][i];
        }
    }
}

int query(char* s) {
    int res = 0;
    for (int k = 0, u = 0; s[k]; ++k) {
        u = sons[u][s[k] - 'a'];
        for (int v = u; v && ~cnts[v]; v = fail[v]) {
            res += cnts[v], cnts[v] = -1;
        }
    }
    return res;
}

int main() {
    scanf("%d", &t);
    while (t--) {
        scanf("%s", pat);
        insert(pat);
    }
    build();
    scanf("%s", str);
    printf("%d\n", query(str));

    return 0;
}